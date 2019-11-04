package com.unipe.feirafacil.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductPersist {
    
    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;
    
    public Product toProduct() {
	return Product.builder()
		.name(name)
		.price(price)
		.build();
    }
    
}
