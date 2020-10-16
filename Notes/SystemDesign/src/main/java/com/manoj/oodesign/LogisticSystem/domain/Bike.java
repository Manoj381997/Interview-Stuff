package com.manoj.oodesign.LogisticSystem.domain;

public class Bike extends Vehicle {

    private static final int CAPACITY_OF_BIKE = 10;

    public Bike(int id, String vehicleNo, int capacity) {
        super(id, vehicleNo, CAPACITY_OF_BIKE);
    }
}
