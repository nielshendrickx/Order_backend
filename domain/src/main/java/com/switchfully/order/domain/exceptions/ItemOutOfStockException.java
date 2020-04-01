package com.switchfully.order.domain.exceptions;

public class ItemOutOfStockException extends RuntimeException {
    public ItemOutOfStockException() {
        super("The requested item is out of stock!");
    }
}
