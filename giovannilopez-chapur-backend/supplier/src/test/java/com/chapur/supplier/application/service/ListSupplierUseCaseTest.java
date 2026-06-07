package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListSupplierUseCaseTest {


    @Mock
    private SupplierRepository repository;

    @InjectMocks
    private ListSupplierService service;

    @Test
    void ListSupplierTestSuccess(){
        List<Supplier> list = new ArrayList<>();
        list.add(this.generateSupplier());
        when(repository.findAll()).thenReturn(list);
        assertNotNull(service.findAll());
    }


    Supplier generateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setActive(true);
        supplier.setName("chapur");
        supplier.setCountry("Mx");
        return  supplier;
    }
}
