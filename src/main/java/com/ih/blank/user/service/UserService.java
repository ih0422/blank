package com.ih.blank.user.service;

import com.ih.blank.user.controller.dto.request.SignupRequest;
import com.ih.blank.user.model.User;
import com.ih.blank.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public void signup(SignupRequest signupRequest) {
        User savedOne = userRepository.findUserByEmail(signupRequest.getEmail());

        if (Objects.nonNull(savedOne)) {
            throw new DuplicateKeyException("사용할 수 없는 이메일입니다.");
        }

        String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
        User user = userMapper.toEntity(signupRequest, hashedPassword);
        userRepository.save(user);
    }

}
