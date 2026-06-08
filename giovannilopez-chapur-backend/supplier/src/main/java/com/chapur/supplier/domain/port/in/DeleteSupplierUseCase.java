package com.chapur.supplier.domain.port.in;

import java.util.UUID;

public interface DeleteSupplierUseCase {

    boolean delete(UUID id);
}
