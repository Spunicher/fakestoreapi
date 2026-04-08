package com.FakeStoreAPI.FakeStoreAPI.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FakeStoreAPI.FakeStoreAPI.mapper.PaymentMapper;
import com.FakeStoreAPI.FakeStoreAPI.models.Order;
import com.FakeStoreAPI.FakeStoreAPI.models.Payment;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.PaymentDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.enums.OrderStatus;
import com.FakeStoreAPI.FakeStoreAPI.models.enums.PaymentStatus;
import com.FakeStoreAPI.FakeStoreAPI.repository.OrderRepository;
import com.FakeStoreAPI.FakeStoreAPI.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Transactional
    public PaymentDTO simulatePayment(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        if (order.getStatus() == OrderStatus.PAID) {
            throw new IllegalArgumentException("Order is already paid");
        }

        paymentRepository.findByOrderId(orderId).ifPresent(payment -> {
            throw new IllegalArgumentException("A payment has already been registered for this order");
        });

        Payment payment = Payment.builder()
                .orderId(order.getId())
                .amount(order.getTotal())
                .paymentDate(LocalDateTime.now())
                .status(PaymentStatus.APPROVED)
                .transactionReference(UUID.randomUUID().toString())
                .build();

        Payment savedPayment = paymentRepository.save(payment);

        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);

        return paymentMapper.toDTO(savedPayment);
    }
}
