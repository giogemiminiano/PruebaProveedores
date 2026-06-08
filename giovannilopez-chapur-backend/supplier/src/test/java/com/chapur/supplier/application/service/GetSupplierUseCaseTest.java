package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.exception.GetSupplierException;
import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GetSupplierUseCaseTest {

    @Mock
    private SupplierRepository repository;

    @InjectMocks
    private GetSupplierService service;


    @Test
    void getSupplierTestSucces(){
        Supplier supplier = this.generateSupplier();
        Optional<Supplier> list = Optional.of(supplier);
        when(repository.findById(any(UUID.class))).thenReturn(list);
        Supplier supplierResult = service.getSupplierById(UUID.randomUUID());
        assertNotNull(supplierResult);
    }


    @Test
    void getSupplierTestFail(){
        assertThrows(GetSupplierException.class,()->service.getSupplierById(UUID.randomUUID()));
    }

    Supplier generateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setActive(true);
        supplier.setName("chapur");
        supplier.setCountry("Mx");
        return  supplier;
    }



}
