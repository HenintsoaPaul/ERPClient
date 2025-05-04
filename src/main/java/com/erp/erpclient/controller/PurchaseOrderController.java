package com.erp.erpclient.controller;

import com.erp.erpclient.entity.porder.PurchaseOrder;
import com.erp.erpclient.entity.porder.PurchaseOrderItem;
import com.erp.erpclient.service.api.PurchaseOrderItemService;
import com.erp.erpclient.service.api.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;
    private final PurchaseOrderItemService purchaseOrderItemService;

    @GetMapping
    public String findAll(
            @RequestParam(name = "supplier_name") String supplierName,
            Model model
    ) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.findAllBySupplier(supplierName).message();

        model.addAttribute("purchaseOrders", purchaseOrders);

        return "purchase-order/index";
    }

    @GetMapping("/fiche")
    public String fiche(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "sp_name") String supplierName,
            Model model
    ) {
        PurchaseOrder po = purchaseOrderService.findAllBySupplier(supplierName).message().get(0);

        model.addAttribute("po", po);

        List<PurchaseOrderItem> items = purchaseOrderItemService.findAllBySupplier(name).message();

        model.addAttribute("items", items);

        return "purchase-order/fiche";
    }

}
