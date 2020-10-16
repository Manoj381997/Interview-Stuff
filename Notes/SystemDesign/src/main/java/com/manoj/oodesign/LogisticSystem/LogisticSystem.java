package com.manoj.oodesign.LogisticSystem;

import com.manoj.oodesign.LogisticSystem.domain.Order;
import com.manoj.oodesign.LogisticSystem.domain.Vehicle;
import com.manoj.oodesign.LogisticSystem.domain.Location;
import com.manoj.oodesign.LogisticSystem.domain.User;

import java.util.ArrayList;
import java.util.List;

public class LogisticSystem {
    private List<Order> orders;
    private List<Vehicle> vehicles;
    private List<User> users;

    public LogisticSystem() {
        this.orders = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void takeAnOrder(Order order) {
        System.out.println("Adding an Order");
        this.orders.add(order);
    }

    public  void processOrder(Order order) {
        System.out.println("Processing an order");
    }

    public Location trackOrder(Order order) {
        System.out.println("Tracking an order");
        Location location = null;
//        location = findLocationOfOrder(order);
        return location;
    }

    public void cancelOrder(Order order) {
        System.out.println("Cancelling an order");
    }

    public void registerNewUser(User user) {
        System.out.println("Registering a new user to the system");
        this.users.add(user);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
