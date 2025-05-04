package com.erp.erpclient.controller;

import com.erp.erpclient.entity.pinvoice.PurchaseInvoice;
import com.erp.erpclient.entity.pinvoice.PurchaseInvoiceItem;
import com.erp.erpclient.service.api.PurchaseInvoiceItemService;
import com.erp.erpclient.service.api.PurchaseInvoiceService;
import lombok.AllArgsConstructor;
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

//    @Data
//    private static class FufuRequest {
//        private String quotationId;
//        private String itemCode;
//        private Double newRate;
//    }
//
//    @Data
//    @AllArgsConstructor
//    private static class FufuResponse {
//        private boolean success;
//        private String message;
//        private Double updatedRate;
//    }
//
//    @PostMapping(value = "/set-paid", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<FufuResponse> setPaid(
//            @RequestBody FufuRequest request
//    ) {
//        boolean isPaid = true;
//
//        if (isPaid) {
//            return ResponseEntity.ok()
//                    .body(new FufuResponse(true, "Status updated successfully", request.getNewRate()));
//        } else {
//            return ResponseEntity.internalServerError()
//                    .body(new FufuResponse(false, "Failed to update rate in ERPNext", null));
//        }
//    }

}
