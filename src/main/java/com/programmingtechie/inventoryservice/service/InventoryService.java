package com.programmingtechie.inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmingtechie.inventoryservice.dto.InventoryResponse;

@Service
public interface InventoryService {

    // This method checks if the list of SKU codes is in stock and returns a list of InventoryResponse objects.
    InventoryResponse isInStock(List<String> skuCode);
}
