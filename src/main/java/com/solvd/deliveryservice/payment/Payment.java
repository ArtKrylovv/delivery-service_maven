package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.Main;
import com.solvd.deliveryservice.exceptions.CardException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Payment {
    private final static Logger LOGGER = LogManager.getLogger(Payment.class);
    Invoice invoice;
    long cardNumber;

    public Payment(long cardNumber, Invoice invoice) {
        this.invoice = invoice;
        this.cardNumber = cardNumber;
    }

    public float getCardNumber() {
        return cardNumber;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

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
