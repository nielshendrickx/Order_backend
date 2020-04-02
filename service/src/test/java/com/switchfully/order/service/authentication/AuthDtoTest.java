package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.user.system.security.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthDtoTest {

    @Test
    void authDto_returnsCorrectValues() {
        AuthDto authDto = new AuthDto("email@email.com", "password", Role.CUSTOMER);
        assertEquals("email@email.com", authDto.getEmail());
        assertEquals("password", authDto.getPassword());
        assertEquals(Role.CUSTOMER, authDto.getRole());
    }

}