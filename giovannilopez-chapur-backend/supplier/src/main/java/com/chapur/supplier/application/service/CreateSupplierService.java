package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.in.CreateSupplierUseCase;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateSupplierService implements CreateSupplierUseCase {

    private final SupplierRepository supplierRespository;


    @Override
    public Supplier create(Supplier supplier) {
        supplier.setId(UUID.randomUUID());
        log.info(supplier.toString());
        return supplierRespository.save(supplier);
    }
}
