package com.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.parkinglot.Constants.InputConstants;
import com.parkinglot.callers.MainClassCaller;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Parking Lot:");
        while (true) {
            System.out.println("Enter a command : ");
            final String input = getUserInput();
            if (input.length() <= 0) {
                System.out.println("Enter a valid Command");
                continue;
            }
            final String command = input.split(" ")[0];
            if (InputConstants.CREATE_PARKING_LOT.equalsIgnoreCase(command)) {
                System.out.println("Creating " + input);
                MainClassCaller.validateAndCallCreateParkingLot(input);
            } else if (InputConstants.PARK.equalsIgnoreCase(command)) {
                System.out.println("Parking");
                MainClassCaller.validateAndPark(input);
            } else if (InputConstants.LEAVE.equalsIgnoreCase(command)) {
                System.out.println("Leaving");
                MainClassCaller.validateAndLeave(input);
            } else if (InputConstants.STATUS.equalsIgnoreCase(command)) {
                System.out.println("Status");
                MainClassCaller.validateAndShowStatus(input);
            } else if (InputConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMER.equalsIgnoreCase(command)) {
                System.out.println(InputConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMER);
                MainClassCaller.validateAndGetSlotForRegistrationNumber(input);
            } else if (InputConstants.SLOT_NUMBER_FOR_CARS_WITH_COLOR.equalsIgnoreCase(command)) {
                System.out.println(InputConstants.SLOT_NUMBER_FOR_CARS_WITH_COLOR);
                MainClassCaller.validateAndGetSlotForCarsWithColor(input);
            } else if (InputConstants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR.equalsIgnoreCase(command)) {
                System.out.println(InputConstants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR);
                MainClassCaller.validateAndGetRegistrationNumberFroCarWithColor(input);
            } else if ("Exit".equalsIgnoreCase(command)) {
                break;
            } else {
                System.out.println(command + " Not found");
            }
        }
    }

    private static String getUserInput() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
