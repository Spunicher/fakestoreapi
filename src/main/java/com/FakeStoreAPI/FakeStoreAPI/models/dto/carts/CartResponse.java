package com.FakeStoreAPI.FakeStoreAPI.models.dto.carts;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CartResponse implements Serializable{
    private Long id;
    private Long userId;
    private String date;
    private List<ProductCartResponse> products;
}
