package com.erp.erpclient.controller;

import com.erp.erpclient.entity.supplierquotation.SupplierQuotation;
import com.erp.erpclient.entity.supplierquotation.SupplierQuotationItem;
import com.erp.erpclient.service.api.SupplierQuotationItemService;
import com.erp.erpclient.service.api.SupplierQuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

}
