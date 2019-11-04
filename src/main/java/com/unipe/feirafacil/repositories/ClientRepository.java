package com.unipe.feirafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unipe.feirafacil.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
