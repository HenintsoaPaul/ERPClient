package com.erp.erpclient.entity.supplierquotation;

import com.erp.erpclient.entity.Transaction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SupplierQuotation extends Transaction {
    // Supplier Quotation specific fields
    private Date validTill;
    private String quotationNumber;
    private String buyingPriceList;
    private String priceListCurrency;
    private BigDecimal plcConversionRate;
    private String shippingRule;
    private String incoterm;
    private String namedPlace;

    // Item details
    private List<SupplierQuotationItem> items;

    // Totals
    private BigDecimal totalQty;
    private BigDecimal baseTotal;
    private BigDecimal total;
    private BigDecimal baseNetTotal;
    private BigDecimal netTotal;
    private BigDecimal baseGrandTotal;
    private BigDecimal grandTotal;

    // Status
    private Status status = Status.DRAFT;

    public enum Status {
        DRAFT, SUBMITTED, STOPPED, CANCELLED, EXPIRED
    }
}