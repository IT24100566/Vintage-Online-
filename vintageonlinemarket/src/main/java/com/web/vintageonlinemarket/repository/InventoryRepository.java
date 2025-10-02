package com.web.vintageonlinemarket.repository;

import com.web.vintageonlinemarket.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
