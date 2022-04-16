package com.example.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example")
@SpringBootApplication(scanBasePackages = "com.example")
public class MsOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrdersApplication.class, args);
    }
}