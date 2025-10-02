package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.Cart;
import com.web.vintageonlinemarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService service;

    @GetMapping
    public List<Cart> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cart getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Cart create(@RequestBody Cart cart) {
        return service.save(cart);
    }

    @PutMapping("/{id}")
    public Cart update(@PathVariable Long id, @RequestBody Cart cart) {
        cart.setCartId(id);
        return service.save(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
