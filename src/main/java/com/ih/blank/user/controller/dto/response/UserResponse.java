package com.ih.blank.user.controller.dto.response;

import com.ih.blank.user.model.enums.SocialType;
import com.ih.blank.user.model.enums.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private String email;
    private String userName;
    private SocialType socialType;
    private UserRoleType roleType;
}
