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
    private String status;

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
}