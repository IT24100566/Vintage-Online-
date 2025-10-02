/*package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.Product;
import com.web.vintageonlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        product.setProductId(id);
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}*/

package com.web.vintageonlinemarket.controller;

import com.web.vintageonlinemarket.entity.Product;
import com.web.vintageonlinemarket.entity.User;
import com.web.vintageonlinemarket.service.ProductService;
import com.web.vintageonlinemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Product product = service.getById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product) {
        try {
            if (product.getSeller() != null && product.getSeller().getIdNo() != null) {
                User seller = userService.getById(product.getSeller().getIdNo());
                if (seller == null) {
                    return ResponseEntity.badRequest().body("{\"error\": \"Invalid seller ID\"}");
                }
                product.setSeller(seller);
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"Seller ID is required\"}");
            }
            Product saved = service.save(product);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to save product: " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product) {
        product.setProductId(id);
        try {
            if (product.getSeller() != null && product.getSeller().getIdNo() != null) {
                User seller = userService.getById(product.getSeller().getIdNo());
                if (seller == null) {
                    return ResponseEntity.badRequest().body("{\"error\": \"Invalid seller ID\"}");
                }
                product.setSeller(seller);
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"Seller ID is required\"}");
            }
            Product saved = service.save(product);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to update product: " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"Failed to delete product: " + e.getMessage() + "\"}");
        }
    }
}


