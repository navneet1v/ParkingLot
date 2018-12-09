package com.parkinglot.activity;

import java.util.List;

import com.parkinglot.bo.Car;
import com.parkinglot.bo.ParkingSlot;
import com.parkinglot.bo.Ticket;
import com.parkinglot.modules.ParkingLotModule;
import com.parkinglot.modules.QueryModule;

import lombok.NonNull;

public class UserActivity {
    private ParkingLotModule parkingLotModule;
    private QueryModule queryModule;

    private static UserActivity userActivity;

    private UserActivity() {
        parkingLotModule = ParkingLotModule.getInstance();
        queryModule = QueryModule.getInstance();
    }

    public static UserActivity getInstance() {
        if (userActivity == null) {
            userActivity = new UserActivity();
        }
        return userActivity;
    }

    public void initaliseParkingLot(long size) {
        boolean status = parkingLotModule.initalise(size);
        if (status) {
            System.out.println("Created a parking lot with " + size + " slots");
        } else {
            System.out.println("Parking lot is already intialized");
        }
    }

    public void parkCar(@NonNull final String registrationNumber, @NonNull String color) {
        final Ticket ticket = parkingLotModule.parkVehicle(buildCar(registrationNumber, color));
        if (ticket.isHasError()) {
            System.out.println(ticket.getErrorType());
            return;
        }
        System.out.println(
                "Allocated Slot number : " + ticket.getSlotNumber() + " . Ticket id: " + ticket.getTicketNumber());
    }

    public void leaveCar(int slotNumber) {
        if (slotNumber <= 0) {
            System.out.println("Slot Number is less that or equal to zero, so cannot be free");
            return;
        }
        if (parkingLotModule.leaveVehicle(buildParkingSlot(slotNumber))) {
            System.out.println("Slot Number " + slotNumber + " is free");
        } else {
            System.out.println("Slot Number " + slotNumber + " is greater than current lot size");
        }
    }

    public void getSlotNumberForCarWithColor(@NonNull final String color) {
        final List<ParkingSlot> parkingSlotList = queryModule.getSlotsForColor(color);
        if (parkingSlotList == null || parkingSlotList.isEmpty()) {
            System.out.println("Not Found any slot who have car with color " + color);
            return;
        }
        parkingSlotList.forEach(slot -> System.out.println(slot.getNumber()));
    }

    public void getRegistrationNumberForCarsWithColor(@NonNull String color) {
        final List<ParkingSlot> parkingSlotList = queryModule.getSlotsForColor(color);
        if (parkingSlotList == null || parkingSlotList.isEmpty()) {
            System.out.println("Not Found any Car for color " + color);
            return;
        }
        parkingSlotList.forEach(slot -> System.out.println(slot.getCar().getRegistrationNumber()));
    }

    public void getSlotForRegistrationNumber(@NonNull String registrationNumber) {
        final ParkingSlot parkingSlot = queryModule.getSlotForRegNumber(registrationNumber);
        if (parkingSlot == null) {
            System.out.println("Not Slot found for Reg. number " + registrationNumber);
            return;
        }
        System.out.println(parkingSlot.getNumber());
    }

    public void showParkingLotStatus() {
        parkingLotModule.status();
    }

    private Car buildCar(final String registrationNumber, final String color) {
        return Car.builder().color(color).registrationNumber(registrationNumber).build();
    }

    private ParkingSlot buildParkingSlot(int slotNumber) {
        return ParkingSlot.builder().number(slotNumber).build();
    }
}
