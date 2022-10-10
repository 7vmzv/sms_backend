package com.eil.sms_backend.services;

import com.eil.sms_backend.exceptions.ItemsNotFoundException;
import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.repositories.ProductRepository;
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
}
