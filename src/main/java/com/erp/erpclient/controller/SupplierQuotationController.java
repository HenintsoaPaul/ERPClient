package com.erp.erpclient.controller;

import com.erp.erpclient.entity.supplierquotation.SupplierQuotation;
import com.erp.erpclient.entity.supplierquotation.SupplierQuotationItem;
import com.erp.erpclient.entity.supplierquotation.UpdateRequest;
import com.erp.erpclient.service.api.SupplierQuotationItemService;
import com.erp.erpclient.service.api.SupplierQuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/supplier-quotations")
@RequiredArgsConstructor
public class SupplierQuotationController {

    private final SupplierQuotationService supplierQuotationService;
    private final SupplierQuotationItemService supplierQuotationItemService;

    @GetMapping
    public String findAllBySupplierName(
            @RequestParam(name = "supplier_name") String supplierName,
            Model model
    ) {
        List<SupplierQuotation> suppliers = supplierQuotationService.findAllBySupplier(supplierName).message();

        model.addAttribute("supplierQuotations", suppliers);

        return "supplier-quotation/index";
    }

    @GetMapping("/fiche")
    public String findFiche(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "sp_name") String supplierName,
            Model model
    ) {
        SupplierQuotation sq = supplierQuotationService.findAllBySupplier(supplierName).message().get(0);

        model.addAttribute("sq", sq);

        List<SupplierQuotationItem> items = supplierQuotationItemService.findAllBySupplier(name).message();

        model.addAttribute("items", items);

        return "supplier-quotation/fiche";
    }

    @PostMapping(value = "/update-item-rate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upItemRate(
            @RequestBody UpdateRequest request
    ) {
        try {
            supplierQuotationItemService.updateRate(
                    request.itemId(),
                    request.newRate(),
                    request.newQty()
            );
            return ResponseEntity.ok("Updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/submit")
    public String submit(
        @RequestParam(name = "quotation_name") String quotationName,
        @RequestParam(name = "sp_name") String spName
    ) {
        supplierQuotationService.submitByName(quotationName);

        return "redirect:/supplier-quotations/fiche?name=" + quotationName + "&sp_name=" + spName;
    }

}
