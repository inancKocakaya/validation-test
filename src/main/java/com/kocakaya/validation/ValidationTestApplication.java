package com.kocakaya.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kocakaya.validation")
public class ValidationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationTestApplication.class, args);
	}
}
