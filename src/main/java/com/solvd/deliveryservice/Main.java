package com.solvd.deliveryservice;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.address.HouseAddress;
import com.solvd.deliveryservice.order.Order;
import com.solvd.deliveryservice.parcel.Parcel;
import com.solvd.deliveryservice.payment.*;
import com.solvd.deliveryservice.person.Customer;
import com.solvd.deliveryservice.person.Employee;
import com.solvd.deliveryservice.person.Position;
import com.solvd.deliveryservice.person.Recipient;
import com.solvd.deliveryservice.store.PhysicalStore;


import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //  creating stores
        HouseAddress storeOneAddress = new HouseAddress("Lincoln", 1000, "Los Angeles", "CA");
        HouseAddress storeTwoAddress = new HouseAddress("Main", 2000, "San Diego", "CA");

        PhysicalStore store1 = new PhysicalStore(storeOneAddress);
        PhysicalStore store2 = new PhysicalStore(storeTwoAddress);

        // creating customer
        Customer customer = new Customer("Art", "Krylov", 3233336832L);

        // creating order
        Recipient recipient = new Recipient("Ilan", "Gavrilov", 3233336830L);
        Address deliveryAddress = new HouseAddress("Main", 100, "LA", "CA");
        int[] parcelDimensions = {5, 5, 5};
        Parcel parcel = new Parcel("Box", 5, parcelDimensions);
        Order order = new Order(customer, recipient, deliveryAddress);
        order.setExpress(true);
        order.setParcel(parcel);

        // creating invoice
        // uses iDiscountGen
        Discount discount = new Discount(0F, customer);
        float totalDiscount = discount.calculateTotalDiscount(((Customer customer1) -> {
                    if (customer1.isVeteranStatus()) {
                        return discount.manualDiscount + Discount.VETERAN_DISCOUNT;

                    } else {
                        return discount.manualDiscount;
                    }
                })
        );

        // uses enum Currency
        Price price = new Price(totalDiscount, order, Currency.USD);
        Invoice invoice = new Invoice(price, order);
        Payment payment = new Payment(1111111111111111L, invoice);

        // uses iCardCheck
        payment.processPayment((cardNumber -> {
            int cardNumberLength = Long.toString(cardNumber).length();
            return cardNumberLength == 16;
                })
        );
        // uses iInvoiceGen
        HashMap<String, String> invoiceDoc = invoice.generateInvoice(((Order order1) -> {
            HashMap<String, String> myInvoice = new HashMap<>();
            myInvoice.put("Tax amount", Float.toString(invoice.getTaxAmount()));
            myInvoice.put("Total after tax", Float.toString(invoice.getTotalAfterTax()));
            myInvoice.put("Invoice paid", Boolean.toString(invoice.isPaid()));
            myInvoice.put("Invoice ID", invoice.getId());
            String fullAddress = Arrays.toString(order1.getAddress().getFullAddress());
            myInvoice.put("Delivery address", fullAddress);
            return myInvoice;
                })
        );

        System.out.println(invoiceDoc);

        // uses enum Position
        Employee employee1 = new Employee("Elon", "Musk", 7777777777L);
        employee1.setPosition(Position.DIRECTOR);
        System.out.println(employee1.getPosition().gradeToString());

    }
}
