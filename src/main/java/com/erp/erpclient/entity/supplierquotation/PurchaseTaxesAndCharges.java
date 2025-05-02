package com.erp.erpclient.entity.supplierquotation;

import lombok.Data;

// import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
//@Entity
//@Table(name = "purchase_taxes_and_charges")
public class PurchaseTaxesAndCharges {


    private Long id;

    //@Column(name = "parent_id")
    private String parentId;

    //@Column(name = "parent_field")
    private String parentField;

    //@Column(name = "parent_type")
    private String parentType;

    //@Column(name = "charge_type")
    private String chargeType;

    //@Column(name = "account_head")
    private String accountHead;

    //@Column(name = "description")
    private String description;

    //@Column(name = "included_in_print_rate")
    private Boolean includedInPrintRate = false;

    //@Column(name = "included_in_paid_amount")
    private Boolean includedInPaidAmount = false;

    //@Column(name = "cost_center")
    private String costCenter;

    //@Column(name = "rate", precision = 20, scale = 6)
    private BigDecimal rate;

    //@Column(name = "tax_amount", precision = 20, scale = 6)
    private BigDecimal taxAmount;

    //@Column(name = "total", precision = 20, scale = 6)
    private BigDecimal total;

    //@Column(name = "base_tax_amount", precision = 20, scale = 6)
    private BigDecimal baseTaxAmount;

    //@Column(name = "base_total", precision = 20, scale = 6)
    private BigDecimal baseTotal;

    //@Column(name = "row_id")
    private String rowId;
}