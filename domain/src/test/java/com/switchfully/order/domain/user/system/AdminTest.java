package com.switchfully.order.domain.user.system;

import com.switchfully.order.domain.user.system.security.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void createAdmin_shouldReturnCorrectValues() {
        Admin admin = new Admin("John", "Doe", "john@doe.com", "aPassword");
        assertNotNull(admin.getId());
        assertEquals("John", admin.getFirstName());
        assertEquals("Doe", admin.getLastName());
        assertEquals("john@doe.com", admin.getEmail());
    }

    @Test
    void createAdmin_getRole_shouldReturnAdmin()
    {
        Admin admin = new Admin("John", "Doe", "john@doe.com", "aPassword");
        assertEquals(Role.ADMIN, admin.getRole());
    }
}