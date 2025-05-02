package com.erp.erpclient.entity;

import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "material_request")
public class MaterialRequest extends Transaction {

    // Fields specific to Material Request
//    @NotBlank
    @Column(name = "material_request_type", nullable = false)
    private String materialRequestType; // Purchase, Material Transfer, Material Issue, etc.

    @Column(name = "customer")
    private String customer; // Only for "Customer Provided" type

    @Temporal(TemporalType.DATE)
    @Column(name = "schedule_date")
    private Date scheduleDate;

    @Column(name = "set_warehouse")
    private String setWarehouse;

    @Column(name = "set_from_warehouse")
    private String setFromWarehouse; // For Material Transfer type

    @Column(name = "transfer_status")
    private String transferStatus; // Not Started, In Transit, Completed

    @Column(name = "work_order")
    private String workOrder;

    @Column(name = "job_card")
    private String jobCard;

    // Status fields
//    @NotBlank
    @Column(name = "status", nullable = false)
    private String status = "Draft";

    @Column(name = "per_ordered")
    private BigDecimal perOrdered;

    @Column(name = "per_received")
    private BigDecimal perReceived;

    // Child tables
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "material_request_id")
    private List<MaterialRequestItem> items;
}