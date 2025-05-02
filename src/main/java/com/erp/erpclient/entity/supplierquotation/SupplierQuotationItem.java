package com.erp.erpclient.entity.supplierquotation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SupplierQuotationItem {
    private String itemCode;
    private String itemName;
    private String description;
    private BigDecimal qty;
    private String uom;
    private BigDecimal rate;
    private BigDecimal amount;
    private Date expectedDeliveryDate;
}