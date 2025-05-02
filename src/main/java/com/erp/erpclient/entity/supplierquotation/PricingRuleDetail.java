package com.erp.erpclient.entity.supplierquotation;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PricingRuleDetail {
    private Long id;
    private String parentId;
    private String parentField;
    private String parentType;
    private String pricingRule;
    private String itemCode;
    private String marginType;
    private String rateOrDiscount;
    private String childDocname;
    private Boolean ruleApplied;
    private BigDecimal discountPercentage;
    private BigDecimal discountAmount;
}