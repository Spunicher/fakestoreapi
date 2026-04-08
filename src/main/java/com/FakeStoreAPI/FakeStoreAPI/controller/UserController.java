package com.FakeStoreAPI.FakeStoreAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.UserDTO;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserCreateResponse;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.user.UserUpdateResponse;
import com.FakeStoreAPI.FakeStoreAPI.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable Long id,
            @RequestBody UserRequest request) {
        return ResponseEntity.ok(service.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
