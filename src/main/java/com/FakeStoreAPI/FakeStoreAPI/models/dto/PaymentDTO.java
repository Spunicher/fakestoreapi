package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.FakeStoreAPI.FakeStoreAPI.models.enums.PaymentStatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {

    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private PaymentStatus status;
    private String transactionReference;
}
