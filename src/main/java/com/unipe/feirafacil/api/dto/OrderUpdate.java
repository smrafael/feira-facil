package com.unipe.feirafacil.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.enums.OrderStatus;
import com.unipe.feirafacil.models.Client;
import com.unipe.feirafacil.models.Discount;
import com.unipe.feirafacil.models.Order;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderUpdate {
    
    @NotNull
    @Min(1L)
    private Long id;
    
    @NotNull
    @Min(1L)
    private Long clientId;
    
    @NotNull
    @Min(1L)
    private Long discountId;
    
    @NotBlank
    private String status;
    
    public Order toOrder() {
	Order order = Order.builder()
		.id(id)
		.client(Client.builder().id(this.clientId).build())
		.discount(Discount.builder().id(this.discountId).build())
		.status(OrderStatus.valueOf(status))
		.build();
	
	return order;
    }

}
