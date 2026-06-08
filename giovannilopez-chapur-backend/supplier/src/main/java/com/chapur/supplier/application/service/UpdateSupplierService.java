package com.chapur.supplier.application.service;

import com.chapur.supplier.domain.exception.GetSupplierException;
import com.chapur.supplier.domain.model.Supplier;
import com.chapur.supplier.domain.port.in.UpdateSupplierUseCase;
import com.chapur.supplier.domain.port.out.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateSupplierService implements UpdateSupplierUseCase {

    private final SupplierRepository supplierRespository;

    @Override
    public boolean update(UUID id, String name, String country) {
        Optional<Supplier> supplier= supplierRespository.findById(id);
        if(supplier.isEmpty()){
            throw new GetSupplierException(id.toString());
        }else{
            Supplier supplierObject = supplier.get();
            if(country!=null && !country.isEmpty())
                supplierObject.setCountry(country);

            if(name!=null && !name.isEmpty())
                supplierObject.setName(name);

            log.info(supplierObject.toString());
            supplierRespository.save(supplierObject);
        }
        return true;
    }
}
