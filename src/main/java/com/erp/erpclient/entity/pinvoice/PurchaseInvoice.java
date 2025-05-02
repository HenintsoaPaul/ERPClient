package com.erp.erpclient.entity.pinvoice;

import com.erp.erpclient.entity.Transaction;

// import jakarta.persistence.*;
//import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "purchase_invoice")
public class PurchaseInvoice extends Transaction {

    //    //@Column(name = "tax_id")
    private String taxId;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "due_date")
    private Date dueDate;

    //    //@Column(name = "is_paid")
    private Boolean isPaid = false;

    //    //@Column(name = "is_return")
    private Boolean isReturn = false;

    //    //@Column(name = "apply_tds")
    private Boolean applyTds = false;

    //    //@Column(name = "on_hold")
    private Boolean onHold = false;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "release_date")
    private Date releaseDate;

    //    //@Column(name = "hold_comment")
    private String holdComment;

    //    //@Column(name = "bill_no")
    private String billNo;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "bill_date")
    private Date billDate;

    //    //@Column(name = "return_against")
    private String returnAgainst;

    //    //@Column(name = "update_billed_amount_in_purchase_order")
    private Boolean updateBilledAmountInPurchaseOrder = false;

    //    //@Column(name = "update_billed_amount_in_purchase_receipt")
    private Boolean updateBilledAmountInPurchaseReceipt = true;

    //    //@Column(name = "posting_time")
    private String postingTime;

    //    //@Column(name = "set_posting_time")
    private Boolean setPostingTime = false;

    //    //@Column(name = "amended_from")
    private String amendedFrom;

    //    //@Column(name = "set_warehouse")
    private String setWarehouse;

    //    //@Column(name = "rejected_warehouse")
    private String rejectedWarehouse;

    //    //@Column(name = "update_stock")
    private Boolean updateStock = false;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_invoice_id")
    private List<PurchaseInvoiceItem> items;

    //    //@Column(name = "total_qty")
    private BigDecimal totalQty;

    //    //@Column(name = "total_net_weight")
    private BigDecimal totalNetWeight;

    //    //@Column(name = "base_total")
    private BigDecimal baseTotal;

    //    //@Column(name = "base_net_total")
    private BigDecimal baseNetTotal;

    //    //@Column(name = "total")
    private BigDecimal total;

    //    //@Column(name = "net_total")
    private BigDecimal netTotal;

    // todo: uncomment
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "purchase_invoice_id")
//    private List<PricingRuleDetail> pricingRules;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "purchase_invoice_id")
//    private List<PurchaseReceiptItemSupplied> suppliedItems;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    /// /    @JoinColumn(name = "purchase_invoice_id")
//    private List<PurchaseTaxesAndCharges> taxes;
// todo: uncomment


//    //@Column(name = "base_taxes_and_charges_added")
    private BigDecimal baseTaxesAndChargesAdded;

    //    //@Column(name = "base_taxes_and_charges_deducted")
    private BigDecimal baseTaxesAndChargesDeducted;

    //    //@Column(name = "base_total_taxes_and_charges")
    private BigDecimal baseTotalTaxesAndCharges;

    //    //@Column(name = "taxes_and_charges_added")
    private BigDecimal taxesAndChargesAdded;

    //    //@Column(name = "taxes_and_charges_deducted")
    private BigDecimal taxesAndChargesDeducted;

    //    //@Column(name = "total_taxes_and_charges")
    private BigDecimal totalTaxesAndCharges;

    //    //@Column(name = "apply_discount_on")
    private String applyDiscountOn = "Grand Total";

    //    //@Column(name = "base_discount_amount")
    private BigDecimal baseDiscountAmount;

    //    //@Column(name = "additional_discount_percentage")
    private BigDecimal additionalDiscountPercentage;

    //    //@Column(name = "discount_amount")
    private BigDecimal discountAmount;

    //    //@Column(name = "base_grand_total")
    private BigDecimal baseGrandTotal;

    //    //@Column(name = "base_rounding_adjustment")
    private BigDecimal baseRoundingAdjustment;

    //    //@Column(name = "base_rounded_total")
    private BigDecimal baseRoundedTotal;

    //    //@Column(name = "base_in_words", length = 240)
    private String baseInWords;

    //    //@Column(name = "grand_total")
    private BigDecimal grandTotal;

    //    //@Column(name = "rounding_adjustment")
    private BigDecimal roundingAdjustment;

    //    //@Column(name = "rounded_total")
    private BigDecimal roundedTotal;

    //    //@Column(name = "in_words", length = 240)
    private String inWords;

    //    //@Column(name = "disable_rounded_total")
    private Boolean disableRoundedTotal = false;

    //    //@Column(name = "total_advance")
    private BigDecimal totalAdvance;

    //    //@Column(name = "outstanding_amount")
    private BigDecimal outstandingAmount;

    //    //@Column(name = "mode_of_payment")
    private String modeOfPayment;

    //    //@Column(name = "cash_bank_account")
    private String cashBankAccount;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "clearance_date")
    private Date clearanceDate;

    //    //@Column(name = "paid_amount")
    private BigDecimal paidAmount;

    //    //@Column(name = "base_paid_amount")
    private BigDecimal basePaidAmount;

    //    //@Column(name = "write_off_amount")
    private BigDecimal writeOffAmount;

    //    //@Column(name = "base_write_off_amount")
    private BigDecimal baseWriteOffAmount;

    //    //@Column(name = "write_off_account")
    private String writeOffAccount;

    //    //@Column(name = "write_off_cost_center")
    private String writeOffCostCenter;

    //    //@Column(name = "allocate_advances_automatically")
    private Boolean allocateAdvancesAutomatically = false;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "purchase_invoice_id")
    private List<PurchaseInvoiceAdvance> advances;

    //    //@Column(name = "payment_terms_template")
    private String paymentTermsTemplate;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "purchase_invoice_id")
