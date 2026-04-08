package com.FakeStoreAPI.FakeStoreAPI.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.CartDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.carts.CartResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CartMapper {

    @Mapping(target = "products", ignore = true)
    CartDTO toDTO(CartResponse response);

    List<CartDTO> toDTOList(List<CartResponse> response);
}