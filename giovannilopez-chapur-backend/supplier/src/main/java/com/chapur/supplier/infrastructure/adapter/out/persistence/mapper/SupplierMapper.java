package com.chapur.supplier.infrastructure.adapter.out.persistence.mapper;


import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.infrastructure.adapter.out.persistence.entity.SupplierEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierEntity toEntity(Supplier supplier);

    Supplier toDomain(SupplierEntity supplier);
}
