package com.FakeStoreAPI.FakeStoreAPI.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.carts.CartRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.carts.CartResponse;

@FeignClient(name = "fakeStoreCartClient", url = "${fakestore.api.url}")
public interface FakeStoreCartClient {

    @GetMapping("/carts")
    List<CartResponse> getAllCarts();

    @GetMapping("/carts/{id}")
    CartResponse getCartById(@PathVariable("id") Long id);

    @PostMapping("/carts")
    CartResponse createCart(@RequestBody CartRequest request);

    @PutMapping("/carts/{id}")
    CartResponse updateCart(
            @PathVariable("id") Long id,
            @RequestBody CartRequest request);

    @DeleteMapping("/carts/{id}")
    Void deleteCart(@PathVariable("id") Long id);
}
