package com.solvd.deliveryservice.payment;

@FunctionalInterface
public interface iCardCheck {
    boolean validateCard(long cardNumber);
}
