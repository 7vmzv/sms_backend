package com.eil.sms_backend.repositories;

import com.eil.sms_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findProductByQrCode(String qrCode);
}
