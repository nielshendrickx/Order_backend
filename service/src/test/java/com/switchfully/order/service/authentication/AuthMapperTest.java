package com.switchfully.order.service.authentication;

import com.switchfully.order.domain.user.system.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthMapperTest {
    AuthMapper authMapper = new AuthMapper();

    @Test
    void mapToDto_shouldContainCorrectValues() {
        Admin admin = new Admin("John", "Doe", "john@doe.com", "aPassword");
        AuthDto authDto = authMapper.toDto(admin);
        assertEquals(admin.getEmail(), authDto.getEmail());
        assertEquals(admin.getPassword(), authDto.getPassword());
        assertEquals(admin.getRole(),admin.getRole());
    }
}