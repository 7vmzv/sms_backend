package com.eil.sms_backend;

import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductService productService) {
		return (args -> {
			for(int i = 0; i < 10; i++) {
				productService.addProduct(
						new Product(null, "code------"+i, "product " + i, Math.random() * 10, new Date())
				);
			}
		});

	}
}