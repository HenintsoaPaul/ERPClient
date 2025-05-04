package com.erp.erpclient.dto;

import com.erp.erpclient.entity.pinvoice.PurchaseInvoice;

import java.util.List;

public record PurchaseInvoiceResponse(
        List<PurchaseInvoice> message
) {}