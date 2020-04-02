package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public AuthDto toDto(User user) {
        return new AuthDto(user.getEmail(), user.getPassword(), user.getRole());
    }
}
