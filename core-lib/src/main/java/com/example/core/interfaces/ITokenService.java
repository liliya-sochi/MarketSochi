package com.example.core.interfaces;

import com.example.core.models.UserInfo;

public interface ITokenService {
    String generateToken(UserInfo user);
    UserInfo parseToken(String token);
}