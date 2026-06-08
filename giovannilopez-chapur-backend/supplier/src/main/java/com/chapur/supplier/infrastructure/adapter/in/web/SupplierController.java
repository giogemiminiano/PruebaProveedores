package com.chapur.supplier.infrastructure.adapter.in.web;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.in.*;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.CreateSupplierRequest;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.PagedResponse;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.SupplierResponse;
import com.chapur.supplier.infrastructure.adapter.in.web.dto.UpdateSupplierRequest;
import com.chapur.supplier.infrastructure.adapter.in.web.mapper.SupplierDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/supplier-service")
@Slf4j
@Tag(name="Gestion de proveedores", description = "Manejo de proveedore Gran Chapur")
public class SupplierController {

    private final CreateSupplierUseCase createSupplierUseCase;
    private final GetSupplierUseCase getSupplierUseCase;
    private final ListSupplierUseCase listSupplierUseCase;
    private final UpdateSupplierUseCase updateSupplierUseCase;

    private final DeleteSupplierUseCase deleteSupplierUseCase;

    private final SupplierDtoMapper mapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear nuevo proveedor")
    public SupplierResponse create(@RequestBody @Valid CreateSupplierRequest createSupplierRequest){
        log.info("__create__init__"+createSupplierRequest.toString());
        Supplier supplierDomain = mapper.toDomain(createSupplierRequest);
        log.info(supplierDomain.toString());
        Supplier supplier = createSupplierUseCase.create(supplierDomain);
        return mapper.toResponse(supplier);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar proveedor por Id")
    public SupplierResponse findSupplierById(@PathVariable UUID id){
        log.info("__findApplicationById__init__");
        Supplier supplier = getSupplierUseCase.getSupplierById(id);
        return mapper.toResponse(supplier);
    }

    @GetMapping
    @Operation(summary = "Listar proveedores")
    public PagedResponse<SupplierResponse> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        log.info("__findAll__init__");
        PagedResponse<Supplier> supplierPagedResponse = listSupplierUseCase.findAll(page, size);
        return new PagedResponse<>(supplierPagedResponse.content().stream().map(mapper::toResponse).toList(),
                supplierPagedResponse.page(),supplierPagedResponse.size(),supplierPagedResponse.totalElements(),supplierPagedResponse.totalPage());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar datos del proveedor")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateSupplierRequest updateSupplierRequest){
        log.info("__update__init__");
        updateSupplierUseCase.update(id, updateSupplierRequest.name(), updateSupplierRequest.country());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar/desactivar el proveedor")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        log.info("__delete__init__");
        deleteSupplierUseCase.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
