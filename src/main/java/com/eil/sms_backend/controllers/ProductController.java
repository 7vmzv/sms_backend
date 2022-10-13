package com.eil.sms_backend.controllers;

import com.eil.sms_backend.exceptions.ItemsNotFoundException;
import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.repositories.ProductRepository;
import com.eil.sms_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;
    @Autowired
    ProductRepository productRepository;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAllProducts()  {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/products/qr/{qr_code}")
    ResponseEntity<Product> getProduct(@PathVariable String qr_code) {
        return productService.getProduct(qr_code);
    }
}
