package com.unipe.feirafacil.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.models.Client;
import com.unipe.feirafacil.models.Discount;
import com.unipe.feirafacil.models.Order;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderPersist {
    
    @NotNull
    @Min(1L)
    private Long clientId;
    
    @Min(1L)
    private Long discountId;
    
    public Order toOrder() {
	Order order = Order.builder()
		.client(Client.builder().id(this.clientId).build())
		.discount(Discount.builder().id(this.discountId).build())
		.build();
	
	return order;
    }

}
