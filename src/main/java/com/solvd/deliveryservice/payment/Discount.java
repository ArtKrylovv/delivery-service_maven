package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.exceptions.InvalidDiscountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Discount implements Accounting {
    final public static float VETERAN_DISCOUNT = 0.15F;
    private float manualDiscount;
    private float totalDiscount;
    private final static Logger LOGGER = LogManager.getLogger(Discount.class);

    public Discount(float manualDiscount, boolean veteranStatus) {
        if (discountChecker(manualDiscount)){
            this.manualDiscount = manualDiscount;
        } else {
            LOGGER.error("Discount must be a float greater than 0 and less than 1");
            throw new InvalidDiscountException("Discount must be a float greater than 0 and less than 1");
        }
        this.totalDiscount = calculateTotalDiscount(veteranStatus);
    }

    public Discount(boolean veteranStatus) {
        this.totalDiscount = calculateTotalDiscount(veteranStatus);
    }

    public float getManualDiscount() {
        return manualDiscount;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void setManualDiscount(float manualDiscount) {
        if (discountChecker(manualDiscount)){
            this.manualDiscount = manualDiscount;
        } else {
            LOGGER.error("Discount must be a float greater or equal to 0 and less than 1");
            throw new InvalidDiscountException("Discount must be a float greater or equal to 0 and less than 1");
        }
    }

    private float calculateTotalDiscount(boolean veteranStatus) {
        if(veteranStatus) {
            return manualDiscount + VETERAN_DISCOUNT;
        } else{
            return manualDiscount;
            }
        }
    // implements Accounting interface method
    public boolean discountChecker(float discount){
        return discount >= 0 && discount < 1;
    }

}


