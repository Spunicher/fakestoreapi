package com.FakeStoreAPI.FakeStoreAPI.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.FakeStoreAPI.FakeStoreAPI.models.Order;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.OrderDTO;

@Mapper(componentModel = "spring", uses = OrderDetailMapper.class)
public interface OrderMapper {

    @Mapping(target = "details", source = "details")
    OrderDTO toDTO(Order entity);

    List<OrderDTO> toDTOList(List<Order> entities);
}
