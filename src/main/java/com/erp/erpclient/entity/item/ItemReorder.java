package com.erp.erpclient.entity.item;

// import jakarta.persistence.*;
import java.math.BigDecimal;

public class ItemReorder {

    private Long id;

//    //@Column(name = "warehouse")
    private String warehouse;

//    //@Column(name = "warehouse_reorder_level")
    private BigDecimal warehouseReorderLevel;

//    //@Column(name = "warehouse_reorder_qty")
    private BigDecimal warehouseReorderQty;

//    //@Column(name = "material_request_type")
    private String materialRequestType;

//    @ManyToOne
//    @JoinColumn(name = "item_id")
    private Item item;

    // Getters and Setters
}