package com.chapur.supplier.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateSupplierRequest (

        String name,
        String country
){
}
