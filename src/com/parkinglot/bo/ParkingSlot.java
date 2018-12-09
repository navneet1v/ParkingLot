package com.parkinglot.bo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParkingSlot {
    private int number;
    private boolean isFree;
    private Car car;

}
