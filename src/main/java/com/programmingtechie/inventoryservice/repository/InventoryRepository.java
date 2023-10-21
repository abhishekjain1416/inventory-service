package com.programmingtechie.inventoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmingtechie.inventoryservice.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
    
}
