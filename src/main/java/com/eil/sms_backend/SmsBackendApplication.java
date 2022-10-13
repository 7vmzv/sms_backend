package com.eil.sms_backend;

import com.eil.sms_backend.entities.OrderLine;
import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.entities.StoreOrder;
import com.eil.sms_backend.services.OrderService;
import com.eil.sms_backend.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductService productService, OrderService orderService) {
		return (args -> {
			for(int i = 0; i < 10; i++) {
				productService.addProduct(
						new Product(null, "prd"+i, "product " + i, Math.random() * 10, new Date())
				);
			}
//			StoreOrder storeOrder = new StoreOrder();
//			storeOrder.setOrderLines(new ArrayList<>());
//			OrderLine orderLine = new OrderLine(null, storeOrder, 12, productService.getProduct("code------1"));
//			OrderLine orderLine1 = new OrderLine(null, storeOrder, 3, productService.getProduct("code------2"));

//			storeOrder.getOrderLines().add(orderLine);
//			storeOrder.getOrderLines().add(orderLine1);
//
//			orderService.createOrder(storeOrder);

		});
	}
}