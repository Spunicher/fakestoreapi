package com.FakeStoreAPI.FakeStoreAPI.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FakeStoreAPI.FakeStoreAPI.models.enums.OrderStatus;
import com.FakeStoreAPI.FakeStoreAPI.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final OrderService orderService;

    @PutMapping("/{id}")
    public Object updateOrderStatus(@PathVariable Long id,
            @RequestParam(required = false) OrderStatus status) {
        return orderService.updateOrderStatus(id, status);
    }
}
