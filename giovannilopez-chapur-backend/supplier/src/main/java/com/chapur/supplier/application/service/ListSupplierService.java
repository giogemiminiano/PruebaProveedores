package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.in.ListSupplierUseCase;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListSupplierService implements ListSupplierUseCase {

    private final SupplierRepository supplierRespository;

    @Override
    public List<Supplier> findAll() {
        return supplierRespository.findAll();
    }
}
