package com.switchfully.order.domain.exceptions;

public class NameNotValidException extends RuntimeException {
    public NameNotValidException() {
        super("The provide first or last name is not valid! Please only use letters.");
    }
}
