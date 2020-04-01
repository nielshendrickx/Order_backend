package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.DummyData;
import com.switchfully.order.domain.exceptions.AuthenticationFailedException;
import com.switchfully.order.domain.user.UserRepository;
import com.switchfully.order.domain.user.system.Admin;
import com.switchfully.order.domain.user.system.security.Hash;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    DummyData dummyData = new DummyData();
    UserRepository userRepository = new UserRepository(dummyData);
    AuthenticationService authenticationService = new AuthenticationService(userRepository);

    @Test
    void authenticate_succes_shouldReturnUser() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com", Hash.hash("password"));
        userRepository.addUser(admin);
        assertEquals(admin, authenticationService.authenticate("test@test.com", "password"));
    }

    @Test
    void authenticate_failed_ShouldThrowAuthException() {
        Admin admin = new Admin("FirstName", "LastName", "test@test.com", Hash.hash("password"));
        userRepository.addUser(admin);
        assertThrows(AuthenticationFailedException.class, () -> authenticationService.authenticate("test@test.com", "awrongpassword"));
    }
}