package com.unipe.feirafacil.api.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.unipe.feirafacil.models.ProductOrder;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductOrderResponse {

    private Long id;
    
    private Long orderId;
    
    private Long productId;
    
    private String name;

    private BigDecimal price;
    
    public static ProductOrderResponse toResponse(ProductOrder productOrder) {
	return ProductOrderResponse.builder()
		.id(productOrder.getId())
		.orderId(productOrder.getOrder().getId())
		.productId(productOrder.getProduct().getId())
		.name(productOrder.getName())
		.price(productOrder.getPrice())
		.build();
    }
    
    public static List<ProductOrderResponse> toResponse(List<ProductOrder> products) {
	return products.stream()
		.map(product -> ProductOrderResponse.toResponse(product))
		.collect(Collectors.toList());
    }
    
}
