package com.erp.erpclient.entity.quotation;

import jakarta.persistence.*;

@Entity
@Table(name = "quotation_lost_reason_detail")
public class QuotationLostReasonDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lost_reason")
    private String lostReason;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;

    // Getters and Setters
}