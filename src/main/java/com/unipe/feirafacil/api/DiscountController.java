package com.unipe.feirafacil.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unipe.feirafacil.api.dto.DiscountPersist;
import com.unipe.feirafacil.api.dto.DiscountResponse;
import com.unipe.feirafacil.api.dto.DiscountUpdate;
import com.unipe.feirafacil.models.Discount;
import com.unipe.feirafacil.services.DiscountService;

import io.swagger.annotations.Api;

@Api(tags = "Discounts")
@RequestMapping("/discounts")
@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;
    
    @PostMapping
    public DiscountResponse createDiscount(@RequestBody DiscountPersist discountPersist) {
	Discount discount = discountService.create(discountPersist.toDiscount());
	return DiscountResponse.toResponse(discount);
    }
    
    @GetMapping
    public List<DiscountResponse> listDiscounts() {
	return DiscountResponse.toResponse(discountService.list());
    }
    
    @PutMapping("/{id}")
    public DiscountResponse updateDiscount(@PathVariable("id") Long id, @RequestBody DiscountUpdate discountPersist) throws Exception {
	Discount discount = discountPersist.toDiscount();
	discount.setId(id);
	return DiscountResponse.toResponse(discountService.update(discount));
    }
    
    @GetMapping("/{id}")
    public DiscountResponse getDiscount(@PathVariable("id") Long id) {
	return DiscountResponse.toResponse(discountService.get(id));
    }
    
}
