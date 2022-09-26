package com.ug.zest.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ug.zest.dto.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductsInterface {
    List<Product> getAllProducts();

    ResponseEntity<String> httpCallHelper() throws JsonProcessingException;

    List<Product> apiGetAllProducts();


}
