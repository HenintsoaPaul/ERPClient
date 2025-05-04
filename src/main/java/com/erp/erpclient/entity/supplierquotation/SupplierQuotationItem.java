package com.erp.erpclient.entity.supplierquotation;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SupplierQuotationItem {
    private String itemCode;
    private String itemName;
    private BigDecimal qty;
    private String uom;
    private BigDecimal rate;
    private BigDecimal amount;
}