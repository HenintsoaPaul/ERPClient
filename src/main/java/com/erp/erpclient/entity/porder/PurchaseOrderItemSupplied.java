package com.erp.erpclient.entity.porder;

import jakarta.persistence.*;
import java.math.BigDecimal;

//@Entity
//@Table(name = "purchase_order_item_supplied")
public class PurchaseOrderItemSupplied {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_item_code")
    private String mainItemCode;

    @Column(name = "rm_item_code")
    private String rmItemCode;

    @Column(name = "required_qty", precision = 21, scale = 9)
    private BigDecimal requiredQty;

    @Column(name = "supplied_qty", precision = 21, scale = 9)
    private BigDecimal suppliedQty;

    @Column(name = "rate", precision = 21, scale = 9)
    private BigDecimal rate;

    @Column(name = "amount", precision = 21, scale = 9)
    private BigDecimal amount;

//    @ManyToOne
//    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    // Getters and Setters
}