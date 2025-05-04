package com.erp.erpclient.dto;

import com.erp.erpclient.entity.Supplier;
import com.erp.erpclient.entity.porder.PurchaseOrder;

import java.util.List;

public record PurchaseOrderResponse(
        List<PurchaseOrder> message
) {}