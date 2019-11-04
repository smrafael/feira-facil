package com.unipe.feirafacil.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unipe.feirafacil.api.dto.OrderPersist;
import com.unipe.feirafacil.api.dto.OrderResponse;
import com.unipe.feirafacil.api.dto.OrderUpdate;
import com.unipe.feirafacil.models.Order;
import com.unipe.feirafacil.services.OrderService;

import io.swagger.annotations.Api;

@Api(tags = "Orders")
@RequestMapping("/orders")
@RestController
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderPersist orderPersist) {
	return OrderResponse.toResponse(orderService.create(orderPersist.toOrder()));
    }
    
    @PutMapping("/{id}")
    public OrderResponse updateOrder(@PathVariable("id") Long id, @RequestBody OrderUpdate orderUpdate) throws Exception {
	Order order = orderUpdate.toOrder();
	order.setId(id);
	
	return OrderResponse.toResponse(orderService.update(order));
    }
    
    @GetMapping
    public List<OrderResponse> listOrders() {
	return OrderResponse.toResponse(orderService.list());
    }
    
    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable("id") Long id) {
	return OrderResponse.toResponse(orderService.get(id));
    }

}
