package com.ih.blank.user.controller.dto.request;


import com.ih.blank.user.model.enums.SocialType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String email;
    private String password;
    private String userName;
    private SocialType socialType;
}
