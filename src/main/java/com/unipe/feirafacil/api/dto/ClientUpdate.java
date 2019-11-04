package com.unipe.feirafacil.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.unipe.feirafacil.models.Client;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientUpdate {

    @NotNull
    @Min(1L)
    private Long id;
    
    @NotBlank
    private String name;
    
    public Client toClient() {
	return Client.builder()
		.id(id)
		.name(name)
		.build();
    }
    
}
