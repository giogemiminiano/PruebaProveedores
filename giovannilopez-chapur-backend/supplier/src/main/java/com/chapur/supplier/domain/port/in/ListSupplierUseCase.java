package com.chapur.supplier.domain.port.in;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.PagedResponse;

import java.util.List;

public interface ListSupplierUseCase {

    PagedResponse<Supplier> findAll(int page, int size);
}