//    private List<PaymentSchedule> paymentSchedule;

    //    //@Column(name = "tc_name")
    private String tcName;

    //    //@Column(name = "credit_to")
    private String creditTo;

    //    //@Column(name = "is_opening")
    private String isOpening = "No";

    //    //@Column(name = "against_expense_account")
    private String againstExpenseAccount;

//    @NotBlank
//    //@Column(name = "status", nullable = false)
    private String status = "Draft";

    //    //@Column(name = "inter_company_invoice_reference")
    private String interCompanyInvoiceReference;

    //    //@Column(name = "remarks")
    private String remarks;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "from_date")
    private Date fromDate;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "to_date")
    private Date toDate;

    //    //@Column(name = "auto_repeat")
    private String autoRepeat;

    //    //@Column(name = "tax_withholding_category")
    private String taxWithholdingCategory;

    //    //@Column(name = "unrealized_profit_loss_account")
    private String unrealizedProfitLossAccount;

    //    //@Column(name = "set_from_warehouse")
    private String setFromWarehouse;

    //    //@Column(name = "per_received")
    private BigDecimal perReceived;

    //    //@Column(name = "ignore_default_payment_terms_template")
    private Boolean ignoreDefaultPaymentTermsTemplate = false;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "purchase_invoice_id")
//    private List<AdvanceTax> advanceTax;

    //    //@Column(name = "subscription")
    private String subscription;

    //    //@Column(name = "is_old_subcontracting_flow")
    private Boolean isOldSubcontractingFlow = false;

    //    //@Column(name = "tax_withholding_net_total")
    private BigDecimal taxWithholdingNetTotal;

    //    //@Column(name = "base_tax_withholding_net_total")
    private BigDecimal baseTaxWithholdingNetTotal;

//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "purchase_invoice_id")
//    private List<TaxWithheldVouchers> taxWithheldVouchers;

    //    //@Column(name = "only_include_allocated_payments")
    private Boolean onlyIncludeAllocatedPayments = false;

    //    //@Column(name = "use_company_roundoff_cost_center")
    private Boolean useCompanyRoundoffCostCenter = false;

    //    //@Column(name = "use_transaction_date_exchange_rate")
    private Boolean useTransactionDateExchangeRate = false;

    //    //@Column(name = "supplier_group")
    private String supplierGroup;

    //    //@Column(name = "update_outstanding_for_self")
    private Boolean updateOutstandingForSelf = true;

    //    //@Column(name = "sender")
    private String sender;

    //    //@Column(name = "dispatch_address")
    private String dispatchAddress;

    //    //@Column(name = "dispatch_address_display", columnDefinition = "TEXT")
    private String dispatchAddressDisplay;

    // Getters and Setters
    // (Omitted for brevity but should be included in actual implementation)

    // Constructors
    // (Omitted for brevity but should be included in actual implementation)
}