package com.solvd.deliveryservice.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public final class Utilities {

    // checks if state length == 2
    public static boolean stateChecker(String state) {
        return state.length() == 2;
    }

    // checks if name consists only of characters w/o integers and special characters
    public static boolean nameChecker(String str) {
        return str.matches("[a-zA-Z]+");
    }

    // return current day of the week
    public static String getDayOfTheWeek(){
        LocalDate date = LocalDate.now(); // get the current date
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}


