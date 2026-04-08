package com.FakeStoreAPI.FakeStoreAPI.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.FakeStoreAPI.FakeStoreAPI.feign.FakeStoreCartClient;
import com.FakeStoreAPI.FakeStoreAPI.feign.FakeStoreProductClient;
import com.FakeStoreAPI.FakeStoreAPI.mapper.CartMapper;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.CartDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.ProductCartDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.carts.CartRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.carts.CartResponse;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.products.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

    private final FakeStoreCartClient cartClient;
    private final FakeStoreProductClient productClient;
    private final CartMapper mapper;

    private CartDTO mapCartWithProducts(CartResponse response) {
        CartDTO dto = mapper.toDTO(response);
        List<ProductCartDTO> products = response.getProducts()
                .stream()
                .map(p -> {
                    ProductResponse product = productClient.getProductById(p.getProductId());
                    if (product == null) {
                        throw new IllegalArgumentException("Product not found");
                    }
                    ProductCartDTO productDTO = new ProductCartDTO();
                    productDTO.setId(product.getId());
                    productDTO.setTitle(product.getTitle());
                    productDTO.setPrice(product.getPrice());
                    productDTO.setDescription(product.getDescription());
                    productDTO.setCategory(product.getCategory());
                    productDTO.setImage(product.getImage());
                    productDTO.setQuantity(p.getQuantity());
                    return productDTO;
                }).toList();
        dto.setProducts(products);
        return dto;
    }

    public List<CartDTO> getAllCarts() {
        return cartClient.getAllCarts()
                .stream()
                .map(this::mapCartWithProducts)
                .toList();
    }

    public CartDTO getById(Long id) {
        CartResponse cartResponse = cartClient.getCartById(id);
        if (Objects.isNull(cartResponse)) {
            throw new IllegalArgumentException("Cart not found");
        }
        return this.mapCartWithProducts(cartResponse);
    }

    public CartDTO create(CartRequest request) {
        return this.mapCartWithProducts(cartClient.createCart(request));
    }

    public CartDTO update(Long id, CartRequest request) {
        CartResponse cartResponse = cartClient.getCartById(id);
        if (Objects.isNull(cartResponse)) {
            throw new IllegalArgumentException("Cart not found");
        }
        return this.mapCartWithProducts(cartClient.updateCart(id, request));
    }

    public void delete(Long id) {
        CartResponse cartResponse = cartClient.getCartById(id);
        if (Objects.isNull(cartResponse)) {
            throw new IllegalArgumentException("Cart not found");
        }
        cartClient.deleteCart(id);
    }
}