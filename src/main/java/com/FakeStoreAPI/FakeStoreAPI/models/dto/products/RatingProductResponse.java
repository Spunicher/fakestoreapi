package com.FakeStoreAPI.FakeStoreAPI.models.dto.products;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingProductResponse implements Serializable {
    private Double rate;
    private Integer count;
}
