package com.solvd.deliveryservice.person;

import java.util.HashMap;
import java.util.Random;

public class Employee extends Person {
    private String id;

    public Employee(String firstName, String lastName, long phone) {
        super(firstName, lastName, phone);
        this.id = generateId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id =id;
    }

    @Override
    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return "E" + currentTime + randomInt;
    }

    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> info = new HashMap<>();
        info.put("fist name", getFirstName());
        info.put("last name", getLastName());
        info.put("phone", Long.toString(getPhone()));
        info.put("id", getId());
        return info;
    }
}

