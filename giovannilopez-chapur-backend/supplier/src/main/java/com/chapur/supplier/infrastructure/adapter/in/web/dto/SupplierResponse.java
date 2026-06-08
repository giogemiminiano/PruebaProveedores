package com.chapur.supplier.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record SupplierResponse (

        UUID id,

        String name,

        String country
){
}
