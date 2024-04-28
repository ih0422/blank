package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.SignupRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void save() {
        SignupRequest userRequest = new SignupRequest();
        userRequest.setUserName("아무개");
        userRequest.setEmail("amugae1@naver.com");
        userRequest.setPassword("amugae12");
        userService.signup(userRequest);
    }
}