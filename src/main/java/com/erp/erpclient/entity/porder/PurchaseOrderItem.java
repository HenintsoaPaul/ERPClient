package com.erp.erpclient.entity.porder;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseOrderItem {

    private Long id;
    private String itemCode;
    private String itemName;
    private String description;
    private BigDecimal qty;
    private BigDecimal rate;
    private BigDecimal amount;
    private String warehouse;
    private Date scheduleDate;

    // Add all other fields from ERPNext Purchase Order Item
    private PurchaseOrder purchaseOrder;

}