package com.chapur.supplier.infrastructure.adapter.out.persistence.repository;

import com.chapur.supplier.infrastructure.adapter.out.persistence.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSupplierRepository extends JpaRepository<SupplierEntity, UUID> {
}
