package com.FakeStoreAPI.FakeStoreAPI.models.dto.carts;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class CartRequest implements Serializable {
    private Long userId;
    private String date;
    private List<ProductCartRequest> products;
}
