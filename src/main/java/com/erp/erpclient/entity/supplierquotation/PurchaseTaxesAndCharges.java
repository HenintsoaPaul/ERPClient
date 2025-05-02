package com.erp.erpclient.entity.supplierquotation;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseTaxesAndCharges {
    private String chargeType;
    private String accountHead;
    private String description;
    private BigDecimal rate;
    private BigDecimal taxAmount;
    private BigDecimal total;
}