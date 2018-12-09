package com.parkinglot.bo;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Car {
    @NonNull
    private String registrationNumber;
    @NonNull
    private String color; // can be an enum.
}
