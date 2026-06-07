package com.chapur.supplier.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {

    Supplier generateSupplier(){
        Supplier supplier = new Supplier();
        supplier.setActive(true);
        supplier.setName("chapur");
        supplier.setCountry("Mx");
        supplier.setId(UUID.randomUUID());
        return  supplier;
    }

    @Test
    void testGetterAndSetter(){
        Supplier supplier = this.generateSupplier();
        assertEquals("chapur",supplier.getName());
        assertEquals(true,supplier.getActive());
        assertEquals("Mx",supplier.getCountry());
    }
}
