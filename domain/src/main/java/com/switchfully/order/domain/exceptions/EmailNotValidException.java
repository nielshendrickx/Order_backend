package com.switchfully.order.domain.exceptions;

public class EmailNotValidException extends RuntimeException {
    public EmailNotValidException(String email) {
        super("The provided email: " + email +  " is not valid");
    }
}
