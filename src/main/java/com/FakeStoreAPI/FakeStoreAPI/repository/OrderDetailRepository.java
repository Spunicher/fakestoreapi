package com.FakeStoreAPI.FakeStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FakeStoreAPI.FakeStoreAPI.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
