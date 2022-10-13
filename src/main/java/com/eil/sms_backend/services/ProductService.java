package com.eil.sms_backend.services;

import com.eil.sms_backend.exceptions.ItemsNotFoundException;
import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws ItemsNotFoundException {
        List<Product> products = productRepository.findAll();
        // System.out.println(products);
        if(products.size() == 0) throw new ItemsNotFoundException("No products in database!");
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public ResponseEntity<Product> getProduct(String qr_code) {
        Product product = productRepository.findProductByQrCode(qr_code);
        if(product==null) throw new ItemsNotFoundException(String.format("Item with qr %s not found",qr_code));
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
