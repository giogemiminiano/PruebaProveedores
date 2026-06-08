package com.chapur.supplier.domain.exception;

public class GetSupplierException extends RuntimeException{

    public GetSupplierException(String id){
        super("No se encontro el proveedor con Id: "+id);
    }
}
