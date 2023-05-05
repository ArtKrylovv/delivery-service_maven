package com.solvd.deliveryservice.input;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int getInt(String message){
        try {
            System.out.println(message);
            return scanner.nextInt();
        } finally {
            scanner.nextLine(); // cleans up \n input
        }
    }

    public static long getLong(String message){
        try {
            System.out.println(message);
            return scanner.nextLong();
        } finally {
            scanner.nextLine(); // cleans up \n input
        }
    }

    public static float getFloat(String message){
        try {
            System.out.println(message);
            return scanner.nextFloat();
        } finally {
            scanner.nextLine(); // cleans up \n input
        }
    }

    public static double getDouble(String message){
        try {
        System.out.println(message);
        return scanner.nextDouble();
    } finally {
            scanner.nextLine(); // cleans up \n input
        }
    }

    public static boolean getBoolean(String message){
        try {
            System.out.println(message);
            return scanner.nextBoolean();
        } finally {
            scanner.nextLine(); // cleans up \n input
        }
    }

    // scanner must be closed
    public static void close(){
        scanner.close();
    }
}





