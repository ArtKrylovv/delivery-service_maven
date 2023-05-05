package com.solvd.deliveryservice.store;

public abstract class Store implements WorkingHours{
    public abstract boolean dayOfTheWeekChecker(String day);
}

