package com.switchfully.order.service.validation;

import com.switchfully.order.domain.exceptions.EmailNotValidException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    void emailValidShouldContinue() throws IOException {
        String email = "avalid@email.com";
        Validation.isValidEmailAddress(email);
    }

    @Test
    void emailValidShouldThrowEmailNotValidException() throws IOException {
        String email = "avalidemail.com";
        assertThrows(EmailNotValidException.class, () -> Validation.isValidEmailAddress(email));
    }
}