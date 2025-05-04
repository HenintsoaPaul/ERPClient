package com.erp.erpclient.entity.porder;

import com.erp.erpclient.entity.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseOrder extends Transaction {

    private Date scheduleDate;
    private String orderConfirmationNo;
    private Date orderConfirmationDate;
    private Boolean getItemsFromOpenMaterialRequests = false;
    private Boolean isOldSubcontractingFlow = false;
    private String refSq;
    private String interCompanyOrderReference;
    private Boolean dropShip = false;
    private String customer;
    private String customerName;
    private String customerContactPerson;
    private String customerContactDisplay;
    private String customerContactMobile;
    private String customerContactEmail;
    private BigDecimal perReceived;
    private BigDecimal perBilled;
    private String advancePaymentStatus;
    private String selectPrintHeading;
    private Date fromDate;
    private Date toDate;
    private Boolean updateAutoRepeatReference = false;
    private BigDecimal taxWithholdingNetTotal;
    private BigDecimal baseTaxWithholdingNetTotal;

    // Status fields with specific options for PurchaseOrder
    private String status = "Draft";
    // Options: Draft, On Hold, To Receive and Bill,// To Bill, To Receive, Completed, Cancelled, Closed, Delivered

    // Financial totals
    private BigDecimal totalQty;
    private BigDecimal totalNetWeight;
    private BigDecimal baseTotal;
    private BigDecimal baseNetTotal;
    private BigDecimal total;
    private BigDecimal netTotal;
    private BigDecimal baseTaxesAndChargesAdded;
    private BigDecimal baseTaxesAndChargesDeducted;
    private BigDecimal baseTotalTaxesAndCharges;
    private BigDecimal taxesAndChargesAdded;
    private BigDecimal taxesAndChargesDeducted;
    private BigDecimal totalTaxesAndCharges;
    private BigDecimal baseGrandTotal;
    private BigDecimal baseRoundingAdjustment;
    private String baseInWords;
    private BigDecimal baseRoundedTotal;
    private BigDecimal grandTotal;
    private BigDecimal roundingAdjustment;
    private BigDecimal roundedTotal;
    private String inWords;
    private Boolean disableRoundedTotal = false;
    private BigDecimal advancePaid;
}