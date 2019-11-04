package com.unipe.feirafacil.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductUpdate {
    
    @NotNull
    @Min(1L)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;
    
    public Product toProduct() {
	return Product.builder()
		.id(id)
		.name(name)
		.price(price)
		.build();
    }
    
}
