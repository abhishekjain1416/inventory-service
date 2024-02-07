package com.programmingtechie.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
@JsonInclude(Include.NON_NULL)
public class ParentResponse {

	@JsonProperty("mc")
	private String messageCode;
	
	@JsonProperty("m")
	private String message;
}
