package com.chapur.supplier.domain.port.out;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.PagedResponse;
import com.chapur.supplier.infrastructure.adapter.out.persistence.entity.SupplierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository {

    Supplier save(Supplier supplier);
    Optional<Supplier> findById(UUID id);
    PagedResponse<Supplier> findAll(int page, int size);

}
