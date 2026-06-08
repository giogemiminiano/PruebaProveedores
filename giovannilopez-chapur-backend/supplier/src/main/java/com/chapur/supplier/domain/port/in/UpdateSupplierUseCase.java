package com.chapur.supplier.domain.port.in;

import java.util.UUID;

public interface UpdateSupplierUseCase {

    boolean update(UUID id,String name,String country);
}
