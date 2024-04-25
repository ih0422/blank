package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.JoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void save() {
        JoinRequest userRequest = new JoinRequest();
        userRequest.setUserName("아무개");
        userRequest.setEmail("amugae@naver.com");
        userRequest.setPassword("amugae12");
        userService.join(userRequest);
    }
}