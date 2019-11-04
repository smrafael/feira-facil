package com.unipe.feirafacil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unipe.feirafacil.models.Order;
import com.unipe.feirafacil.models.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    
    List<ProductOrder> findAllByOrder(Order order);
    
    ProductOrder findByOrderAndId(Order order, Long id);

}
