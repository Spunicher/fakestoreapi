package com.FakeStoreAPI.FakeStoreAPI.mapper;

import org.mapstruct.Mapper;

import com.FakeStoreAPI.FakeStoreAPI.models.Payment;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.PaymentDTO;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO toDTO(Payment entity);
}