package com.programmingtechie.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;

    /**
     * This method checks if the list of SKU codes is in stock and returns a list of InventoryResponse objects.
     * 
     * This method is used for retrieving data and not for modifying the database.
     * i.e. the transaction is read-only and does not involve any write operations.
     * 
     * @param skuCode
     * @return
     */
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){

        // Retrieve inventory items from the repository based on the provided SKU codes
        return inventoryRepository.findBySkuCodeIn(skuCode)
            // Convert the list of Inventory objects to a list of InventoryResponse objects
            .stream()
            .map(inventory -> 
                // Map each Inventory object to an InventoryResponse object
                InventoryResponse.builder()
                    .skuCode(inventory.getSkuCode())
                    .isInStock(inventory.getQuantity() > 0)
                    .build()
            ).toList();
    }
}
