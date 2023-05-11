package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.Main;
import com.solvd.deliveryservice.exceptions.CardException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Payment {
    private final static Logger LOGGER = LogManager.getLogger(Payment.class);
    long cardNumber;
    Invoice invoice;

    public Payment(long cardNumber, Invoice invoice) {
        this.cardNumber = cardNumber;
        this.invoice = invoice;
    }

//    private static boolean cardChecker(long cardNumber) {
////        int cardNumberLength = Long.toString(cardNumber).length();
////        return cardNumberLength == 16;
//    }

    public void processPayment(iCardCheck check)  {
        if (check.validateCard(cardNumber)) {
            invoice.setPaid(true);
        } else {
            // logging error
            LOGGER.error("Invalid credit card number");
            throw new CardException("Invalid credit card number");
        }
    }
}
