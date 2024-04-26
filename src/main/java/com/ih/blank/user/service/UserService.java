package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.JoinRequest;
import com.ih.blank.user.controller.dto.request.LoginRequest;
import com.ih.blank.user.controller.dto.response.UserResponse;
import com.ih.blank.user.model.User;
import com.ih.blank.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(rollbackOn = Exception.class)
    public void join(JoinRequest joinRequest) {
        User user = userMapper.toEntity(joinRequest);
        User savedOne = userRepository.findUserByEmail(user.getEmail());

        if (Objects.nonNull(savedOne)) {
            throw new RuntimeException("사용할 수 없는 이메일입니다.");
        }

        userRepository.save(user);
    }

    public UserResponse login(LoginRequest loginRequest) {
        User user = userMapper.toEntity(loginRequest);
        User savedOne = userRepository.findUserByEmail(user.getEmail());

        if (Objects.isNull(savedOne)) {
            throw new RuntimeException("없는 아이디입니다.");
        }

        if (!user.isSamePassword(loginRequest.getPassword())) {
            throw new RuntimeException("아이디나 비밀번호를 다시 확인해주세요.");
        }

        return userMapper.toResponse(user);
    }

}
