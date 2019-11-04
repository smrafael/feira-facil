package com.unipe.feirafacil.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unipe.feirafacil.api.dto.ProductOrderPersist;
import com.unipe.feirafacil.api.dto.ProductOrderResponse;
import com.unipe.feirafacil.models.Order;
import com.unipe.feirafacil.models.ProductOrder;
import com.unipe.feirafacil.services.ProductOrderService;

import io.swagger.annotations.Api;

@Api(tags = "Orders")
@RequestMapping("/orders/{orderId}/products")
@RestController
public class ProductOrderController {
    
    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping
    public ProductOrderResponse createProductOrder(@PathVariable("orderId") Long orderId, 
	    @RequestBody ProductOrderPersist productOrderPersist) throws Exception {
	
	ProductOrder productOrder = productOrderPersist.toProductOrder();
	productOrder.setOrder(Order.builder().id(orderId).build());
	
	return ProductOrderResponse.toResponse(productOrderService.create(productOrder));
	
    }
    
    @GetMapping
    public List<ProductOrderResponse> listProductsOrder(@PathVariable("orderId") Long orderId) {
	return ProductOrderResponse.toResponse(
		productOrderService.listBy(Order.builder().id(orderId).build())
		);
    }
    
    @GetMapping("/{id}")
    public ProductOrderResponse getProductOrder(@PathVariable("orderId") Long orderId, @PathVariable("id") Long productOrderId) {
	Order order = Order.builder().id(orderId).build();
	return ProductOrderResponse.toResponse(productOrderService.getBy(order, productOrderId));
    }
    
    @DeleteMapping("/{id}")
    public void deleteProductOrder(@PathVariable("orderId") Long orderId, @PathVariable("id") Long productOrderId) throws Exception {
	ProductOrder productOrder = ProductOrder.builder()
		.id(productOrderId)
		.order(Order.builder().id(orderId).build())
		.build();
	
	productOrderService.delete(productOrder);
    }
    
}
