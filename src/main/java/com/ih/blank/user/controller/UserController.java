package com.ih.blank.user.controller;

import com.ih.blank.user.controller.dto.request.UserRequest;
import com.ih.blank.user.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("users")
@RequiredArgsConstructor
public class UserController {
    private final UserLoginService userLoginService;

    @PostMapping("/join")
    public void save(UserRequest userRequest) {
        userLoginService.save(userRequest);
    }

}
