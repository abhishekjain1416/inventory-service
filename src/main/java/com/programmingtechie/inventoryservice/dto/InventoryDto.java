package com.programmingtechie.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class InventoryDto {

	@JsonProperty("skuCode")
	private String skuCode;
	
	@JsonProperty("isInStock")
    private Boolean isInStock;
}
