package com.erp.erpclient.entity.supplierquotation;

public record UpdateRequest(
        String itemId,
        double newRate,
        double newQty
) {
}