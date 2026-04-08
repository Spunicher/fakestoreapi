package com.FakeStoreAPI.FakeStoreAPI.models.dto.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class NameUserResponse implements Serializable{
    private String firstname;
    private String lastname;
}
