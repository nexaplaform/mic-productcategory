package com.fiverr.app;

import org.springframework.boot.SpringApplication;

public class TestMicProductcategoryApplication {

	public static void main(String[] args) {
		SpringApplication.from(MicProductCategoryApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
