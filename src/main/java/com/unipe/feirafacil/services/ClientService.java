package com.unipe.feirafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipe.feirafacil.models.Client;
import com.unipe.feirafacil.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public Client create(Client c) {
	c.setId(null);
	return clientRepository.save(c);
    }
    
    public Client update(Client c) throws Exception {
	if (c == null || c.getId() == null || c.getId() <= 0L) {
	    throw new Exception("id cannot be null");
	}
	
	return clientRepository.save(c);
    }
    
    public List<Client> list() {
	return clientRepository.findAll();
    }
    
    public Client get(Long id) {
	return clientRepository.findById(id).get();
    }

}
