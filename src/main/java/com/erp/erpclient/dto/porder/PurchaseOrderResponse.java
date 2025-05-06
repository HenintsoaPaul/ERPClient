package com.erp.erpclient.dto.porder;

import com.erp.erpclient.entity.porder.PurchaseOrder;

import java.util.List;

public record PurchaseOrderResponse(
        List<PurchaseOrder> message
) {}