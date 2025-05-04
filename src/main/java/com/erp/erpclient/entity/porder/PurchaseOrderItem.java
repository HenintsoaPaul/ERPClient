package com.erp.erpclient.entity.porder;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchaseOrderItem {
    private String name;
    private String itemCode;
    private String itemName;
    private String description;
    private String uom;
    private BigDecimal qty;
    private BigDecimal rate;
    private BigDecimal amount;
    private String warehouse;
    private Date scheduleDate;
}