package com.ih.blank.user.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class LoginResponse {
    private String email;
    private String token;
}
