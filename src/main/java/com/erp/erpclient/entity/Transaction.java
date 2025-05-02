package com.erp.erpclient.entity;

//import jakarta.persistence.MappedSuperclass;
import lombok.Data;

// import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
//@MappedSuperclass
public abstract class Transaction {

    private Long id;

//    @NotBlank
//    //@Column(name = "title", nullable = false)
    private String title;

//    @NotBlank
//    //@Column(name = "naming_series", nullable = false)
    private String namingSeries;

//    @NotBlank
//    //@Column(name = "supplier", nullable = false)
    private String supplier;

//    @NotBlank
//    //@Column(name = "supplier_name", nullable = false)
    private String supplierName;

//    @NotBlank
//    //@Column(name = "company", nullable = false)
    private String company;

//    @NotNull
//    //@Temporal(TemporalType.DATE)
//    //@Column(name = "posting_date", nullable = false)
    private Date postingDate = new Date();

//    //@Column(name = "currency")
    private String currency;

//    @DecimalMin("0.000000001")
//    //@Column(name = "conversion_rate", precision = 9, scale = 9)
    private BigDecimal conversionRate;

//    //@Column(name = "buying_price_list")
    private String buyingPriceList;

//    //@Column(name = "price_list_currency")
    private String priceListCurrency;

//    //@Column(name = "plc_conversion_rate", precision = 9, scale = 9)
    private BigDecimal plcConversionRate;

//    //@Column(name = "ignore_pricing_rule")
    private Boolean ignorePricingRule = false;

//    //@Column(name = "is_subcontracted")
    private Boolean isSubcontracted = false;

//    //@Column(name = "supplier_warehouse")
    private String supplierWarehouse;

//    //@Column(name = "cost_center")
    private String costCenter;

//    //@Column(name = "project")
    private String project;

//    //@Column(name = "tax_category")
    private String taxCategory;

//    //@Column(name = "taxes_and_charges")
    private String taxesAndCharges;

//    //@Column(name = "shipping_rule")
    private String shippingRule;

//    //@Column(name = "incoterm")
    private String incoterm;

//    //@Column(name = "named_place")
    private String namedPlace;

//    //@Column(name = "supplier_address")
    private String supplierAddress;

//    //@Column(name = "address_display", columnDefinition = "TEXT")
    private String addressDisplay;

//    //@Column(name = "contact_person")
    private String contactPerson;

//    //@Column(name = "contact_display")
    private String contactDisplay;

//    //@Column(name = "contact_mobile")
    private String contactMobile;

//    //@Column(name = "contact_email")
    private String contactEmail;

//    //@Column(name = "shipping_address")
    private String shippingAddress;

//    //@Column(name = "shipping_address_display", columnDefinition = "TEXT")
    private String shippingAddressDisplay;

//    //@Column(name = "billing_address")
    private String billingAddress;

//    //@Column(name = "billing_address_display", columnDefinition = "TEXT")
    private String billingAddressDisplay;

//    //@Column(name = "terms", columnDefinition = "TEXT")
    private String terms;

//    //@Column(name = "letter_head")
    private String letterHead;

//    //@Column(name = "group_same_items")
    private Boolean groupSameItems = false;

//    //@Column(name = "language")
    private String language;

//    //@Column(name = "is_internal_supplier")
    private Boolean isInternalSupplier = false;

//    //@Column(name = "represents_company")
    private String representsCompany;

//    //@Column(name = "party_account_currency")
    private String partyAccountCurrency;
}