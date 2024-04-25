package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.JoinRequest;
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
    public void join(JoinRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        User savedOne = userRepository.findUserByEmail(user.getEmail());

        if (Objects.nonNull(savedOne)) {
            throw new RuntimeException("사용할 수 없는 이메일입니다.");
        }

        userRepository.save(user);
    }

}
