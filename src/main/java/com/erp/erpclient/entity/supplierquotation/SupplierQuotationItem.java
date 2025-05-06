package com.erp.erpclient.entity.supplierquotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierQuotationItem {
    private String name;
    private String itemCode;
    private String itemName;
    private BigDecimal qty;
    private String uom;
    private BigDecimal rate;
    private BigDecimal amount;
}