package com.erp.erpclient.controller;

import com.erp.erpclient.entity.supplierquotation.SupplierQuotation;
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

    @GetMapping
    public String findAllBySupplierName(
            @RequestParam(name = "name") String supplierName,
            Model model
    ) {
        List<SupplierQuotation> suppliers = supplierQuotationService.findAllBySupplier(supplierName).message();

        model.addAttribute("supplierQuotations", suppliers);

        return "suppliers/quotations";
    }

}
