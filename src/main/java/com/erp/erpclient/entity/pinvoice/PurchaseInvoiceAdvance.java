package com.erp.erpclient.entity.pinvoice;

// import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class PurchaseInvoiceAdvance {

    private Long id;

//    //@Column(name = "reference_type")
    private String referenceType;

//    //@Column(name = "reference_name")
    private String referenceName;

//    //@Column(name = "remarks")
    private String remarks;

//    //@Column(name = "advance_amount", precision = 21, scale = 9)
    private BigDecimal advanceAmount;

//    //@Column(name = "allocated_amount", precision = 21, scale = 9)
    private BigDecimal allocatedAmount;

    //@Temporal(TemporalType.DATE)
//    //@Column(name = "reference_date")
    private Date referenceDate;

//    @ManyToOne
//    @JoinColumn(name = "purchase_invoice_id")
    private PurchaseInvoice purchaseInvoice;
}
