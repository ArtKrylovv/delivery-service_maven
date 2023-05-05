package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.order.Order;

public class Price implements Document{
    final public static int LOCAL_PRICE_LB = 5;
    final public static int NATIONAL_PRICE_LB = 10;
    final public static float EXPRESS_MARKUP = 0.1F;
    private float totalPrice;

    public Price(Discount discount, Order order) {
        this.totalPrice = calculateTotalPrice(discount, order);
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    // this method calculates and returns price based on weight, address, and customer discount
    private float calculateTotalPrice(Discount discount, Order order) {
        int weight = order.getParcel().getWeight();
        if (order.getAddress().checkIfLocalAddress(order.getAddress().getState())) {
            return weight * LOCAL_PRICE_LB * (1 - discount.getTotalDiscount())*(1+calculateExpressMarkup(order));
        } else {
            return weight * NATIONAL_PRICE_LB * (1 - discount.getTotalDiscount())*(1+calculateExpressMarkup(order));
        }
    }

    private float calculateExpressMarkup(Order order) {
        float expressMarkup = 0F;
        if (order.isExpress()) {
            expressMarkup+=EXPRESS_MARKUP;
        }
        return expressMarkup;
    }

    @Override
    public String convertNumericToText(float numeric) {
        return "Will be implemented later";
    }
}





