package com.ih.blank.user.service;

import com.ih.blank.user.model.PrincipalDetails;
import com.ih.blank.user.model.User;
import com.ih.blank.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User savedUser = userRepository.findUserByEmail(email);
        if (Objects.isNull(savedUser)) {
            throw new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
        }
        return new PrincipalDetails(savedUser);
    }
}
