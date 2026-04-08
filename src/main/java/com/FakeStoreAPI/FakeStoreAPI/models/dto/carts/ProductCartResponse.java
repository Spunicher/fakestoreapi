package com.FakeStoreAPI.FakeStoreAPI.models.dto.carts;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductCartResponse implements Serializable {
    private Long productId;
    private Integer quantity;
}
