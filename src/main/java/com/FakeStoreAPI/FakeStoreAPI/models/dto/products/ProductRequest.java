package com.FakeStoreAPI.FakeStoreAPI.models.dto.products;

import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;
}