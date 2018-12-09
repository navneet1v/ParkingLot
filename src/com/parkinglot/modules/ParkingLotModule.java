package com.parkinglot.modules;

import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import com.parkinglot.bo.Car;
import com.parkinglot.bo.ParkingSlot;
import com.parkinglot.bo.Ticket;

import lombok.NonNull;

public class ParkingLotModule {
    private static ParkingLotModule parkingLotModule;
    private long size;
    private List<ParkingSlot> parkingSlots;

    private ParkingLotModule() {
        size = 0;
        parkingSlots = new Vector<>();
    }

    public static ParkingLotModule getInstance() {
        if (parkingLotModule == null) {
            parkingLotModule = new ParkingLotModule();
        }
        return parkingLotModule;
    }

    public boolean initalise(long size) {
        if (size == 0) {
            return false;
        }
        this.size = size;
        parkingSlots = new Vector<>();
        return true;
    }

    public Ticket parkVehicle(@NonNull final Car car) {
        final ParkingSlot parkingSlot = getEmptySpace();
        if (parkingSlot == null) {
            return Ticket.builder().errorType("Sorry, Parking Lot is full").hasError(true).build();
        }
        parkingSlot.setCar(car);
        parkingSlot.setFree(false);
        indexAttributes(parkingSlot);
        return Ticket.builder().car(car).ticketNumber(String.valueOf(Math.abs(new Random().nextInt()))).hasError(false)
                .slotNumber(parkingSlot.getNumber()).build();

    }

    public boolean leaveVehicle(@NonNull final ParkingSlot slot) {
        if (slot.getNumber() > size) {
            return false;
        }
        final ParkingSlot slotFound = parkingSlots.get(slot.getNumber() - 1);
        removeIndexing(slotFound);
        slotFound.setFree(true);
        slotFound.setCar(null);
        return true;
    }

    public void status() {
        System.out.println("No\tRegistration\tSlotNo.\tColor");
        AtomicInteger integer = new AtomicInteger(0);
        parkingSlots.forEach(slot -> {
            if (!slot.isFree()) {
                System.out.printf("%d\t%s\t%s\t%s%n", integer.incrementAndGet(), slot.getCar().getRegistrationNumber(),
                        slot.getNumber(), slot.getCar().getColor());

            }
        });
    }

    private ParkingSlot getEmptySpace() {
        ParkingSlot slot = null;
        for (ParkingSlot tslot : parkingSlots) {
            if (tslot.isFree()) {
                slot = tslot;
                break;
            }
        }
        if (slot == null && parkingSlots.size() < size) {
            slot = ParkingSlot.builder().isFree(true).number(parkingSlots.size() + 1).build();
            parkingSlots.add(slot);
        }
        return slot;
    }

    private void indexAttributes(@NonNull final ParkingSlot slot) {
        QueryModule.getInstance().insertSlotForRegNumber(slot, slot.getCar().getRegistrationNumber());
        QueryModule.getInstance().insertSlotsWithColor(slot, slot.getCar().getColor());
    }

    private void removeIndexing(@NonNull final ParkingSlot slot) {
        QueryModule.getInstance().removeSlotForRegNumber(slot, slot.getCar().getRegistrationNumber());
        QueryModule.getInstance().removeSlotsWithColor(slot, slot.getCar().getColor());
    }

}
