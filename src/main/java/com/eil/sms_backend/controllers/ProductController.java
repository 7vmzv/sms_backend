package com.eil.sms_backend.controllers;

import com.eil.sms_backend.exceptions.ItemsNotFoundException;
import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAllProducts()  {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }
//    List<Product> getAllProducts() {
//        try {
//            return productService.getAllProducts();
//        } catch (ItemsNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
