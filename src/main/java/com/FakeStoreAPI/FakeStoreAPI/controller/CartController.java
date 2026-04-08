package com.FakeStoreAPI.FakeStoreAPI.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.CartDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.carts.CartRequest;
import com.FakeStoreAPI.FakeStoreAPI.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService service;

    @GetMapping
    public ResponseEntity<List<CartDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CartDTO> create(@RequestBody CartRequest request) {
        request.setDate(new Date().toString());
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDTO> update(
            @PathVariable Long id,
            @RequestBody CartRequest request) {
        request.setDate(new Date().toString());
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Cart deleted successfully");
    }
}
