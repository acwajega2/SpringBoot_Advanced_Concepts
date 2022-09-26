package com.ug.zest.beans;

import com.ug.zest.dto.DataObj;
import com.ug.zest.services.HelloService;
import com.ug.zest.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ug.zest.controllers"})
public class ProductsDatabase {

    /**
     *
     * We shall do an api call on application startup  and then cache the records in memory ----and access them everywhere in the application
     *
     * **/

    @Autowired
    ProductsService productsService;

    @Bean("productList")
    public DataObj getAllProducts(){
        DataObj dataObj = new DataObj();
        dataObj.setProductList(productsService.getAllProducts());
      return dataObj;
    }

    @Bean("hello")
    public HelloService getHelloBeanResponse(){
        return new HelloService();
    }

}
