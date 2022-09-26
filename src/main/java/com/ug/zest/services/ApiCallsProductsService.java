package com.ug.zest.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ug.zest.dto.Product;

import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApiCallsProductsService implements ProductsInterface{

    private final ApplicationContext ctx;

    public ApiCallsProductsService(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<String> httpCallHelper() throws JsonProcessingException {
        return null;
    }



    @Override
    public List<Product> apiGetAllProducts() {
       return null;

    }


}