package com.manoj.oodesign.LogisticSystem.domain;

import com.manoj.oodesign.LogisticSystem.enumeration.VehicleStatus;

public class Vehicle {
    private int id;
    private String vehicleNo;
    private Location currentLocation;
    private int capacity;
    private VehicleStatus status;

    public Vehicle(int id, String vehicleNo, int capacity) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
}
