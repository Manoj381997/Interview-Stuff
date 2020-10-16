package com.manoj.oodesign.LogisticSystem.domain;

public class Truck extends Vehicle {

    private static final int CAPACITY_OF_TRUCK = 10;

    public Truck(int id, String vehicleNo, int capacity) {
        super(id, vehicleNo, CAPACITY_OF_TRUCK);
    }
}
