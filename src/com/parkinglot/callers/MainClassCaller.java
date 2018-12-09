package com.parkinglot.callers;

import com.parkinglot.activity.UserActivity;
import com.parkinglot.exceptions.InvalidInputException;

import lombok.NonNull;

public class MainClassCaller {

    private static final String INVALID_INPUT_MESSAGE = "Invalid Input";

    public static void validateAndCallCreateParkingLot(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            System.out.println(inputs[0] + " " + inputs[1]);
            if (inputs.length == 2) {
                int size = Integer.parseInt(inputs[1]);
                UserActivity.getInstance().initaliseParkingLot(size);
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Not a valid input " + command);
            e.printStackTrace();
        }
    }

    public static void validateAndPark(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            if (inputs.length == 3) {
                UserActivity.getInstance().parkCar(inputs[1], inputs[2]);
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error while Parking the car");
            e.printStackTrace();
        }
    }

    public static void validateAndLeave(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            if (inputs.length == 2) {
                int slotNumber = Integer.parseInt(inputs[1]);
                UserActivity.getInstance().leaveCar(slotNumber);
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Not a valid input " + command);
            e.printStackTrace();
        }
    }

    public static void validateAndShowStatus(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            if (inputs.length == 1) {
                UserActivity.getInstance().showParkingLotStatus();
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Not a valid input " + command);
            e.printStackTrace();
        }
    }

    public static void validateAndGetSlotForRegistrationNumber(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            if (inputs.length == 2) {
                UserActivity.getInstance().getSlotForRegistrationNumber(inputs[1]);
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Not a valid input " + command);
            e.printStackTrace();
        }
    }

    public static void validateAndGetSlotForCarsWithColor(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            if (inputs.length == 2) {
                UserActivity.getInstance().getSlotNumberForCarWithColor(inputs[1]);
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Not a valid input " + command);
            e.printStackTrace();
        }
    }

    public static void validateAndGetRegistrationNumberFroCarWithColor(@NonNull final String command) {
        try {
            final String inputs[] = command.split(" ");
            if (inputs.length == 2) {
                UserActivity.getInstance().getRegistrationNumberForCarsWithColor(inputs[1]);
                return;
            }
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        } catch (Exception e) {
            System.out.println("Not a valid input " + command);
            e.printStackTrace();
        }
    }

}
