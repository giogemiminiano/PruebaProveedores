package com.chapur.supplier.infrastructure.adapter.out.persistence;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import com.chapur.supplier.infrastructure.adapter.out.persistence.entity.SupplierEntity;
import com.chapur.supplier.infrastructure.adapter.out.persistence.mapper.SupplierMapper;
import com.chapur.supplier.infrastructure.adapter.out.persistence.repository.JpaSupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class SupplierRepositoryAdapter implements SupplierRepository {

    private final JpaSupplierRepository repository;

    private final SupplierMapper mapper;


    @Override
    public Supplier save(Supplier supplier) {
        SupplierEntity supplierEntity =  mapper.toEntity(supplier);
        SupplierEntity supplierEntitySave = repository.save(supplierEntity);
        return mapper.toDomain(supplierEntitySave);
    }

    @Override
    public Optional<Supplier> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Supplier> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
