package com.erp.erpclient.entity.pinvoice;

import jakarta.persistence.*;
import java.math.BigDecimal;

//@Entity
//@Table(name = "purchase_invoice_advance")
public class PurchaseInvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "qty", precision = 21, scale = 9)
    private BigDecimal qty;

    @Column(name = "rate", precision = 21, scale = 9)
    private BigDecimal rate;

    @Column(name = "amount", precision = 21, scale = 9)
    private BigDecimal amount;

    // Add all other fields from ERPNext Purchase Invoice Item

    @ManyToOne
    @JoinColumn(name = "purchase_invoice_id")
    private PurchaseInvoice purchaseInvoice;
}
