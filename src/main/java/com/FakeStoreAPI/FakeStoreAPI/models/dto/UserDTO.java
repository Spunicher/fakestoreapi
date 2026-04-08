package com.FakeStoreAPI.FakeStoreAPI.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
    private Long id;
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private String city;
}
