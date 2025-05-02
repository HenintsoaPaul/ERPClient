package com.erp.erpclient.entity.supplierquotation;

import com.erp.erpclient.entity.Transaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

// import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
//@Entity
//@Table(name = "supplier_quotation")
public class SupplierQuotation extends Transaction {

    // Section: Supplier Information
//    //@Column(name = "supplier_section", insertable = false, updatable = false)
    private String supplierSection; // Marker for UI section

//    //@Column(name = "valid_till")
    //@Temporal(TemporalType.DATE)
    private Date validTill;

//    //@Column(name = "quotation_number")
    private String quotationNumber;

    // Section: Currency and Price List
//    //@Column(name = "currency_and_price_list", insertable = false, updatable = false)
    private String currencyAndPriceList; // Marker for UI section

    // Section: Items
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "parent_id")
    private List<SupplierQuotationItem> items;

    // Section: Taxes
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "parent_id")
    private List<PurchaseTaxesAndCharges> taxes;

//    //@Column(name = "tax_breakup", columnDefinition = "TEXT")
    private String taxBreakup;

    // Section: Totals
//    //@Column(name = "total_qty", precision = 20, scale = 6)
    private BigDecimal totalQty;

//    //@Column(name = "base_total", precision = 20, scale = 6)
    private BigDecimal baseTotal;

//    //@Column(name = "total", precision = 20, scale = 6)
    private BigDecimal total;

//    //@Column(name = "base_net_total", precision = 20, scale = 6)
    private BigDecimal baseNetTotal;

//    //@Column(name = "net_total", precision = 20, scale = 6)
    private BigDecimal netTotal;

//    //@Column(name = "total_net_weight", precision = 20, scale = 6)
    private BigDecimal totalNetWeight;

    // Section: Additional Discount
//    //@Column(name = "apply_discount_on")
    private String applyDiscountOn = "Grand Total";

//    //@Column(name = "additional_discount_percentage", precision = 5, scale = 2)
    private BigDecimal additionalDiscountPercentage;

//    //@Column(name = "discount_amount", precision = 20, scale = 6)
    private BigDecimal discountAmount;

//    //@Column(name = "base_discount_amount", precision = 20, scale = 6)
    private BigDecimal baseDiscountAmount;

    // Section: Grand Totals
//    //@Column(name = "base_grand_total", precision = 20, scale = 6)
    private BigDecimal baseGrandTotal;

//    //@Column(name = "grand_total", precision = 20, scale = 6)
    private BigDecimal grandTotal;

//    //@Column(name = "base_rounding_adjustment", precision = 20, scale = 6)
    private BigDecimal baseRoundingAdjustment;

//    //@Column(name = "rounding_adjustment", precision = 20, scale = 6)
    private BigDecimal roundingAdjustment;

//    //@Column(name = "base_rounded_total", precision = 20, scale = 6)
    private BigDecimal baseRoundedTotal;

//    //@Column(name = "rounded_total", precision = 20, scale = 6)
    private BigDecimal roundedTotal;

//    //@Column(name = "base_in_words")
    private String baseInWords;

//    //@Column(name = "in_words")
    private String inWords;

//    //@Column(name = "disable_rounded_total")
    private Boolean disableRoundedTotal = false;

    // Section: Terms and Conditions
//    //@Column(name = "tc_name")
    private String termsAndConditionsTemplate;

    // Section: Printing Settings
//    //@Column(name = "select_print_heading")
    private String printHeading;

    // Section: Auto Repeat
//    //@Column(name = "auto_repeat")
    private String autoRepeat;

    // Section: Status
    //@Enumerated(EnumType.STRING)
//    //@Column(name = "status")
    private Status status = Status.DRAFT;

    // Section: Additional Info
//    //@Column(name = "opportunity")
    private String opportunity;

    public enum Status {
        DRAFT, SUBMITTED, STOPPED, CANCELLED, EXPIRED
    }

    // Section: Pricing Rules
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "parent_id")
    private List<PricingRuleDetail> pricingRules;

    // Section: Other totals
//    //@Column(name = "base_taxes_and_charges_added", precision = 20, scale = 6)
    private BigDecimal baseTaxesAndChargesAdded;

//    //@Column(name = "taxes_and_charges_added", precision = 20, scale = 6)
    private BigDecimal taxesAndChargesAdded;

//    //@Column(name = "base_taxes_and_charges_deducted", precision = 20, scale = 6)
    private BigDecimal baseTaxesAndChargesDeducted;

//    //@Column(name = "taxes_and_charges_deducted", precision = 20, scale = 6)
    private BigDecimal taxesAndChargesDeducted;

//    //@Column(name = "base_total_taxes_and_charges", precision = 20, scale = 6)
    private BigDecimal baseTotalTaxesAndCharges;

//    //@Column(name = "total_taxes_and_charges", precision = 20, scale = 6)
    private BigDecimal totalTaxesAndCharges;

    // Other fields
//    //@Column(name = "other_charges_calculation", columnDefinition = "TEXT")
    private String otherChargesCalculation;

//    //@Column(name = "amended_from")
    private String amendedFrom;
}