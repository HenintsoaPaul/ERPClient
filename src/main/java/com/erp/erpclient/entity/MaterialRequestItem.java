package com.erp.erpclient.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "material_request_item")
public class MaterialRequestItem {

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

    @Column(name = "uom")
    private String uom;

    @Column(name = "warehouse")
    private String warehouse;

    @Column(name = "schedule_date")
    private Date scheduleDate;

    // Add all other fields from ERPNext Material Request Item

    @ManyToOne
    @JoinColumn(name = "material_request_id")
    private MaterialRequest materialRequest;
}