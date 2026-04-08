package com.FakeStoreAPI.FakeStoreAPI.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.FakeStoreAPI.FakeStoreAPI.feign.FakeStoreUserClient;
import com.FakeStoreAPI.FakeStoreAPI.mapper.UserMapper;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.UserDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserCreateResponse;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserResponse;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserUpdateResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final FakeStoreUserClient client;
    private final UserMapper mapper;

    public List<UserDTO> getAllUsers() {
        return client.getAllUsers()
                .stream()
                .map(mapper::toUser)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        UserResponse userDTO = client.getUserById(id);
        if (Objects.isNull(userDTO)) {
            throw new IllegalArgumentException("User not found");
        }
        return mapper.toUser(userDTO);
    }

    public UserCreateResponse createUser(UserRequest request) {
        UserCreateResponse response = client.createUser(request);
        if (Objects.isNull(response.getEmail())) {
            response.setEmail(request.getEmail());
        }
        if (Objects.isNull(response.getUsername())) {
            response.setUsername(request.getUsername());
        }
        if (Objects.isNull(response.getPassword())) {
            response.setPassword(request.getPassword());
        }
        return response;
    }

    public UserUpdateResponse updateUser(Long id, UserRequest request) {
        UserResponse userDTO = client.getUserById(id);
        if (Objects.isNull(userDTO)) {
            throw new IllegalArgumentException("User not found");
        }
        UserUpdateResponse response = client.updateUser(id, request);
        if (Objects.isNull(response.getId())) {
            response.setId(id);
        }
        if (Objects.isNull(response.getEmail())) {
            response.setEmail(request.getEmail());
        }
        if (Objects.isNull(response.getUsername())) {
            response.setUsername(request.getUsername());
        }
        if (Objects.isNull(response.getPassword())) {
            response.setPassword(request.getPassword());
        }
        return response;
    }

    public void deleteUser(Long id) {
        UserResponse userDTO = client.getUserById(id);
        if (Objects.isNull(userDTO)) {
            throw new IllegalArgumentException("User not found");
        }
        client.deleteUser(id);
    }
}
