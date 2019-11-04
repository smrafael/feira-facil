package com.unipe.feirafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unipe.feirafacil.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
