package com.chapur.supplier.infrastructure.adapter.in.web.mapper;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.CreateSupplierRequest;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.SupplierResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierDtoMapper {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "active", ignore = true)
    Supplier toDomain(CreateSupplierRequest createSupplierRequest);


    SupplierResponse toResponse(Supplier supplier);
}
