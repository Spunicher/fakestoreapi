package com.FakeStoreAPI.FakeStoreAPI.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.ProductDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.products.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(ProductResponse response);
    List<ProductDTO> toDTOList(List<ProductResponse> response);
}
