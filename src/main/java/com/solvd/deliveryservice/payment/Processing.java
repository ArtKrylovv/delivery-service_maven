package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.Main;
import com.solvd.deliveryservice.exceptions.CardException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Processing {
    private final static Logger LOGGER = LogManager.getLogger(Processing.class);

    private static boolean cardChecker(long cardNumber) {
        int cardNumberLength = Long.toString(cardNumber).length();
        return cardNumberLength == 16;
    }

    public static void processPayment(long cardNumber, Invoice invoice)  {
        if (cardChecker(cardNumber)) {
            invoice.setPaid(true);
        } else {
            // logging error
            LOGGER.error("Invalid credit card number");
            throw new CardException("Invalid credit card number");
        }
    }
}
