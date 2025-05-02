package com.erp.erpclient.dto;

import com.erp.erpclient.entity.Supplier;

import java.util.List;

public record SupplierResponse(
        List<Supplier> message
) {}