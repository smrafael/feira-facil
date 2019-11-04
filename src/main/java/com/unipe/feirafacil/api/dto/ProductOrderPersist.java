package com.unipe.feirafacil.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.models.Product;
import com.unipe.feirafacil.models.ProductOrder;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductOrderPersist {
    
    @NotNull
    @Min(1L)
    private Long productId;
    
    public ProductOrder toProductOrder() {
	return ProductOrder.builder()
		.product(Product.builder().id(productId).build())
		.build();
    }
    
}
