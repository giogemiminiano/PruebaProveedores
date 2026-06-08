package com.chapur.supplier.infrastructure.adapter.in.web.mapper;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.CreateSupplierRequest;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.PagedResponse;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.SupplierResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierDtoMapper {

    Supplier toDomain(CreateSupplierRequest createSupplierRequest);


    SupplierResponse toResponse(Supplier supplier);

    List<PagedResponse> toResponse(List<Supplier> suppliers);
}
