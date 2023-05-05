package com.solvd.deliveryservice.order;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.parcel.Parcel;
import com.solvd.deliveryservice.person.Customer;
import com.solvd.deliveryservice.person.Id;
import com.solvd.deliveryservice.person.Recipient;
import com.solvd.deliveryservice.store.Store;

import java.util.Random;

public class Order implements Id {
    private Customer customer;
    private Recipient recipient;
    private Address address;
    private Parcel parcel;
    private Store store;
    private String id;
    private boolean express;
    private boolean delivered;

    public Customer getCustomer() {
        return customer;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Address getAddress() {
        return address;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public Store getStore() {
        return store;
    }


    public boolean isExpress() {
        return express;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public String getId() {
        return id;
    }


    public void setExpress(boolean express) {
        this.express = express;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return Long.toString(currentTime+ randomInt);
    }

        public Order(Customer customer, Recipient recipient, Address address) {
            this.customer = customer;
            this.recipient = recipient;
            this.address = address;
            this.delivered = false;
    }
}



