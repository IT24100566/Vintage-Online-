/*package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.Shop;
import com.web.vintageonlinemarket.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private ShopService service;

    @GetMapping
    public List<Shop> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Shop getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Shop create(@RequestBody Shop shop) {
        return service.save(shop);
    }

    @PutMapping("/{id}")
    public Shop update(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setSid(id);
        return service.save(shop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}*/

package com.web.vintageonlinemarket.controller;

import com.web.vintageonlinemarket.entity.Shop;
import com.web.vintageonlinemarket.entity.User;
import com.web.vintageonlinemarket.service.ShopService;
import com.web.vintageonlinemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private ShopService service;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Shop> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Shop shop = service.getById(id);
        return shop != null ? ResponseEntity.ok(shop) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Shop shop) {
        try {
            if (shop.getSeller() != null && shop.getSeller().getIdNo() != null) {
                User seller = userService.getById(shop.getSeller().getIdNo());
                if (seller == null) {
                    return ResponseEntity.badRequest().body("{\"error\": \"Invalid seller ID\"}");
                }
                shop.setSeller(seller);
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"Seller ID is required\"}");
            }
            Shop saved = service.save(shop);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save shop: " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setSid(id);
        try {
            if (shop.getSeller() != null && shop.getSeller().getIdNo() != null) {
                User seller = userService.getById(shop.getSeller().getIdNo());
                if (seller == null) {
                    return ResponseEntity.badRequest().body("{\"error\": \"Invalid seller ID\"}");
                }
                shop.setSeller(seller);
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"Seller ID is required\"}");
            }
            Shop saved = service.save(shop);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save shop: " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to delete shop: " + e.getMessage() + "\"}");
        }
    }
}
