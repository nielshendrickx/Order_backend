package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.DummyData;
import com.switchfully.order.domain.exceptions.AuthenticationFailedException;
import com.switchfully.order.domain.user.UserRepository;
import com.switchfully.order.domain.user.system.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthenticationServiceTest {
    DummyData dummyData = new DummyData();
    AuthMapper authMapper = new AuthMapper();
    UserRepository userRepository = new UserRepository(dummyData);
    AuthenticationService authenticationService = new AuthenticationService(userRepository, authMapper);

    @Test
    void authenticate_succes_shouldReturnAuthDto() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com", "password");
        userRepository.registerAdmin(admin);
        AuthDto authDto = authMapper.toDto(admin);
        assertEquals(authDto, authenticationService.authenticate(admin.getEmail(), "password"));
    }

    @Test
    void authenticate_failed_ShouldThrowAuthException() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com","password");
        userRepository.registerAdmin(admin);
        assertThrows(AuthenticationFailedException.class, () -> authenticationService.authenticate(admin.getEmail(), "awrongpassword"));
    }
}