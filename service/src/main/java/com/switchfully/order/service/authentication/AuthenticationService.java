package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String email, String password) { //TODO change this to userDTO
        return userRepository.authenticate(email, password);
    }
}
