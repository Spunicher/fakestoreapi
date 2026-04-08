package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.FakeStoreAPI.FakeStoreAPI.models.enums.OrderStatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;
    private Long customerId;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private BigDecimal total;
    private List<OrderDetailDTO> details;
}
