package com.erp.erpclient.entity.porder;

// import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//@Entity
//@Table(name = "purchase_order_item")
public class PurchaseOrderItem {


    private Long id;

//    //@Column(name = "item_code")
    private String itemCode;

//    //@Column(name = "item_name")
    private String itemName;

//    //@Column(name = "description")
    private String description;

//    //@Column(name = "qty", precision = 21, scale = 9)
    private BigDecimal qty;

//    //@Column(name = "rate", precision = 21, scale = 9)
    private BigDecimal rate;

//    //@Column(name = "amount", precision = 21, scale = 9)
    private BigDecimal amount;

//    //@Column(name = "warehouse")
    private String warehouse;

//    //@Column(name = "schedule_date")
    private Date scheduleDate;

    // Add all other fields from ERPNext Purchase Order Item

//    @ManyToOne
//    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    // Getters and Setters
}