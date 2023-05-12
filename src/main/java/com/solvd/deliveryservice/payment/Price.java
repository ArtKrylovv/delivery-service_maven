package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.order.Order;

public class Price implements Document{
    final public static int LOCAL_PRICE_LB = 5;
    final public static int NATIONAL_PRICE_LB = 10;
    final public static float EXPRESS_MARKUP = 0.1F;
    private float totalPrice;
    private Currency currency;

    public Price(float totalDiscount, Order order, Currency currency) {
        this.totalPrice = calculateTotalPrice(totalDiscount, order);
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    // this method calculates and returns price based on weight, address, and customer discount
    private float calculateTotalPrice(float totalDiscount, Order order) {
        int weight = order.getParcel().getWeight();
        if (order.getAddress().checkIfLocalAddress(order.getAddress().getState())) {
            return weight * LOCAL_PRICE_LB * (1 - totalDiscount*(1+calculateExpressMarkup(order)));
        } else {
            return weight * NATIONAL_PRICE_LB * (1 - totalDiscount*(1+calculateExpressMarkup(order)));
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





