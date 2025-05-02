package com.erp.erpclient.entity.item;

// import jakarta.persistence.*;

import java.math.BigDecimal;

//@Entity
//@Table(name = "uom_conversion_detail")
public class UOMConversionDetail {

    private Long id;

    //    //@Column(name = "uom")
    private String uom;

    //    //@Column(name = "conversion_factor", precision = 21, scale = 9)
    private BigDecimal conversionFactor;

    //    @ManyToOne
//    @JoinColumn(name = "item_id")
    private Item item;

    // Getters and Setters
}