package com.solvd.deliveryservice.exceptions;

public class InvalidDiscountException extends RuntimeException{
    public InvalidDiscountException(String message) {
        super(message);
    }
}

