package com.solvd.deliveryservice.address;

import com.solvd.deliveryservice.utilities.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class HouseAddress extends Address{

    public HouseAddress(String street, int house,String city, String state) {
        super(street, state, house, city);
    }

    @Override
    public String[] getFullAddress() {
        String[] fullAddress = new String[4];
        fullAddress[0]=Integer.toString(getHouseNumber());
        fullAddress[1]=getStreet();
        fullAddress[2]=getCity();
        fullAddress[3]=getState();
        return fullAddress;
    }
}
