package com.unipe.feirafacil.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.enums.DiscountType;
import com.unipe.feirafacil.models.Discount;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DiscountPersist {

    @NotBlank
    private String name;
    
    @NotNull
    private BigDecimal discount;
    
    @NotBlank
    private String type;
    
    @NotNull
    private LocalDateTime expiration;
    
    public Discount toDiscount() {
	return Discount.builder()
		.name(name)
		.discount(discount)
		.type(DiscountType.valueOf(type))
		.expiration(expiration)
		.build();
    }
    
}
