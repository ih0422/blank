package com.ih.blank.user.controller;

import com.ih.blank.user.controller.dto.request.SignupRequest;
import com.ih.blank.user.controller.dto.request.LoginRequest;
import com.ih.blank.user.controller.dto.response.LoginResponse;
import com.ih.blank.user.model.JwtHelper;
import com.ih.blank.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/signup/test")
    public String test() {
        return " hello ";
    }

    @PostMapping("/signup")
    public boolean signup(@Valid @RequestBody SignupRequest signupRequest) {
        userService.signup(signupRequest);
        return true;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String token = JwtHelper.generateToken(request.getEmail());
        return new LoginResponse(request.getEmail(), token);
    }
}
