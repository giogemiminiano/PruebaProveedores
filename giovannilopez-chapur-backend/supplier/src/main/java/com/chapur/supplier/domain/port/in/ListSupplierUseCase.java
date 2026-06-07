package com.chapur.supplier.domain.port.in;

import com.chapur.supplier.domain.model.Supplier;

import java.util.List;

public interface ListSupplierUseCase {

    List<Supplier> findAll();
}
