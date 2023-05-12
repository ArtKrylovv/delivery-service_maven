package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.order.Order;

import java.util.HashMap;

@FunctionalInterface
public interface iInvoiceGen {
    HashMap<String, String> generate(Order order);
}
