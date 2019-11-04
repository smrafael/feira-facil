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

import com.unipe.feirafacil.api.dto.ProductPersist;
import com.unipe.feirafacil.api.dto.ProductResponse;
import com.unipe.feirafacil.api.dto.ProductUpdate;
import com.unipe.feirafacil.models.Product;
import com.unipe.feirafacil.services.ProductService;

import io.swagger.annotations.Api;

@Api(tags = "Products")
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductPersist p) {
	return ProductResponse.toResponse(productService.create(p.toProduct()));
    }
    
    @GetMapping
    public List<ProductResponse> listProducts() {
	return ProductResponse.toResponse(productService.list());
    }
    
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductUpdate p) throws Exception {
	Product product = p.toProduct();
	product.setId(id);
	return ProductResponse.toResponse(productService.update(product));
    }
    
    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long id) {
	return ProductResponse.toResponse(productService.get(id));
    }
    
}
