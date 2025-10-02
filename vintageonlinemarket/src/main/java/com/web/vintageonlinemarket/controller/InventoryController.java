package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.Inventory;
import com.web.vintageonlinemarket.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return service.save(inventory);
    }

    @PutMapping("/{id}")
    public Inventory update(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setInId(id);
        return service.save(inventory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

/*package com.web.vintageonlinemarket.controller;

import com.web.vintageonlinemarket.entity.Inventory;
import com.web.vintageonlinemarket.entity.Product;
import com.web.vintageonlinemarket.service.InventoryService;
import com.web.vintageonlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    @Autowired
    private InventoryService service;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Inventory inventory = service.getById(id);
        return inventory != null ? ResponseEntity.ok(inventory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Inventory inventory) {
        try {
            if (inventory.getProduct() != null && inventory.getProduct().getProductId() != null) {
                Product product = productService.getById(inventory.getProduct().getProductId());
                if (product == null) {
                    return ResponseEntity.badRequest().body("{\"error\": \"Invalid product ID\"}");
                }
                inventory.setProduct(product);
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"Product ID is required\"}");
            }
            Inventory saved = service.save(inventory);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save inventory: " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setInId(id);
        try {
            if (inventory.getProduct() != null && inventory.getProduct().getProductId() != null) {
                Product product = productService.getById(inventory.getProduct().getProductId());
                if (product == null) {
                    return ResponseEntity.badRequest().body("{\"error\": \"Invalid product ID\"}");
                }
                inventory.setProduct(product);
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"Product ID is required\"}");
            }
            Inventory saved = service.save(inventory);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save inventory: " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to delete inventory: " + e.getMessage() + "\"}");
        }
    }
}

/*package com.web.vintageonlinemarket.controller;

import com.web.vintageonlinemarket.entity.Inventory;
import com.web.vintageonlinemarket.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Inventory inventory = service.getById(id);
        return inventory != null ? ResponseEntity.ok(inventory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Inventory inventory) {
        try {
            if (inventory.getName() == null || inventory.getPrice() == null || inventory.getQuantity() == null) {
                return ResponseEntity.badRequest().body("{\"error\": \"Name, price, and quantity are required\"}");
            }
            Inventory saved = service.save(inventory);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save inventory: " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setInId(id);
        try {
            if (inventory.getName() == null || inventory.getPrice() == null || inventory.getQuantity() == null) {
                return ResponseEntity.badRequest().body("{\"error\": \"Name, price, and quantity are required\"}");
            }
            Inventory saved = service.save(inventory);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save inventory: " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to delete inventory: " + e.getMessage() + "\"}");
        }
    }
}*/