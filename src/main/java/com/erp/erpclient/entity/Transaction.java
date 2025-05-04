package com.erp.erpclient.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public abstract class Transaction extends Doctype {
//    private Long id;
    private String title;
    private String namingSeries;
    private String supplier;
    private String supplierName;
    private String company;
    private Date postingDate;
    private String currency;
    private BigDecimal conversionRate;
    private Boolean ignorePricingRule = false;
    private String costCenter;
    private String project;
    private String taxCategory;
    private String terms;
    private String language;
}