package com.unipe.feirafacil.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.unipe.feirafacil.models.Discount;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DiscountResponse {
    
    private Long id;

    private String name;
    
    private BigDecimal discount;
    
    private String type;
    
    private LocalDateTime expiration;
    
    public static DiscountResponse toResponse(Discount discount) {
	return DiscountResponse.builder()
		.id(discount.getId())
		.name(discount.getName())
		.discount(discount.getDiscount())
		.type(discount.getType().toString())
		.expiration(discount.getExpiration())
		.build();
    }
    
    public static List<DiscountResponse> toResponse(List<Discount> discounts) {
	return discounts.stream()
		.map(discount -> DiscountResponse.toResponse(discount))
		.collect(Collectors.toList());
    }

}
