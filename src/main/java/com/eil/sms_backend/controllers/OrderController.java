package com.eil.sms_backend.controllers;

import com.eil.sms_backend.entities.StoreOrder;
import com.eil.sms_backend.entities.OrderLine;
import com.eil.sms_backend.services.OrderService;
import com.eil.sms_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;


    @PostMapping("/save")
    public ResponseEntity<StoreOrder> createOrder(@RequestBody StoreOrder storeOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(storeOrder));
    }


//    @GetMapping("/generateOrder")
//    public StoreOrder orderFormat() {
//        StoreOrder storeOrder = new StoreOrder(1l, new Date(), new ArrayList<>());
////        OrderLine orderLine = new OrderLine(null, storeOrder, 12, productService.getProduct("code------1"));
////        OrderLine orderLine1 = new OrderLine(null, storeOrder, 23, productService.getProduct("code------2"));
//        storeOrder.getOrderLines().add(orderLine);
//        storeOrder.getOrderLines().add(orderLine1);
//        storeOrder = orderService.createOrder(storeOrder);
//        return storeOrder;
//    } 
}
