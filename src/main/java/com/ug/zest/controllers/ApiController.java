package com.ug.zest.controllers;


import com.ug.zest.dto.DataObj;
import com.ug.zest.dto.Product;
import com.ug.zest.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final ApplicationContext ctx;

    private final List<Product> productList;

    @Autowired
    public ApiController(ApplicationContext ctx) {
        this.ctx = ctx;

        this.productList = getProductList();
    }



    //--------------> Method get productList on startup
    private List<Product> getProductList() {
        Optional<DataObj> dataObj = Optional.of(ctx.getBean("productList", DataObj.class));
        return dataObj.map(DataObj::getProductList).orElse(null);
    }




    @GetMapping(path = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        return !productList.isEmpty() ? new ResponseEntity<>(productList, HttpStatus.ACCEPTED) : new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);
    }



    @GetMapping(path = "/testHello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ctestHello() {
        HelloService helloService = ctx.getBean("hello", HelloService.class);
        return helloService.sayHello();
    }


}
