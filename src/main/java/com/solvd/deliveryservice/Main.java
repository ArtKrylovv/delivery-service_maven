package com.solvd.deliveryservice;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.address.ApartmentAddress;
import com.solvd.deliveryservice.address.HouseAddress;
import com.solvd.deliveryservice.delivery.Delivery;
import com.solvd.deliveryservice.input.Input;
import com.solvd.deliveryservice.order.Order;
import com.solvd.deliveryservice.parcel.Parcel;
import com.solvd.deliveryservice.payment.Discount;
import com.solvd.deliveryservice.payment.Invoice;
import com.solvd.deliveryservice.payment.Price;
import com.solvd.deliveryservice.payment.Processing;
import com.solvd.deliveryservice.person.Customer;
import com.solvd.deliveryservice.person.Employee;
import com.solvd.deliveryservice.person.Recipient;
import com.solvd.deliveryservice.store.OnlineStore;
import com.solvd.deliveryservice.store.PhysicalStore;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

import com.solvd.deliveryservice.utilities.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    // creates logger
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Starting service");

        // existing stores
        HouseAddress storeOneAddress = new HouseAddress("Lincoln", 1000, "Los Angeles", "CA");
        HouseAddress storeTwoAddress = new HouseAddress("Main", 2000, "San Diego", "CA");

        PhysicalStore store1 = new PhysicalStore(storeOneAddress);
        PhysicalStore store2 = new PhysicalStore(storeTwoAddress);

        // enables user to exit console app
        boolean exit = false;

        // console block
        while (!exit) {

            boolean storeSelection = false;
            boolean userCreation = false;
            boolean recipientCreation = false;
            boolean deliveryAddressCreation = false;
            boolean parcelCreation = false;
            boolean orderCreation = false;
            boolean paymentProcessing = false;

            // GREETING
            System.out.println("************* WELCOME TO USPX DELIVERY *************");
            System.out.println();

            // STORE SELECTION
            PhysicalStore selectedStore = null; // check why I need to explicitly set it to null
            System.out.println("Please Input Store Number or Input \"Exit\" To Quit:");
            System.out.println();

            while (!exit && !storeSelection) {

                String selectedStoreNumber = Input.getString("#1 " + Arrays.toString(store1.getAddress().getFullAddress()) + "\n#2 " + Arrays.toString(store2.getAddress().getFullAddress()));

                if (selectedStoreNumber.equals("Exit")) {
                    exit = true;
                    System.out.println("Goodbye!");
                } else if (selectedStoreNumber.equals("1")) {
                    selectedStore = store1;
                    System.out.println(selectedStore.workingTodayChecker(Utilities.getDayOfTheWeek()));
                    storeSelection = true;

                } else if (selectedStoreNumber.equals("2")) {
                    selectedStore = store2;
                    System.out.println(selectedStore.workingTodayChecker(Utilities.getDayOfTheWeek()));
                    storeSelection = true;
                } else {
                    System.out.println("!!! Wrong entry !!!");
                }
            }

            // USER CREATION
            Customer customer = null;
            while (!exit && !userCreation) {
                try {
                    String customerFirstName = Input.getString("\nPlease input your FIRST NAME:");
                    String customerLastName = Input.getString("Please input your LAST NAME:");
                    long customerPhone = Input.getLong("Please input your PHONE (numbers only):");
                    boolean veteranStatus = Input.getBoolean("Please input \"true\" if you are a veteran and \"false\" if not:");
                    customer = new Customer(customerFirstName, customerLastName, customerPhone);
                    customer.setVeteranStatus(veteranStatus);
                    userCreation = true;
                } catch (Exception e) {
                    System.out.println("!!! Wrong entry !!!");
                }
            }
            // RECIPIENT CREATION
            Recipient recipient = null;
            while (!exit && !recipientCreation) {
                try {
                    String recipientFirstName = Input.getString("Please input recipient FIRST NAME:");
                    String recipientLastName = Input.getString("Please input recipient LAST NAME:");
                    long recipientPhone = Input.getLong("Please input recipient PHONE (numbers only):");
                    recipient = new Recipient(recipientFirstName, recipientLastName, recipientPhone);
                    recipientCreation = true;
                } catch (Exception e) {
                    System.out.println("!!! Wrong entry !!!");
                }
            }
            // DELIVERY ADDRESS CREATION
            String addressType = "none";
            Address deliveryAddress = null;

            while (!exit && addressType.equals("none")) {
                String addressTypeInput = Input.getString("Please input recipient address type \"Apartment\" or \"House\"");
                if (addressTypeInput.equals("Apartment") | addressTypeInput.equals("House")) {
                    addressType = addressTypeInput;
                } else {
                    System.out.println("!!! Wrong entry !!!");
                }
            }
            while (!exit & !deliveryAddressCreation) {
                if (addressType.equals("House")) {
                    try {
                        System.out.println("Please provide delivery address");
                        String street = Input.getString("Please input Street:");
                        int house = Input.getInt("Please input house #:");
                        String city = Input.getString("Please input city:");
                        String state = Input.getString("Please input state, e.g \"CA\" for California:");
                        deliveryAddress = new HouseAddress(street, house, city, state);
                        deliveryAddressCreation = true;
                    } catch (Exception e) {
                        System.out.println("!!! Wrong entry !!!");
                    }

                } else {
                    try {
                        System.out.println("Please provide delivery address");
                        String street = Input.getString("Please input Street:");
                        int house = Input.getInt("Please input house #:");
                        int apt = Input.getInt("Please input apartment #:");
                        String city = Input.getString("Please input city:");
                        String state = Input.getString("Please input state, e.g \"CA\" for California:");
                        deliveryAddress = new ApartmentAddress(street, house, city, state);
                        ((ApartmentAddress) deliveryAddress).setAptNumber(apt);
                        deliveryAddressCreation = true;
                    } catch (Exception e) {
                        System.out.println("!!! Wrong entry !!!");
                    }

                }
            }
            // CHECK POINT 1
            // Implement later

            // PARCEL CREATION
            Parcel parcel = null;
            while (!exit && !parcelCreation) {
                try {
                    String description = Input.getString("Please input parcel description");
                    int weight = Input.getInt("Please input parcel weight in lbs (rounded to whole numbers):");
                    int h = Input.getInt("Please input parcel height in inches (rounded to whole numbers):");
                    int w = Input.getInt("Please input parcel width in inches (rounded to whole numbers):");
                    int d = Input.getInt("Please input parcel depth in inches (rounded to whole numbers):");
                    int[] dimensions = {h, w, d};
                    parcel = new Parcel(description, weight, dimensions);
                    parcelCreation = true;
                    System.out.println("Your Parcel Volume Is: " + parcel.calculateVolume() + " inches^3");
                } catch (Exception e) {
                    System.out.println("!!! Wrong entry !!!");
                }
            }
            // ORDER CREATION
            Order order = null;
            while (!exit && !orderCreation) {
                try {
                    boolean express = Input.getBoolean("\nPlease input \"true\" for express delivery and \"false\" for standard:");
                    order = new Order(customer, recipient, deliveryAddress);
                    order.setParcel(parcel);
                    order.setStore(selectedStore);
                    order.setExpress(express);
                    orderCreation = true;
                } catch (Exception e) {
                    System.out.println("!!! Wrong entry !!!");
                }
            }

            //INVOICE CREATION & PRINTING (Price, Lead time)
            Discount discount = null;
            Price price = null;
            Invoice invoice = null;

            if (!exit) {
                discount = new Discount(0F, customer.isVeteranStatus());
                price = new Price(discount, order);
                invoice = new Invoice(price);
                System.out.println("Your Invoice: "+invoice.generateInvoice(order));
                System.out.println("Your Delivery Time: "+Delivery.getLeadTime(order)+" Day(s)");
            }

            //CHECK POINT
            while (!exit) {
                String proceed = Input.getString("\nPress \"OK\" to Continue OR \"EXIT\" to QUIT ");
                if (proceed.equals("EXIT")) {
                    exit = true;
                    System.out.println("Goodbye!");
                } else if (proceed.equals("OK")) {
                    break;
                } else {
                    System.out.println("!!! Wrong entry !!!");
                }
            }

            while (!exit && !paymentProcessing) {
                try {
                    long cardNumber = Input.getLong("\nPlease input your 16 digits card number (do not separate digits by spaces):");
                    Processing.processPayment(cardNumber, invoice);
                    System.out.println("Thank you for your payment!");
                    System.out.println("Your Invoice: "+invoice.generateInvoice(order));
                    paymentProcessing = true;
                } catch (Exception e) {
                    System.out.println("!!! Wrong entry !!!");
                }

            }
            exit = true;
            Invoice.getIdList().printEls();
            System.out.println("--------------------------------------------------------");
            Input.close();
        }
    }
}