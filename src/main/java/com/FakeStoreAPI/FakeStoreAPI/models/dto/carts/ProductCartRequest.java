package com.FakeStoreAPI.FakeStoreAPI.models.dto.carts;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductCartRequest implements Serializable {
    private Long productId;
    private Integer quantity;
}
