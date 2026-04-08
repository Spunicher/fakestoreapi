package com.FakeStoreAPI.FakeStoreAPI.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.FakeStoreAPI.FakeStoreAPI.feign.FakeStoreProductClient;
import com.FakeStoreAPI.FakeStoreAPI.mapper.ProductMapper;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.ProductDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.products.ProductRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.products.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final FakeStoreProductClient client;
    private final ProductMapper mapper;

    public List<ProductDTO> getAll() {
        return mapper.toDTOList(client.getAllProducts());
    }

    public ProductDTO getById(Long id) {
        ProductResponse productDTO = client.getProductById(id);
        if (Objects.isNull(productDTO)) {
            throw new IllegalArgumentException("Product not found");
        }
        return mapper.toDTO(productDTO);
    }

    public ProductDTO create(ProductRequest request) {
        return mapper.toDTO(client.createProduct(request));
    }

    public ProductDTO update(Long id, ProductRequest request) {
        ProductResponse productDTO = client.getProductById(id);
        if (Objects.isNull(productDTO)) {
            throw new IllegalArgumentException("Product not found");
        }
        return mapper.toDTO(client.updateProduct(id, request));
    }

    public void delete(Long id) {
        ProductDTO productDTO = mapper.toDTO(client.getProductById(id));
        if (Objects.isNull(productDTO)) {
            throw new IllegalArgumentException("Product not found");
        }
        client.deleteProduct(id);
    }
}
