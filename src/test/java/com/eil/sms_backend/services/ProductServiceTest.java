package com.eil.sms_backend.services;


import com.eil.sms_backend.entities.Product;
import com.eil.sms_backend.exceptions.ItemsNotFoundException;
import com.eil.sms_backend.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest{
    @Mock
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @BeforeAll
    void setUp() {

    }

    @Test
    public void should_throw_when_no_product_on_database() {
        //arrange
        Mockito.when(productRepository.findAll()).thenReturn(new ArrayList<>());

        //act and assert
        Assert.assertThrows(ItemsNotFoundException.class, () -> {
           productService.getAllProducts();
        });
    }


    @Test
    public void should_return_list_of_products() {
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            products.add(
                    new Product(Long.valueOf(i), "code------"+i, "product " + i, Math.random() * 10, new Date())
            );
        }
        Mockito.when(productRepository.findAll()).thenReturn(products);
        System.out.println(products);
        //act and assert
        try {
            Assert.assertEquals(products, productService.getAllProducts());
        } catch (ItemsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}