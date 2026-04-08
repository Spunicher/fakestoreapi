package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import lombok.Data;

@Data
public class UserCreateResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
}
