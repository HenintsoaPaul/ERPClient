package com.erp.erpclient.entity.quotation;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "quotation_item")
public class QuotationItem {

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

    @Column(name = "warehouse")
    private String warehouse;

    // Add all other fields from ERPNext Quotation Item

    @ManyToOne
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;

    // Getters and Setters
}