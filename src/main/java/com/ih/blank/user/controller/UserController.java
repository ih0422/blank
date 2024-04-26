package com.ih.blank.user.controller;

import com.ih.blank.user.controller.dto.request.JoinRequest;
import com.ih.blank.user.controller.dto.request.LoginRequest;
import com.ih.blank.user.controller.dto.response.UserResponse;
import com.ih.blank.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public void join(JoinRequest joinRequest) {
        userService.join(joinRequest);
    }

    @PostMapping("")
    public UserResponse login(LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
