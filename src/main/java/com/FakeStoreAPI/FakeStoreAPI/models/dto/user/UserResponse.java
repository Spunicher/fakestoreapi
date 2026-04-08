package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserResponse implements Serializable{
    private Long id;
    private String email;
    private String username;
    private String password;
    private NameUserResponse name;
    private String phone;
    private AddressUserResponse address;
}