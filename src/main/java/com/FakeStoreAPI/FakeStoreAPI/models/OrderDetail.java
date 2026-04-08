package com.FakeStoreAPI.FakeStoreAPI.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long productId;
    private String productTitle;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal subtotal;
    private String productCategory;
    private String productImage;
}
