package com.erp.erpclient.entity.supplierquotation;

import com.erp.erpclient.entity.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

// import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
//@Entity
//@Table(name = "supplier_quotation_item")
public class SupplierQuotationItem extends Item {

    //@Column(name = "parent_id")
    private String parentId;

    //@Column(name = "parent_field")
    private String parentField;

    //@Column(name = "parent_type")
    private String parentType;

    //@Column(name = "expected_delivery_date")
    //@Temporal(TemporalType.DATE)
    private Date expectedDeliveryDate;

    //@Column(name = "rate", precision = 20, scale = 6)
    private BigDecimal rate;

    //@Column(name = "amount", precision = 20, scale = 6)
    private BigDecimal amount;

    //@Column(name = "base_rate", precision = 20, scale = 6)
    private BigDecimal baseRate;

    //@Column(name = "base_amount", precision = 20, scale = 6)
    private BigDecimal baseAmount;

    //@Column(name = "qty", precision = 20, scale = 6)
    private BigDecimal qty;

    //@Column(name = "stock_qty", precision = 20, scale = 6)
    private BigDecimal stockQty;

    //@Column(name = "uom")
    private String uom;

    //@Column(name = "conversion_factor", precision = 20, scale = 6)
    private BigDecimal conversionFactor;

    //@Column(name = "stock_uom")
    private String stockUom;

    //@Column(name = "warehouse")
    private String warehouse;

    //@Column(name = "supplier_part_no")
    private String supplierPartNo;

    //@Column(name = "item_tax_template")
    private String itemTaxTemplate;

    //@Column(name = "project")
    private String project;
}