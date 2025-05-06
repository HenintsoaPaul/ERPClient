package com.erp.erpclient.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Transaction extends Doctype {
    protected String name;
    protected String title;
    protected String namingSeries;
    protected String supplier;
    protected String supplierName;
    protected String company;
    protected Date postingDate;
    protected String currency;
    protected BigDecimal conversionRate;
    protected Boolean ignorePricingRule = false;
    protected String costCenter;
    protected String project;
    protected String taxCategory;
    protected String terms;
    protected String language;
}