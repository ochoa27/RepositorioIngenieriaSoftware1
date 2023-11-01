package com.eternalnovices.cotasker.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eternalnovices.cotasker.controller"})
public class CoTaskerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoTaskerApplication.class, args);
	}

}
