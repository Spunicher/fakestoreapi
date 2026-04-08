
package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductCartDTO implements Serializable {
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Integer quantity;
}
