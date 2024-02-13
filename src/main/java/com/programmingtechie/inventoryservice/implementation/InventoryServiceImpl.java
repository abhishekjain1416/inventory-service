package com.programmingtechie.inventoryservice.implementation;

import java.util.List;

import com.programmingtechie.inventoryservice.enums.InventoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.inventoryservice.dto.InventoryDto;
import com.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import com.programmingtechie.inventoryservice.service.InventoryService;

@Component
public class InventoryServiceImpl implements InventoryService {

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
	@Override
    @Transactional(readOnly = true)
    public InventoryResponse isInStock(List<String> skuCode){

        // Retrieve inventory items from the repository based on the provided SKU codes
        List<InventoryDto> inventoryList = inventoryRepository.findBySkuCodeIn(skuCode)
            // Convert the list of Inventory objects to a list of InventoryResponse objects
            .stream()
            .map(inventory -> 
                // Map each Inventory object to an InventoryResponse object
            	InventoryDto.builder()
                    .skuCode(inventory.getSkuCode())
                    .isInStock(inventory.getQuantity() > 0)
                    .build()
            ).toList();
        
        InventoryResponse response = new InventoryResponse();
        response.setMessageCode(InventoryEnum.DATA_FETCHED_SUCCESSFULLY.getSuccessCode());
        response.setMessage(InventoryEnum.DATA_FETCHED_SUCCESSFULLY.getMessage());
        response.setInventoryList(inventoryList);
        
        return response;
    }
}
