package com.chapur.supplier.domain.port.in;

import com.chapur.supplier.domain.model.Supplier;

public interface CreateSupplierUseCase {

    Supplier create(Supplier supplier);
}
