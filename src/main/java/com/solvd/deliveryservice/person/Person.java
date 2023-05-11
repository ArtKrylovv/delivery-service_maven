package com.solvd.deliveryservice.person;

import com.solvd.deliveryservice.exceptions.PersonNameException;
import com.solvd.deliveryservice.utilities.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public abstract class Person implements Id {
    private String firstName;
    private String lastName;
    private long phone;
    private final static Logger LOGGER = LogManager.getLogger(Person.class);


    public Person(String firstName, String lastName, long phone) {
        if (Utilities.nameChecker(firstName)) {
            this.firstName = firstName;
        } else {
            LOGGER.error("First Name must contain characters only");
            throw new PersonNameException("First Name must contain characters only");
        }

        if (Utilities.nameChecker(lastName)) {
            this.lastName = lastName;
        } else {
            LOGGER.error("First Name must contain characters only");
            throw new PersonNameException("First Name must contain characters only");

        }

        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {
        if (Utilities.nameChecker(firstName)) {
            this.firstName = firstName;
        } else {
            LOGGER.error("First Name must contain characters only");
            throw new PersonNameException("First Name must contain characters only");
        }
    }

    public void setLastName(String lastName) {
        if (Utilities.nameChecker(lastName)) {
            this.lastName = lastName;
        } else {
            LOGGER.error("Last Name must contain characters only");
            throw new PersonNameException("Last Name must contain characters only");
        }
    }


    public void setPhone(long phone) {
        this.phone = phone;
    }
    // abstract method
    public abstract HashMap<String, String> getInfo();
}






