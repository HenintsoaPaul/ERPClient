package com.erp.erpclient.entity.porder;

import com.erp.erpclient.entity.Transaction;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "purchase_order")
public class PurchaseOrder extends Transaction {

    // Fields specific to PurchaseOrder (not in Transaction base class)
    @Temporal(TemporalType.DATE)
    @Column(name = "schedule_date")
    private Date scheduleDate;

    @Column(name = "order_confirmation_no")
    private String orderConfirmationNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_confirmation_date")
    private Date orderConfirmationDate;

    @Column(name = "get_items_from_open_material_requests")
    private Boolean getItemsFromOpenMaterialRequests = false;

    @Column(name = "is_old_subcontracting_flow")
    private Boolean isOldSubcontractingFlow = false;

    @Column(name = "ref_sq")
    private String refSq;

    @Column(name = "inter_company_order_reference")
    private String interCompanyOrderReference;

    @Column(name = "drop_ship")
    private Boolean dropShip = false;

    @Column(name = "customer")
    private String customer;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_contact_person")
    private String customerContactPerson;

    @Column(name = "customer_contact_display")
    private String customerContactDisplay;

    @Column(name = "customer_contact_mobile")
    private String customerContactMobile;

    @Column(name = "customer_contact_email")
    private String customerContactEmail;

    @Column(name = "per_received")
    private BigDecimal perReceived;

    @Column(name = "per_billed")
    private BigDecimal perBilled;

    @Column(name = "advance_payment_status")
    private String advancePaymentStatus;

    @Column(name = "select_print_heading")
    private String selectPrintHeading;

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(name = "update_auto_repeat_reference")
    private Boolean updateAutoRepeatReference = false;

    @Column(name = "tax_withholding_net_total")
    private BigDecimal taxWithholdingNetTotal;

    @Column(name = "base_tax_withholding_net_total")
    private BigDecimal baseTaxWithholdingNetTotal;

    // todo: uncomment
//    // Child tables
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_order_id")
//    private List<PurchaseOrderItem> items;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_order_id")
//    private List<PricingRuleDetail> pricingRules;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_order_id")
//    private List<PurchaseOrderItemSupplied> suppliedItems;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_order_id")
//    private List<PurchaseTaxesAndCharges> taxes;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_order_id")
//    private List<PaymentSchedule> paymentSchedule;
    // todo: uncomment


    // Status fields with specific options for PurchaseOrder
    @NotBlank
    @Column(name = "status", nullable = false)
    private String status = "Draft"; // Options: Draft, On Hold, To Receive and Bill,
    // To Bill, To Receive, Completed, Cancelled, Closed, Delivered

    // Financial totals
    @Column(name = "total_qty")
    private BigDecimal totalQty;

    @Column(name = "total_net_weight")
    private BigDecimal totalNetWeight;

    @Column(name = "base_total")
    private BigDecimal baseTotal;

    @Column(name = "base_net_total")
    private BigDecimal baseNetTotal;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "net_total")
    private BigDecimal netTotal;

    @Column(name = "base_taxes_and_charges_added")
    private BigDecimal baseTaxesAndChargesAdded;

    @Column(name = "base_taxes_and_charges_deducted")
    private BigDecimal baseTaxesAndChargesDeducted;

    @Column(name = "base_total_taxes_and_charges")
    private BigDecimal baseTotalTaxesAndCharges;

    @Column(name = "taxes_and_charges_added")
    private BigDecimal taxesAndChargesAdded;

    @Column(name = "taxes_and_charges_deducted")
    private BigDecimal taxesAndChargesDeducted;

    @Column(name = "total_taxes_and_charges")
    private BigDecimal totalTaxesAndCharges;

    @Column(name = "base_grand_total")
    private BigDecimal baseGrandTotal;

    @Column(name = "base_rounding_adjustment")
    private BigDecimal baseRoundingAdjustment;

    @Column(name = "base_in_words", length = 240)
    private String baseInWords;

    @Column(name = "base_rounded_total")
    private BigDecimal baseRoundedTotal;

    @Column(name = "grand_total")
    private BigDecimal grandTotal;

    @Column(name = "rounding_adjustment")
    private BigDecimal roundingAdjustment;

    @Column(name = "rounded_total")
    private BigDecimal roundedTotal;

    @Column(name = "in_words", length = 240)
    private String inWords;

    @Column(name = "disable_rounded_total")
    private Boolean disableRoundedTotal = false;

    @Column(name = "advance_paid")
    private BigDecimal advancePaid;

    // Getters and Setters
    // (Omitted for brevity but should be included in actual implementation)

    // Constructors
    public PurchaseOrder() {
        // Default constructor
    }

    // Business methods could be added here
}