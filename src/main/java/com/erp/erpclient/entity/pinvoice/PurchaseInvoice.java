package com.erp.erpclient.entity.pinvoice;

import com.erp.erpclient.entity.Transaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PurchaseInvoice extends Transaction {

    private String taxId;
    private Date dueDate;
    private Date postingDate;
    private String postingTime;

//    private Date transactionDate;
//    private Date scheduleDate;
    private Boolean isPaid = false;
    private Boolean isReturn = false;
    private Boolean applyTds = false;
    private Boolean onHold = false;
    private Date releaseDate;
    private String holdComment;
    private String billNo;
    private Date billDate;
    private String returnAgainst;
    private Boolean updateBilledAmountInPurchaseOrder = false;
    private Boolean updateBilledAmountInPurchaseReceipt = true;
    private Boolean setPostingTime = false;
    private String amendedFrom;
    private String setWarehouse;
    private String rejectedWarehouse;
    private Boolean updateStock = false;

    private List<PurchaseInvoiceItem> items;

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
    private String applyDiscountOn = "Grand Total";
    private BigDecimal baseDiscountAmount;
    private BigDecimal additionalDiscountPercentage;
    private BigDecimal discountAmount;
    private BigDecimal baseGrandTotal;
    private BigDecimal baseRoundingAdjustment;
    private BigDecimal baseRoundedTotal;
    private String baseInWords;
    private BigDecimal grandTotal;
    private BigDecimal roundingAdjustment;
    private BigDecimal roundedTotal;
    private String inWords;
    private Boolean disableRoundedTotal = false;
    private BigDecimal totalAdvance;
    private BigDecimal outstandingAmount;
    private String modeOfPayment;
    private String cashBankAccount;
    private Date clearanceDate;
    private BigDecimal paidAmount;
    private BigDecimal basePaidAmount;
    private BigDecimal writeOffAmount;
    private BigDecimal baseWriteOffAmount;
    private String writeOffAccount;
    private String writeOffCostCenter;

    private String tcName;
    private String creditTo;
    private String isOpening = "No";
    private String againstExpenseAccount;

    //    @NotBlank
    private String status = "Draft";
    private String interCompanyInvoiceReference;
    private String remarks;
    private Date fromDate;
    private Date toDate;
    private String autoRepeat;
    private String taxWithholdingCategory;
    private String unrealizedProfitLossAccount;
    private String setFromWarehouse;
    private BigDecimal perReceived;
    private Boolean ignoreDefaultPaymentTermsTemplate = false;//

    //    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<AdvanceTax> advanceTax;
    private String subscription;
    private Boolean isOldSubcontractingFlow = false;
    private BigDecimal taxWithholdingNetTotal;
    private BigDecimal baseTaxWithholdingNetTotal;
}