package com.solvd.deliveryservice.store;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.exceptions.InvalidDayOfTheWeekException;
import com.solvd.deliveryservice.exceptions.InvalidDiscountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PhysicalStore extends Store{
    private Address address;
    private final static Logger LOGGER = LogManager.getLogger(PhysicalStore.class);

    public PhysicalStore(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String workingTodayChecker(String currentDayOfTheWeek) {
        if(!dayOfTheWeekChecker(currentDayOfTheWeek)){
            LOGGER.error("Day of the week must be a string, abbreviations are not allowed");
            throw new InvalidDayOfTheWeekException("Day of the week must be a string, abbreviations are not allowed");
        }

        if(currentDayOfTheWeek.equals("Sunday")) {
            return "Sorry, we are closed till 8 am tomorrow!";
        } else {
            return "We are open today!";
        }
    }

    @Override
    public boolean dayOfTheWeekChecker(String day) {
        String[] arrWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return (Arrays.asList(arrWeek).contains(day));
    }
}



