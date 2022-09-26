package com.ug.zest.services.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class MainHeaders {

    //----------> Creating the headers
   public HttpHeaders getHeaders(){
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       return headers;
   }

}
