package com.unipe.feirafacil.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.unipe.feirafacil.models.Client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientResponse {
    
    private Long id;

    private String name;
    
    public static ClientResponse toResponse(Client client) {
	return ClientResponse.builder()
		.id(client.getId())
		.name(client.getName())
		.build();
    }
    
    public static List<ClientResponse> toResponse(List<Client> clients) {
	return clients.stream()
		.map(client -> ClientResponse.toResponse(client))
		.collect(Collectors.toList());
    }

}
