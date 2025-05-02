package com.erp.erpclient.entity.pinvoice;

// import jakarta.persistence.*;

import java.math.BigDecimal;

public class PurchaseInvoiceItem {

    private Long id;

    private String itemCode;

    private String itemName;

    private String description;

    private BigDecimal qty;

    private BigDecimal rate;

    private BigDecimal amount;

    // Add all other fields from ERPNext Purchase Invoice Item

    private PurchaseInvoice purchaseInvoice;
}
