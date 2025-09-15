package com.vintageonline.controller;

import com.vintageonline.model.Order;
import com.vintageonline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ORDER_MANAGER')")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ORDER_MANAGER')")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ORDER_MANAGER')")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}