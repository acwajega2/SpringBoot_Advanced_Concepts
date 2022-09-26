package com.ug.zest.services;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ug.zest.dto.Product;
import com.ug.zest.dto.ProductsResponse;
import com.ug.zest.services.http.MainHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductsService implements ProductsInterface {

    @Value("${products_url}")
    private String products_url;

    @Override
    public List<Product> getAllProducts() {
        try {
            ResponseEntity<String> responseFromApi = httpCallHelper();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseFromApi.getBody());
             ProductsResponse productsResponse = mapper.convertValue(root, ProductsResponse.class);
            return (List<Product>) productsResponse.getProducts();
        } catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> httpCallHelper() {
        try {
            MainHeaders headers = new MainHeaders();
            HttpEntity<Object> requestBody = new HttpEntity<>(null,headers.getHeaders());
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseFromApi = restTemplate.exchange(products_url,  HttpMethod.GET, requestBody, String.class);
            System.out.println("Server Response" + responseFromApi.toString());
            return responseFromApi;
        } catch (Exception e){
            System.out.println("An Error Occured!!!");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> apiGetAllProducts() {
        return null;
    }
}
