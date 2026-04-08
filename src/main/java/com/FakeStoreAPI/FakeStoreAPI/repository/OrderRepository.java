package com.FakeStoreAPI.FakeStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FakeStoreAPI.FakeStoreAPI.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
