package com.example.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class MsProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductsApplication.class, args);
    }
}