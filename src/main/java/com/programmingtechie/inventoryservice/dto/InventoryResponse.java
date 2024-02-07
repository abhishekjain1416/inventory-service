package com.programmingtechie.inventoryservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class InventoryResponse extends ParentResponse {
    
	@JsonProperty("lc")
    private List<InventoryDto> inventoryList;
}
