package com.erp.erpclient.entity.item;

// import jakarta.persistence.*;
import lombok.Data;
//import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Item {

    private Long id;

//    @NotBlank
//    //@Column(name = "item_code", nullable = false, unique = true)
    private String itemCode;

//    //@Column(name = "naming_series")
    private String namingSeries;

//    //@Column(name = "variant_of")
    private String variantOf;

//    @NotBlank
//    //@Column(name = "item_name", nullable = false)
    private String itemName;

//    @NotBlank
//    //@Column(name = "item_group", nullable = false)
    private String itemGroup;

//    @NotBlank
//    //@Column(name = "stock_uom", nullable = false)
    private String stockUom;

//    //@Column(name = "disabled")
    private Boolean disabled = false;

//    //@Column(name = "allow_alternative_item")
    private Boolean allowAlternativeItem = false;

//    //@Column(name = "is_stock_item")
    private Boolean isStockItem = true;

//    //@Column(name = "include_item_in_manufacturing")
    private Boolean includeItemInManufacturing = true;

//    //@Column(name = "opening_stock")
    private BigDecimal openingStock;

//    //@Column(name = "valuation_rate")
    private BigDecimal valuationRate;

//    //@Column(name = "standard_rate")
    private BigDecimal standardRate;

//    //@Column(name = "is_fixed_asset")
    private Boolean isFixedAsset = false;

//    //@Column(name = "asset_category")
    private String assetCategory;

//    //@Column(name = "asset_naming_series")
    private String assetNamingSeries;

//    //@Column(name = "image")
    private String image;

//    //@Column(name = "brand")
    private String brand;

//    //@Column(name = "description", columnDefinition = "TEXT")
    private String description;

//    //@Column(name = "shelf_life_in_days")
    private Integer shelfLifeInDays;

//    //@Column(name = "end_of_life")
    private Date endOfLife;

//    //@Column(name = "default_material_request_type")
    private String defaultMaterialRequestType = "Purchase";

//    //@Column(name = "valuation_method")
    private String valuationMethod;

//    //@Column(name = "warranty_period")
    private String warrantyPeriod;

//    //@Column(name = "weight_per_unit")
    private BigDecimal weightPerUnit;

//    //@Column(name = "weight_uom")
    private String weightUom;

//    //@Column(name = "has_batch_no")
    private Boolean hasBatchNo = false;

//    //@Column(name = "create_new_batch")
    private Boolean createNewBatch = false;

//    //@Column(name = "batch_number_series")
    private String batchNumberSeries;

//    //@Column(name = "has_expiry_date")
    private Boolean hasExpiryDate = false;

//    //@Column(name = "retain_sample")
    private Boolean retainSample = false;

//    //@Column(name = "sample_quantity")
    private Integer sampleQuantity;

//    //@Column(name = "has_serial_no")
    private Boolean hasSerialNo = false;

//    //@Column(name = "serial_no_series")
    private String serialNoSeries;

//    //@Column(name = "has_variants")
    private Boolean hasVariants = false;

//    //@Column(name = "variant_based_on")
    private String variantBasedOn = "Item Attribute";

//    //@Column(name = "is_purchase_item")
    private Boolean isPurchaseItem = true;

//    //@Column(name = "purchase_uom")
    private String purchaseUom;

//    //@Column(name = "min_order_qty")
    private BigDecimal minOrderQty = BigDecimal.ZERO;

//    //@Column(name = "safety_stock")
    private BigDecimal safetyStock;

//    //@Column(name = "lead_time_days")
    private Integer leadTimeDays;

//    //@Column(name = "last_purchase_rate")
    private BigDecimal lastPurchaseRate;

//    //@Column(name = "is_customer_provided_item")
    private Boolean isCustomerProvidedItem = false;

//    //@Column(name = "customer")
    private String customer;

//    //@Column(name = "delivered_by_supplier")
    private Boolean deliveredBySupplier = false;

//    //@Column(name = "country_of_origin")
    private String countryOfOrigin;

//    //@Column(name = "customs_tariff_number")
    private String customsTariffNumber;

//    //@Column(name = "sales_uom")
    private String salesUom;

//    //@Column(name = "is_sales_item")
    private Boolean isSalesItem = true;

//    //@Column(name = "max_discount")
    private BigDecimal maxDiscount;

//    //@Column(name = "enable_deferred_revenue")
    private Boolean enableDeferredRevenue = false;

//    //@Column(name = "no_of_months")
    private Integer noOfMonths;

//    //@Column(name = "enable_deferred_expense")
    private Boolean enableDeferredExpense = false;

//    //@Column(name = "no_of_months_exp")
    private Integer noOfMonthsExp;

//    //@Column(name = "inspection_required_before_purchase")
    private Boolean inspectionRequiredBeforePurchase = false;

//    //@Column(name = "inspection_required_before_delivery")
    private Boolean inspectionRequiredBeforeDelivery = false;

//    //@Column(name = "quality_inspection_template")
    private String qualityInspectionTemplate;

//    //@Column(name = "default_bom")
    private String defaultBom;

//    //@Column(name = "is_sub_contracted_item")
    private Boolean isSubContractedItem = false;

//    //@Column(name = "over_delivery_receipt_allowance")
    private BigDecimal overDeliveryReceiptAllowance;

//    //@Column(name = "over_billing_allowance")
    private BigDecimal overBillingAllowance;

//    //@Column(name = "auto_create_assets")
    private Boolean autoCreateAssets = false;

//    //@Column(name = "default_item_manufacturer")
    private String defaultItemManufacturer;

//    //@Column(name = "default_manufacturer_part_no")
    private String defaultManufacturerPartNo;

//    //@Column(name = "grant_commission")
    private Boolean grantCommission = true;

//    //@Column(name = "is_grouped_asset")
    private Boolean isGroupedAsset = false;

//    //@Column(name = "allow_negative_stock")
    private Boolean allowNegativeStock = false;

    // Child tables
//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "item_id")
    private List<ItemBarcode> barcodes;

//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "item_id")
    private List<ItemReorder> reorderLevels;

//    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "item_id")
    private List<UOMConversionDetail> uoms;

    // todo: uncomment
////    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "item_id")
//    private List<ItemVariantAttribute> attributes;
//
////    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "item_id")
//    private List<ItemDefault> itemDefaults;
//
////    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "item_id")
//    private List<ItemSupplier> supplierItems;
//
////    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "item_id")
//    private List<ItemCustomerDetail> customerItems;
//
////    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "item_id")
//    private List<ItemTax> taxes;
    // todo: uncomment
}