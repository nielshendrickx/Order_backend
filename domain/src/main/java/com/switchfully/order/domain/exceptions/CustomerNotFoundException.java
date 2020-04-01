package com.switchfully.order.domain.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Could not find the customer.");
    }
}
