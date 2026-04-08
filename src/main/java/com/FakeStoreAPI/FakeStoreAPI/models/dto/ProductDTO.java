package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDTO implements Serializable {
    private Long id;
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;
}
