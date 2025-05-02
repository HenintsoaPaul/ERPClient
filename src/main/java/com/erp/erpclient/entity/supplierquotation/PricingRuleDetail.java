package com.erp.erpclient.entity.supplierquotation;

import lombok.Data;

// import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
//@Entity
//@Table(name = "pricing_rule_detail")
public class PricingRuleDetail {


    private Long id;

    //@Column(name = "parent_id")
    private String parentId;

    //@Column(name = "parent_field")
    private String parentField;

    //@Column(name = "parent_type")
    private String parentType;

    //@Column(name = "pricing_rule")
    private String pricingRule;

    //@Column(name = "item_code")
    private String itemCode;

    //@Column(name = "margin_type")
    private String marginType;

    //@Column(name = "rate_or_discount")
    private String rateOrDiscount;

    //@Column(name = "child_docname")
    private String childDocname;

    //@Column(name = "rule_applied")
    private Boolean ruleApplied;

    //@Column(name = "discount_percentage", precision = 20, scale = 6)
    private BigDecimal discountPercentage;

    //@Column(name = "discount_amount", precision = 20, scale = 6)
    private BigDecimal discountAmount;
}