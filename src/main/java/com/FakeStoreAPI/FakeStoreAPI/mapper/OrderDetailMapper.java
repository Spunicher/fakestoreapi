package com.FakeStoreAPI.FakeStoreAPI.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.FakeStoreAPI.FakeStoreAPI.models.OrderDetail;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.OrderDetailDTO;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailDTO toDTO(OrderDetail entity);
    List<OrderDetailDTO> toDTOList(List<OrderDetail> entities);
}
