package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO implements Serializable {
    private Long id;
    private Long productId;
    private String productTitle;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal subtotal;
    private String productCategory;
    private String productImage;
}
