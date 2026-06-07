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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UpdateSupplierUseCaseTest {

    @Mock
    private SupplierRepository repository;

    @InjectMocks
    private UpdateSupplierService service;

    @Test
    void updateSupplierTestSuccess(){
        Supplier supplier = this.generateSupplier();
        Optional<Supplier> list = Optional.of(supplier);
        when(repository.findById(any(UUID.class))).thenReturn(list);
        when(repository.save(any(Supplier.class))).thenReturn(supplier);
        boolean success = service.update(UUID.randomUUID(),"Test","USA",false);
        assertTrue(success);
    }

    @Test
    void updateSupplierTestFail(){
        assertThrows(GetSupplierException.class,()->service.update(UUID.randomUUID(),"A","B",false));
    }

    Supplier generateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setActive(true);
        supplier.setName("chapur");
        supplier.setCountry("Mx");
        return  supplier;
    }
}
