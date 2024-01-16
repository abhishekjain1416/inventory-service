package com.programmingtechie.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

@Service
public interface InventoryService {

    // This method checks if the list of SKU codes is in stock and returns a list of InventoryResponse objects.
    List<InventoryResponse> isInStock(List<String> skuCode);
}
