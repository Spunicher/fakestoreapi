package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressUserResponse implements Serializable {
    private GeolocationUserResponsse geolocation;
    private String city;
    private String street;
    private Long number;
    private String zipcode;
}
