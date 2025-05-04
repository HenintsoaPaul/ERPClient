package com.erp.erpclient.dto.porder;


import com.erp.erpclient.entity.porder.PurchaseOrderItem;

import java.util.List;

public record PurchaseOrderItemResponse(
        List<PurchaseOrderItem> message
) {}