package com.erp.erpclient.entity.pinvoice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseInvoiceItem {

    private Long id;
    private String itemCode;
    private String itemName;
    private String description;
    private BigDecimal qty;
    private BigDecimal rate;
    private BigDecimal amount;
}
