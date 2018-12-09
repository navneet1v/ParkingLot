package com.parkinglot.bo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Ticket {
    private Car car;

    private String ticketNumber;

    private boolean hasError;

    private String errorType;

    private long slotNumber;

}
