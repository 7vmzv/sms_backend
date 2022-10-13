package com.eil.sms_backend.services;

import com.eil.sms_backend.entities.OrderLine;
import com.eil.sms_backend.entities.StoreOrder;
import com.eil.sms_backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public StoreOrder createOrder(StoreOrder storeOrder) {
        storeOrder.setDate(new Date());

        storeOrder = orderRepository.save(storeOrder);
        return storeOrder;
    }
}
