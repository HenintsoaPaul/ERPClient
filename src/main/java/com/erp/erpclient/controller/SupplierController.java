package com.erp.erpclient.controller;

import com.erp.erpclient.entity.Supplier;
import com.erp.erpclient.service.api.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public String findAll(Model model) {
        List<Supplier> suppliers = supplierService.findAll().message();

        model.addAttribute("suppliers", suppliers);

        return "suppliers/index";
    }

}
