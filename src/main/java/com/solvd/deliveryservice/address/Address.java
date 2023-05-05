package com.solvd.deliveryservice.address;

import com.solvd.deliveryservice.Main;
import com.solvd.deliveryservice.exceptions.StateNameException;
import com.solvd.deliveryservice.utilities.MyLinkedList;
import com.solvd.deliveryservice.utilities.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class Address {
    final public static String LOCAL_STATE = "CA";
    private String street;
    private String state;
    private int houseNumber;
    private String city;
    // creates logger
    private final static Logger LOGGER = LogManager.getLogger(Address.class);

    public Address(String street, String state, int houseNumber, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        // using Utilities final class with static methods
        if (Utilities.stateChecker(state)) {
            this.state = state;
        } else {
            LOGGER.error("State name must be a string of 2 characters length");
            throw new StateNameException("State name must be a string of 2 characters length");
        }
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        if (Utilities.stateChecker(state)) {
            this.state = state;
        } else {
            LOGGER.error("State name must be a string of 2 characters length");
            throw new StateNameException("State name must be a string of 2 characters length");
        }
    }
    // final class
    public final boolean checkIfLocalAddress(String state){
        if (!Utilities.stateChecker(state)){
            LOGGER.error("State name must be a string of 2 characters length");
            throw new StateNameException("State name must be a string of 2 characters length");
        }
        return state.equals(LOCAL_STATE);
    }
    // abstract
    public abstract String[] getFullAddress();
}

