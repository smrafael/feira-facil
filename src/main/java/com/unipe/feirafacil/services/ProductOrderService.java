package com.unipe.feirafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipe.feirafacil.enums.OrderStatus;
import com.unipe.feirafacil.models.Order;
import com.unipe.feirafacil.models.Product;
import com.unipe.feirafacil.models.ProductOrder;
import com.unipe.feirafacil.repositories.ProductOrderRepository;

@Service
public class ProductOrderService {
    
    @Autowired
    private ProductOrderRepository productOrderRepository;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ProductService productService;
    
    public ProductOrder create(ProductOrder productOrder) throws Exception {
	Order order = orderService.get(productOrder.getOrder().getId());
	Product product = productService.get(productOrder.getProduct().getId());
	
	if (order.getStatus() == OrderStatus.OPEN) {
	    productOrder.setId(null);
	    productOrder.setOrder(order);
	    productOrder.setProduct(product);
	    productOrder.setName(product.getName());
	    productOrder.setPrice(product.getPrice());
	    
	    return productOrderRepository.save(productOrder);
	}
	
	throw new Exception("order no longer open");
	
    }
    
    public ProductOrder getBy(Order order, Long id) {
	return productOrderRepository.findById(id).get();
    }
    
    public List<ProductOrder> listBy(Order order) {
	return productOrderRepository.findAllByOrder(order);
    }
    
    public void delete(ProductOrder productOrder) throws Exception {
	
	if (productOrder == null) {
	    throw new IllegalArgumentException("ProductOrder cannot be null");
	}
	
	if (productOrder.getId() == null || productOrder.getId() <= 0L) {
	    throw new IllegalArgumentException("id cannot be null");
	}
	
	Order order = productOrder.getOrder();
	if (order == null || order.getId() == null || order.getId() <= 0L) {
	    throw new IllegalArgumentException("order id cannot be null");
	}
	
	ProductOrder productOrderBD = productOrderRepository.findById(productOrder.getId()).get();
	if (!productOrderBD.getOrder().getId().equals(order.getId())) {
	    throw new IllegalArgumentException("product do not belongs to order provided");
	}
	
	productOrderRepository.delete(productOrderBD);
    }
    
}
