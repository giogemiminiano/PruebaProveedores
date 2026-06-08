package com.chapur.supplier.infrastructure.adapter.out.persistence;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.PagedResponse;
import com.chapur.supplier.infrastructure.adapter.out.persistence.entity.SupplierEntity;
import com.chapur.supplier.infrastructure.adapter.out.persistence.mapper.SupplierMapper;
import com.chapur.supplier.infrastructure.adapter.out.persistence.repository.JpaSupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PagedResponse<Supplier> findAll(int page,int size) {
        Page<SupplierEntity> result =
                repository.findAll(PageRequest.of(page, size));

        List<Supplier> suppliers = result.getContent().stream().map(mapper::toDomain).toList();

        return new PagedResponse<>(suppliers,result.getNumber(),result.getSize(),
                result.getNumberOfElements(), result.getTotalPages());
    }


}
