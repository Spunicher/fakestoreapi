package com.FakeStoreAPI.FakeStoreAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FakeStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeStoreApiApplication.class, args);
	}

}
