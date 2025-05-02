package com.erp.erpclient.entity.quotation;

import com.erp.erpclient.entity.Transaction;

// import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "quotation")
public class Quotation extends Transaction {

    // Fields specific to Quotation
//    @NotBlank
//    //@Column(name = "quotation_to", nullable = false)
    private String quotationTo = "Customer";

//    @NotBlank
//    //@Column(name = "party_name", nullable = false)
    private String partyName;

//    //@Column(name = "customer_name")
    private String customerName;

//    //@Temporal(TemporalType.DATE)
//    //@Column(name = "valid_till")
    private Date validTill;

//    @NotBlank
//    //@Column(name = "order_type", nullable = false)
    private String orderType = "Sales";

//    //@Column(name = "customer_address")
    private String customerAddress;

//    //@Column(name = "shipping_address_name")
    private String shippingAddressName;

//    //@Column(name = "customer_group")
    private String customerGroup;

//    //@Column(name = "territory")
    private String territory;

//    //@Column(name = "selling_price_list")
    private String sellingPriceList;

//    //@Column(name = "coupon_code")
    private String couponCode;

//    //@Column(name = "referral_sales_partner")
    private String referralSalesPartner;

//    //@Column(name = "opportunity")
    private String opportunity;

//    //@Column(name = "supplier_quotation")
    private String supplierQuotation;

//    //@Column(name = "company_address")
    private String companyAddress;

//    //@Column(name = "company_contact_person")
    private String companyContactPerson;

//    //@Column(name = "utm_campaign")
    private String utmCampaign;

//    //@Column(name = "utm_source")
    private String utmSource;

//    //@Column(name = "utm_medium")
    private String utmMedium;

//    //@Column(name = "utm_content")
    private String utmContent;

    // Status fields
//    @NotBlank
//    //@Column(name = "status", nullable = false)
    private String status = "Draft";

//    //@Column(name = "order_lost_reason")
    private String orderLostReason;

    // Financial fields
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

//    //@Column(name = "base_grand_total")
    private BigDecimal baseGrandTotal;

//    //@Column(name = "base_rounding_adjustment")
    private BigDecimal baseRoundingAdjustment;

//    //@Column(name = "base_in_words", length = 240)
    private String baseInWords;

//    //@Column(name = "base_rounded_total")
    private BigDecimal baseRoundedTotal;

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

    // Child tables
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "quotation_id")
    private List<QuotationItem> items;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "quotation_id")
    private List<QuotationLostReasonDetail> lostReasons;

    // todo: uncomment
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "quotation_id")
//    private List<PackedItem> packedItems;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "quotation_id")
//    private List<CompetitorDetail> competitors;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "quotation_id")
//    private List<PricingRuleDetail> pricingRules;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "quotation_id")
//    private List<SalesTaxesAndCharges> taxes;
//
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "quotation_id")
//    private List<PaymentSchedule> paymentSchedule;
    // todo: uncomment
}