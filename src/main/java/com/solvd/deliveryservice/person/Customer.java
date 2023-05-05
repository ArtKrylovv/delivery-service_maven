package com.solvd.deliveryservice.person;

import java.util.HashMap;
import java.util.Random;

public class Customer extends Person {
    private String id;
    private boolean veteranStatus;

    // reduce arguments to 3 max
    public Customer(String firstName, String lastName, long phone) {
        super(firstName, lastName, phone);
        this.id = generateId();
    }

    public String getId() {
        return id;
    }

    public boolean isVeteranStatus() {
        return veteranStatus;
    }

    public void setVeteranStatus(boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }

    public void setId(String id) {
        this.id =id;
    }

    @Override
    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return "C" + currentTime + randomInt;
    }

    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> info = new HashMap<>();
        info.put("fist name", getFirstName());
        info.put("last name", getLastName());
        info.put("phone", Long.toString(getPhone()));
        info.put("id", getId());
        info.put("veteran status", Boolean.toString(isVeteranStatus()));
        return info;
    }
}
