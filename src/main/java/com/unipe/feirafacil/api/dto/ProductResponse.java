package com.unipe.feirafacil.api.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.unipe.feirafacil.models.Product;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponse {
    
    private Long id;

    private String name;

    private BigDecimal price;
    
    public static ProductResponse toResponse(Product product) {
	return ProductResponse.builder()
		.id(product.getId())
		.name(product.getName())
		.price(product.getPrice())
		.build();
    }
    
    public static List<ProductResponse> toResponse(List<Product> products) {
	return products.stream()
		.map(product -> ProductResponse.toResponse(product))
		.collect(Collectors.toList());
    }

}
