package com.eil.sms_backend.controllers;

import com.eil.sms_backend.exceptions.ItemsNotFoundException;
import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (ItemsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
