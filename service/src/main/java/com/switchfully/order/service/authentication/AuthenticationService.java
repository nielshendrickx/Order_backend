package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private AuthMapper authMapper;

    @Autowired
    public AuthenticationService(UserRepository userRepository, AuthMapper authMapper) {
        this.userRepository = userRepository;
        this.authMapper = authMapper;
    }

    public AuthDto authenticate(String email, String password) {
        return authMapper.toDto(userRepository.authenticate(email, password));
    }
}
