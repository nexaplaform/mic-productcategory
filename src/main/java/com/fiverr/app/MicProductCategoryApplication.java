package com.fiverr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://mic-productcategory-production.up.railway.app")
public class MicProductCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicProductCategoryApplication.class, args);
	}

}
