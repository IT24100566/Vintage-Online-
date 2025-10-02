package com.web.vintageonlinemarket.service;



import com.web.vintageonlinemarket.entity.Cart;
import com.web.vintageonlinemarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;

    public List<Cart> getAll() {
        return repository.findAll();
    }

    public Cart getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cart save(Cart cart) {
        return repository.save(cart);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

