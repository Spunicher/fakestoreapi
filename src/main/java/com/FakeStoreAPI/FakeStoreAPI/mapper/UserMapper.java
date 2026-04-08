package com.FakeStoreAPI.FakeStoreAPI.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.UserDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name.firstname", target = "firstname")
    @Mapping(source = "name.lastname", target = "lastname")
    @Mapping(source = "address.city", target = "city")
    UserDTO toUser(UserResponse response);
}
