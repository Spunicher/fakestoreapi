package com.FakeStoreAPI.FakeStoreAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.OrderDTO;
import com.FakeStoreAPI.FakeStoreAPI.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/from-cart/{cartId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrderFromCart(@PathVariable Long cartId) {
        return orderService.createOrderFromCart(cartId);
    }
}
