package com.ih.blank.user.controller.dto.request;


import com.ih.blank.user.model.enums.SocialType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String userName;

    private SocialType socialType;
}
