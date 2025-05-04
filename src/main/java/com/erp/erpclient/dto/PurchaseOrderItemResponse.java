package com.erp.erpclient.dto;


import com.erp.erpclient.entity.porder.PurchaseOrderItem;

import java.util.List;

public record PurchaseOrderItemResponse(
        List<PurchaseOrderItem> message
) {}