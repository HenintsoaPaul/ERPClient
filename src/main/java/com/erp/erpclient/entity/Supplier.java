package com.erp.erpclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Supplier extends Doctype {
    // Custom Supplier-specific fields
    @JsonProperty("supplier_name")
    private String supplierName;

    @JsonProperty("supplier_type")
    private String supplierType;

    @JsonProperty("supplier_group")
    private String supplierGroup;

    @JsonProperty("country")
    private String country;
}
