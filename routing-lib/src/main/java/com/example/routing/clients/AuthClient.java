package com.example.routing.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.routing.dtos.AuthRequestDto;
import com.example.routing.dtos.AuthResponseDto;
import com.example.routing.dtos.SignUpRequestDto;

@FeignClient("ms-auth")
public interface AuthClient {

    @PostMapping("/signup")
    String signUp(@RequestBody SignUpRequestDto signUpRequest);

    @PostMapping("/login")
    AuthResponseDto login(@RequestBody AuthRequestDto request);
}