package com.unipe.feirafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipe.feirafacil.models.Discount;
import com.unipe.feirafacil.repositories.DiscountRepository;

@Service
public class DiscountService {
    
    @Autowired
    private DiscountRepository discountRepository;
    
    public Discount create(Discount d) {
	d.setId(null);
	return discountRepository.save(d);
    }
    
    public Discount update(Discount d) throws Exception {
	if (d == null || d.getId() == null || d.getId() <= 0L) {
	    throw new Exception("id cannot be null");
	}
	return discountRepository.save(d);
    }
    
    public List<Discount> list() {
	return discountRepository.findAll();
    }
    
    public Discount get(Long id) {
	return discountRepository.findById(id).get();
    }

}
