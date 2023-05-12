package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.exceptions.InvalidDiscountException;
import com.solvd.deliveryservice.person.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Discount implements Accounting {
    final public static float VETERAN_DISCOUNT = 0.15F;
    public float manualDiscount;
    private final static Logger LOGGER = LogManager.getLogger(Discount.class);
    private Customer customer;

    public Discount(float manualDiscount, Customer customer) {
        this.manualDiscount = manualDiscount;
        this.customer = customer;
    }

    public float getManualDiscount() {
        return manualDiscount;
    }

    public void setManualDiscount(float manualDiscount) {
        this.manualDiscount = manualDiscount;
    }

    public float calculateTotalDiscount(iDiscountGen discountGen) {
        return discountGen.generate(customer);
    }

    // implements Accounting interface method
    public boolean discountChecker(float discount){
        return discount >= 0 && discount < 1;
    }

}


