package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
}
