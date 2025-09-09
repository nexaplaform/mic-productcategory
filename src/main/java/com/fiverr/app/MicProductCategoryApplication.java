package com.fiverr.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
        @Server(url = "/", description = "Default Server"),
        @Server(url = "https://mic-productcategory-production.up.railway.app/", description = "Production Server"),
        @Server(url = "http://localhost:8080", description = "Local Server")
})
public class MicProductCategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicProductCategoryApplication.class, args);
    }

}
