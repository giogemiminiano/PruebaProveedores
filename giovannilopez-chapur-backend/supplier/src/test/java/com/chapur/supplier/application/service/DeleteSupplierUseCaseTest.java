package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.exception.GetSupplierException;
import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteSupplierUseCaseTest {

    @Mock
    private SupplierRepository repository;

    @InjectMocks
    private DeleteSupplierService service;

    @Test
    void updateSupplierTestSuccess(){
        Supplier supplier = this.generateSupplier();
        Optional<Supplier> list = Optional.of(supplier);
        when(repository.findById(any(UUID.class))).thenReturn(list);
        when(repository.save(any(Supplier.class))).thenReturn(supplier);
        boolean success = service.delete(UUID.randomUUID());
        assertTrue(success);
    }

    @Test
    void updateSupplierTestFail(){
        assertThrows(GetSupplierException.class,()->service.delete(UUID.randomUUID()));
    }

    Supplier generateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setName("chapur");
        supplier.setCountry("Mx");
        return  supplier;
    }
}
