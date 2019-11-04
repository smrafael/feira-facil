package com.unipe.feirafacil.api.dto;

import javax.validation.constraints.NotBlank;

import com.unipe.feirafacil.models.Client;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientPersist {

    @NotBlank
    private String name;
    
    public Client toClient() {
	return Client.builder()
		.name(name)
		.build();
    }
    
}
