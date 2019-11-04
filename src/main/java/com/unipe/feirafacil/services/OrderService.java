package com.unipe.feirafacil.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipe.feirafacil.enums.OrderStatus;
import com.unipe.feirafacil.models.Order;
import com.unipe.feirafacil.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    public Order create(Order o) {
	o.setId(null);
	o.setStatus(OrderStatus.OPEN);
	o.setOrderedAt(LocalDateTime.now());
	return orderRepository.save(o);
    }
    
    public Order update(Order o) throws Exception {
	if (o == null || o.getId() == null || o.getId() <= 0L) {
	    throw new Exception("id cannot be null");
	}
	
	Order orderDB = orderRepository.findById(o.getId()).get();
	if (orderDB.getStatus() != OrderStatus.OPEN) {
	    throw new Exception("order no longer open");
	}
	
	o.setOrderedAt(orderDB.getOrderedAt());
	return orderRepository.save(o);
    }
    
    public List<Order> list() {
	return orderRepository.findAll();
    }
    
    public Order get(Long id) {
	return orderRepository.findById(id).get();
    }
    
}
