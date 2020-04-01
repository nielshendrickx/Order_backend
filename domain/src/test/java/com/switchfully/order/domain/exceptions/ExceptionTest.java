package com.switchfully.order.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    @Test
    void emailException_returnsCorrectMessage() {
        assertEquals("The provided email: test is not valid", new EmailNotValidException("test").getMessage());
    }

    @Test
    void customerNotFoundException_returnsCorrectMessage() {
        assertEquals("Could not find the customer.", new CustomerNotFoundException().getMessage());
    }

    @Test
    void authenticationFailedException_returnsCorrectMessage() {
        assertEquals("Your password or email isn't correct.", new AuthenticationFailedException().getMessage());
    }

    @Test
    void emailAlreadyRegistered_returnCorrectMessage() {
        assertEquals("The provided email: test@test.com is already used", new EmailAlreadyRegisteredException("test@test.com").getMessage());
    }

    @Test
    void itemOutOfStockException_returnsCorrectMessage() {
        assertEquals("The requested item is out of stock!", new ItemOutOfStockException().getMessage());
    }
}