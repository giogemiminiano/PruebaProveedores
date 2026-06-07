package com.chapur.supplier.domain.port.in;

import com.chapur.supplier.domain.model.Supplier;

import java.util.UUID;

public interface GetSupplierUseCase {

    Supplier getSupplierById(UUID id);
}
