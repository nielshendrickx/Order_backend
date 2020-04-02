package com.switchfully.order.service.validation;

import com.switchfully.order.domain.exceptions.EmailNotValidException;
import com.switchfully.order.domain.exceptions.NameNotValidException;
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

    @Test
    void nameValidShouldContinue() throws IOException {
        Validation.isValidName("Niels");
    }

    @Test
    void nameNotValidShouldThrowNameNotValidException() {
        assertThrows(NameNotValidException.class, () -> Validation.isValidName("N1els"));
    }

    @Test
    void nameNotValidShould_alphaNumeric_ThrowNameNotValidException() {
        assertThrows(NameNotValidException.class, () -> Validation.isValidName("N-els"));
    }
}