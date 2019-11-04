package com.unipe.feirafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unipe.feirafacil.models.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
