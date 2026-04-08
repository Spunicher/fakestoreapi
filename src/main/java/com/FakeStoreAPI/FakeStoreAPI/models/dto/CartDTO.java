package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CartDTO implements Serializable {
    private Long id;
    private Long userId;
    private String date;
    private List<ProductCartDTO> products;
}
