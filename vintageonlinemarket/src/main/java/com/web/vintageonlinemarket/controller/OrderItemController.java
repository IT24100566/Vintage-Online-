package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.OrderItem;
import com.web.vintageonlinemarket.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService service;

    @GetMapping
    public List<OrderItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OrderItem getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public OrderItem create(@RequestBody OrderItem orderItem) {
        return service.save(orderItem);
    }

    @PutMapping("/{id}")
    public OrderItem update(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        orderItem.setId(id);
        return service.save(orderItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
