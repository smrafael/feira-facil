package com.unipe.feirafacil.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.unipe.feirafacil.models.Order;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderResponse {

    private Long id;
    
    private Long clientId;
    
    private Long discountId;
    
    private String status;
    
    private LocalDateTime orderedAt;
    
    public static OrderResponse toResponse(Order order) {
	return OrderResponse.builder()
		.id(order.getId())
		.clientId(order.getClient().getId())
		.discountId(order.getDiscount().getId())
		.status(order.getStatus().toString())
		.orderedAt(order.getOrderedAt())
		.build();
    }
    
    public static List<OrderResponse> toResponse(List<Order> orders) {
	return orders.stream()
		.map(order -> OrderResponse.toResponse(order))
		.collect(Collectors.toList());
    }
    
}
