package com.unipe.feirafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipe.feirafacil.models.Product;
import com.unipe.feirafacil.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product create(Product p) {
	p.setId(null);
	return productRepository.save(p);
    }
    
    public Product update(Product p) throws Exception {
	if (p == null || p.getId() == null || p.getId() <= 0L) {
	    throw new Exception("id cannot be null");
	}
	
	return productRepository.save(p);
    }
    
    public List<Product> list() {
	return productRepository.findAll();
    }
    
    public Product get(Long id) {
	return productRepository.findById(id).get();
    }

}
