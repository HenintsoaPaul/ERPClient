package com.erp.erpclient.entity.item;

import jakarta.persistence.*;

@Entity
@Table(name = "item_barcode")
public class ItemBarcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "barcode_type")
    private String barcodeType;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // Getters and Setters
}