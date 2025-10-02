package com.web.vintageonlinemarket.service;




import com.web.vintageonlinemarket.entity.Shop;
import com.web.vintageonlinemarket.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository repository;

    public List<Shop> getAll() {
        return repository.findAll();
    }

    public Shop getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Shop save(Shop shop) {
        return repository.save(shop);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}