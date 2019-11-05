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

import com.unipe.feirafacil.api.dto.ClientPersist;
import com.unipe.feirafacil.api.dto.ClientResponse;
import com.unipe.feirafacil.api.dto.ClientUpdate;
import com.unipe.feirafacil.models.Client;
import com.unipe.feirafacil.services.ClientService;

import io.swagger.annotations.Api;

@Api(tags = "Clients")
@RequestMapping("/clients")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @PostMapping
    public ClientResponse createClient(@RequestBody ClientPersist clientPersist) {
	return ClientResponse.toResponse(clientService.create(clientPersist.toClient()));
    }
    
    @GetMapping
    public List<ClientResponse> listClients() {
	return ClientResponse.toResponse(clientService.list());
    }
    
    @PutMapping("/{id}")
    public ClientResponse updateClient(@PathVariable("id") Long id, @RequestBody ClientUpdate clientUpdate) throws Exception {
	Client client = clientUpdate.toClient();
	client.setId(id);
	return ClientResponse.toResponse(clientService.update(client));
    }
    
    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable("id") Long id) {
	return ClientResponse.toResponse(clientService.get(id));
    }
    
}
