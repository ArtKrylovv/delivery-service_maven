package com.solvd.deliveryservice.address;

import com.solvd.deliveryservice.utilities.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApartmentAddress extends Address {
    private int aptNumber;


    public ApartmentAddress(String street, int house, String city, String state) {
        // reduce arguments to 3 max
        super(street, state, house, city);
    }

    public int getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(int aptNumber) {
        this.aptNumber = aptNumber;
    }

    @Override
    public String [] getFullAddress(){
        String[] fullAddress = new String[5];
        fullAddress[0]=Integer.toString(getHouseNumber());
        fullAddress[1]=getStreet();
        fullAddress[2]=Integer.toString(getAptNumber());
        fullAddress[3]=getCity();
        fullAddress[4]=getState();
        return fullAddress;
    }
}

