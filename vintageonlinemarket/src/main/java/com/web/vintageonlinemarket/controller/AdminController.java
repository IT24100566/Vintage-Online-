package com.web.vintageonlinemarket.controller;



import com.web.vintageonlinemarket.entity.Admin;
import com.web.vintageonlinemarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping
    public List<Admin> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Admin getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Admin create(@RequestBody Admin admin) {
        return service.save(admin);
    }

    @PutMapping("/{id}")
    public Admin update(@PathVariable Long id, @RequestBody Admin admin) {
        admin.setAId(id);
        return service.save(admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin loginRequest) {
        return service.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}