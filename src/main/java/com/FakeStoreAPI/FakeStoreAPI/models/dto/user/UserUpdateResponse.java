package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import lombok.Data;

@Data
public class UserUpdateResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
}
