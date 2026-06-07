package com.chapur.supplier.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateSupplierRequest (

    @NotBlank
    String name,

    @NotBlank
    String country,

    Boolean active
){
}
