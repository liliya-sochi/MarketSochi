package com.example.routing.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ms-payments")
public interface PaymentsClient {
}