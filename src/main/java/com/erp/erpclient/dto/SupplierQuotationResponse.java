package com.erp.erpclient.dto;

import com.erp.erpclient.entity.Supplier;
import com.erp.erpclient.entity.supplierquotation.SupplierQuotation;

import java.util.List;

public record SupplierQuotationResponse(
        List<SupplierQuotation> message
) {}