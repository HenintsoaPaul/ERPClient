package com.erp.erpclient.controller;

import com.erp.erpclient.entity.pinvoice.PurchaseInvoice;
import com.erp.erpclient.entity.pinvoice.PurchaseInvoiceItem;
import com.erp.erpclient.service.api.PurchaseInvoiceItemService;
import com.erp.erpclient.service.api.PurchaseInvoiceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchase-invoices")
@RequiredArgsConstructor
public class PurchaseInvoiceController {

    private final PurchaseInvoiceService purchaseInvoiceService;
    private final PurchaseInvoiceItemService purchaseInvoiceItemService;

    @GetMapping
    public String findAll(
            @RequestParam(name = "supplier_name") String supplierName,
            Model model
    ) {
        List<PurchaseInvoice> purchaseInvoices = purchaseInvoiceService.findAllBySupplier(supplierName).message();

        model.addAttribute("purchaseInvoices", purchaseInvoices);

        return "purchase-invoice/index";
    }

    @GetMapping("/fiche")
    public String fiche(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "sp_name") String supplierName,
            Model model
    ) {
        PurchaseInvoice po = purchaseInvoiceService.findAllBySupplier(supplierName).message().get(0);

        model.addAttribute("po", po);

        List<PurchaseInvoiceItem> items = purchaseInvoiceItemService.findAllBySupplier(name).message();

        model.addAttribute("items", items);

        return "purchase-invoice/fiche";
    }

    @Data
    private static class FufuRequest {
        private String purchaseInvoiceId;
        private String postingDate;
        private double amount;
    }

    @PostMapping(value = "/add-payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPayment(
            @RequestBody FufuRequest request
    ) {
        String ok = purchaseInvoiceService.addPayment(
                request.getPurchaseInvoiceId(),
                request.getAmount(),
                request.getPostingDate(),
                "Cash",
                "remark be lele"
        );

        if (ok.equals("ok")) {
            return ResponseEntity.ok()
                    .body("Paid successfully");
        } else {
            return ResponseEntity.internalServerError()
                    .body("Failed to add payment entry in ERPNext");
        }
    }

}
