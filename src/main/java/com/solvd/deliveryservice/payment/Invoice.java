package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.order.Order;
import com.solvd.deliveryservice.utilities.MyLinkedList;
import com.solvd.deliveryservice.utilities.Utilities;

import java.util.*;

public class Invoice implements Document {
    // stores all invoices in a Custom Linked List
    public static MyLinkedList<String> idList= new MyLinkedList<>();
    public static float SALES_TAX = 0.10F;
    private float totalPriceBeforeTax;
    private float taxAmount;
    private float totalAfterTax;
    private String id;
    private boolean paid;
    private Order order;

    public Invoice(Price price, Order order) {
        this.totalPriceBeforeTax = price.getTotalPrice();
        this.taxAmount = calculateTaxAmount(price.getTotalPrice());
        // after tax
        this.totalAfterTax = calculateTotalPriceAfterTax(totalPriceBeforeTax, taxAmount);
        this.paid = false;
        this.id = generateId();
        idList.addElement(generateId());
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public static void setIdList(MyLinkedList<String> idList) {
        Invoice.idList = idList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public float getTotalPriceBeforeTax() {
        return totalPriceBeforeTax;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public float getTotalAfterTax() {
        return totalAfterTax;
    }

    public static float getSalesTax() {
        return SALES_TAX;
    }

    public String getId() {
        return id;
    }

    public static MyLinkedList<String> getIdList() {
        return idList;
    }

    public boolean isPaid() {
        return paid;
    }

    private float calculateTaxAmount(float totalAfterBeforeTax) {
        return totalAfterBeforeTax * SALES_TAX;
    }

    private float calculateTotalPriceAfterTax(float totalPriceBeforeTax, float taxAmount) {
        return totalPriceBeforeTax + taxAmount;
    }

    public HashMap<String, String> generateInvoice(iInvoiceGen invoiceGen) {
        return invoiceGen.generate(order);
    }

    @Override
    public String convertNumericToText(float numeric) {
        return "Will be implemented later";
    }

    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return "I" + currentTime + randomInt;
    }
}