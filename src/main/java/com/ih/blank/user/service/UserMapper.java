package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.JoinRequest;
import com.ih.blank.user.controller.dto.request.LoginRequest;
import com.ih.blank.user.controller.dto.response.UserResponse;
import com.ih.blank.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(JoinRequest request) {
        User user = new User();
        user.setEmail(request.getEmail().strip());
        user.setPassword(request.getPassword());
        user.setUserName(request.getUserName().strip());
        user.setSocial(request.getSocialType());
        return user;
    }

    public User toEntity(LoginRequest request) {
        User user = new User();
        user.setEmail(request.getEmail().strip());
        user.setPassword(request.getPassword());
        return user;
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getEmail(),
                user.getUserName(),
                user.getSocial(),
                user.getRole()
        );
    }
}
