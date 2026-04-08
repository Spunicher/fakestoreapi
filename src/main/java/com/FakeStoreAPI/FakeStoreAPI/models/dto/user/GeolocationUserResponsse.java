package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class GeolocationUserResponsse implements Serializable {
    private String lat;
    private BigDecimal longitude;
}
