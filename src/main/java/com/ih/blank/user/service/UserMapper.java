package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.UserRequest;
import com.ih.blank.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail().strip());
        user.setPassword(request.getPassword());
        user.setUserName(request.getUserName().strip());
        user.setSocial(request.getSocialType());
        return user;
    }
}
