package com.erp.erpclient.dto;

import com.erp.erpclient.entity.supplierquotation.SupplierQuotationItem;

import java.util.List;

public record SupplierQuotationItemResponse(
        List<SupplierQuotationItem> message
) {}