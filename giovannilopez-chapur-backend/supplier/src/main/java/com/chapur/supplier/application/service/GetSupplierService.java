package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.exception.GetSupplierException;
import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.in.GetSupplierUseCase;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSupplierService implements GetSupplierUseCase {

    private final SupplierRepository supplierRespository;

    @Override
    public Supplier getSupplierById(UUID id) {
        return supplierRespository.findById(id).orElseThrow(()->new GetSupplierException(id.toString()));
    }
}
