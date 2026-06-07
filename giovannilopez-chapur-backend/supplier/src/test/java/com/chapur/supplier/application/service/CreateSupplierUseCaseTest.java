package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CreateSupplierUseCaseTest {


    @Mock
    private SupplierRepository repository;

    @InjectMocks
    private CreateSupplierService service;


    @Test
    void createSupplierSuccessTest(){
        Supplier supplier = this.generateSupplier();
        when(repository.save(any(Supplier.class))).thenReturn(supplier);
        Supplier supplierCreated = service.create(supplier);
        assertNotNull(supplierCreated);

    }

    Supplier generateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setActive(true);
        supplier.setName("chapur");
        supplier.setCountry("Mx");
        return  supplier;
    }

}
