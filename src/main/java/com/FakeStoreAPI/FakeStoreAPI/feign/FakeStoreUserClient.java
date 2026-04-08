package com.FakeStoreAPI.FakeStoreAPI.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserCreateResponse;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserResponse;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserUpdateResponse;

@FeignClient(name = "fakeStoreUserClient", url = "${fakestore.api.url}")
public interface FakeStoreUserClient {
    @GetMapping("/users")
    List<UserResponse> getAllUsers();

    @GetMapping("/users/{id}")
    UserResponse getUserById(@PathVariable("id") Long id);

    @PostMapping("/users")
    UserCreateResponse createUser(@RequestBody UserRequest request);

    @PutMapping("/users/{id}")
    UserUpdateResponse updateUser(
            @PathVariable("id") Long id,
            @RequestBody UserRequest request);

    @DeleteMapping("/users/{id}")
    Void deleteUser(@PathVariable("id") Long id);
}
