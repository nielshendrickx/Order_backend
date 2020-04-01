package com.switchfully.order.domain.user.system.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTest {

    @Test
    void createHash_VerifyHash_shouldReturnTrue() {
        String hash = Hash.hash("hashmeiamapassword");
        assertTrue(Hash.verifyHash("hashmeiamapassword", hash));
    }

    @Test
    void createHash_givenFaultyPassword_ShouldReturnFalse() {
        String hash = Hash.hash("hashmeiamapassword");
        assertFalse(Hash.verifyHash("hashme", hash));
    }

}