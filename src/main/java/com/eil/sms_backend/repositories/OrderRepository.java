package com.eil.sms_backend.repositories;

import com.eil.sms_backend.entities.StoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<StoreOrder, Long> {

}
