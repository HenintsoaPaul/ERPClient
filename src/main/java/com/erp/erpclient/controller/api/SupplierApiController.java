package com.erp.erpclient.controller.api;

import com.erp.erpclient.dto.SupplierResponse;
import com.erp.erpclient.service.api.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierApiController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<SupplierResponse> findAll() {
        return ResponseEntity.ok(supplierService.findAll());
    }

}
