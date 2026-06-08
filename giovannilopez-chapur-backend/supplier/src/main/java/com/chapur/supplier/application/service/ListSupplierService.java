package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.in.ListSupplierUseCase;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.PagedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListSupplierService implements ListSupplierUseCase {

    private final SupplierRepository supplierRespository;

    @Override
    public PagedResponse<Supplier> findAll(int page, int size) {
        return supplierRespository.findAll(page,size);
    }
}
