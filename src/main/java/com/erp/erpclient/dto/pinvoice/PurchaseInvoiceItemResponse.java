package com.erp.erpclient.dto.pinvoice;

import com.erp.erpclient.entity.pinvoice.PurchaseInvoiceItem;

import java.util.List;

public record PurchaseInvoiceItemResponse(
        List<PurchaseInvoiceItem> message
) {}