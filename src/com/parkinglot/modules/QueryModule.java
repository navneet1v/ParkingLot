package com.parkinglot.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parkinglot.bo.ParkingSlot;

import lombok.NonNull;

public class QueryModule {

    private static QueryModule queryModule;

    private Map<String, List<ParkingSlot>> colorToSlotMap;
    private Map<String, ParkingSlot> regNumberToSlot;

    private QueryModule() {
        colorToSlotMap = new HashMap<>();
        regNumberToSlot = new HashMap<>();
    }

    public static QueryModule getInstance() {
        if (queryModule == null) {
            queryModule = new QueryModule();
        }
        return queryModule;
    }

    public ParkingSlot getSlotForRegNumber(@NonNull final String regNumber) {
        return regNumberToSlot.get(regNumber);
    }

    public void insertSlotForRegNumber(@NonNull final ParkingSlot slot, @NonNull String regNumber) {
        regNumberToSlot.put(regNumber, slot);
    }

    public boolean removeSlotForRegNumber(@NonNull final ParkingSlot slot, @NonNull String regNumber) {
        if (regNumberToSlot.containsKey(regNumber)) {
            regNumberToSlot.remove(slot);
            return true;
        }
        return false;
    }

    public List<ParkingSlot> getSlotsForColor(@NonNull final String color) {
        return colorToSlotMap.get(color);
    }

    public void insertSlotsWithColor(@NonNull final ParkingSlot slot, @NonNull String color) {
        List<ParkingSlot> slotList = new ArrayList<>();
        if (colorToSlotMap.containsKey(color)) {
            slotList = colorToSlotMap.get(color);
        }
        slotList.add(slot);
        colorToSlotMap.put(color, slotList);
    }

    public boolean removeSlotsWithColor(@NonNull final ParkingSlot slot, @NonNull String color) {
        if (colorToSlotMap.containsKey(color)) {
            final List<ParkingSlot> slotList = colorToSlotMap.get(color);
            slotList.remove(slot);
            return true;
        }
        return false;
    }
}
