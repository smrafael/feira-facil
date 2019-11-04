package com.unipe.feirafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unipe.feirafacil.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
