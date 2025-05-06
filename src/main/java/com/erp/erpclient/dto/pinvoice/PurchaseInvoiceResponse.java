package com.erp.erpclient.dto.pinvoice;

import com.erp.erpclient.entity.pinvoice.PurchaseInvoice;

import java.util.List;

public record PurchaseInvoiceResponse(
        List<PurchaseInvoice> message
) {}