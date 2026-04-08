package com.FakeStoreAPI.FakeStoreAPI.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.FakeStoreAPI.FakeStoreAPI.mapper.OrderMapper;
import com.FakeStoreAPI.FakeStoreAPI.models.Order;
import com.FakeStoreAPI.FakeStoreAPI.models.OrderDetail;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.CartDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.OrderDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.ProductCartDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.enums.OrderStatus;
import com.FakeStoreAPI.FakeStoreAPI.repository.OrderRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderMapper orderMapper;
    private final PaymentService paymentService;

    @Transactional
    public OrderDTO createOrderFromCart(Long cartId) {
        CartDTO cart = cartService.getById(cartId);

        if (Objects.isNull(cart)) {
            throw new IllegalArgumentException("Cart not found");
        }

        if (Objects.isNull(cart.getProducts()) || cart.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Cart has no products");
        }

        Order order = Order.builder()
                .customerId(cart.getUserId())
                .createdAt(LocalDateTime.now())
                .status(OrderStatus.PENDING_PAYMENT)
                .total(BigDecimal.ZERO)
                .build();

        BigDecimal total = BigDecimal.ZERO;

        if (cart.getProducts().isEmpty()) {
            throw new IllegalArgumentException("The cart is empty.");
        }

        for (ProductCartDTO product : cart.getProducts()) {
            BigDecimal unitPrice = product.getPrice();
            BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(product.getQuantity()));

            OrderDetail detail = OrderDetail.builder()
                    .order(order)
                    .productId(product.getId())
                    .productTitle(product.getTitle())
                    .unitPrice(unitPrice)
                    .quantity(product.getQuantity())
                    .subtotal(subtotal)
                    .productCategory(product.getCategory())
                    .productImage(product.getImage())
                    .build();

            order.getDetails().add(detail);
            total = total.add(subtotal);
        }

        order.setTotal(total);

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDTO(savedOrder);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        return orderMapper.toDTOList(orderRepository.findAll());
    }

    @Transactional(readOnly = true)
    public OrderDTO getOrderById(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return orderMapper.toDTO(order);
    }

    @Transactional
    public Object updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        if (Objects.isNull(status)) {
            status = OrderStatus.PAID;
        }

        if (status == OrderStatus.PAID) {
            return paymentService.simulatePayment(id);
        }

        order.setStatus(status);
        Order updatedOrder = orderRepository.save(order);
        return orderMapper.toDTO(updatedOrder);
    }
}
