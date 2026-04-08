package com.FakeStoreAPI.FakeStoreAPI.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.FakeStoreAPI.FakeStoreAPI.models.dto.products.ProductRequest;
import com.FakeStoreAPI.FakeStoreAPI.models.dto.products.ProductResponse;

@FeignClient(name = "fakeStoreProductClient", url = "${fakestore.api.url}")
public interface FakeStoreProductClient {

    @GetMapping("/products")
    List<ProductResponse> getAllProducts();

    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);

    @PostMapping("/products")
    ProductResponse createProduct(@RequestBody ProductRequest request);

    @PutMapping("/products/{id}")
    ProductResponse updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductRequest request);

    @DeleteMapping("/products/{id}")
    Void deleteProduct(@PathVariable("id") Long id);
}
