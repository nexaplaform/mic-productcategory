package com.fiverr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(servers = {
//        @Server(url = "/", description = "Default Server"),
//        @Server(url = "https://mic-productcategory-production.up.railway.app/", description = "Production Server")
//})
public class MicProductCategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicProductCategoryApplication.class, args);
    }

}
