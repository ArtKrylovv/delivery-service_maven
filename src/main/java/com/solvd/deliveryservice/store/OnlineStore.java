package com.solvd.deliveryservice.store;

import com.solvd.deliveryservice.exceptions.InvalidDayOfTheWeekException;
import com.solvd.deliveryservice.exceptions.InvalidDiscountException;
import com.solvd.deliveryservice.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class OnlineStore extends Store{
    private String url;
    private final static Logger LOGGER = LogManager.getLogger(OnlineStore.class);


    public OnlineStore(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String workingTodayChecker(String currentDayOfTheWeek) {
        if (dayOfTheWeekChecker(currentDayOfTheWeek)) {
            return "We are serving our customers 24/7!";
        } else {
            LOGGER.error("Day of the week must be a string, abbreviations are not allowed");
            throw new InvalidDayOfTheWeekException("Day of the week must be a string, abbreviations are not allowed");
        }
    }

    @Override
    public boolean dayOfTheWeekChecker(String day) {
        String[] arrWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return (Arrays.asList(arrWeek).contains(day));

    }
}
