package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.person.Customer;

@FunctionalInterface
public interface iDiscountGen {
    float generate(Customer customer);
}


