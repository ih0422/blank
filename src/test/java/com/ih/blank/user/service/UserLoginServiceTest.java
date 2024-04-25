package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLoginServiceTest {

    @Autowired
    UserLoginService userLoginService;

    @Test
    void save() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("아무개");
        userRequest.setEmail("amugae@naver.com");
        userRequest.setPassword("amugae12");
        userLoginService.save(userRequest);
    }
}