package com.manoj.oodesign.LogisticSystem.domain;

import com.manoj.oodesign.LogisticSystem.enumeration.OrderPriority;
import com.manoj.oodesign.LogisticSystem.enumeration.OrderStatus;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private OrderPriority orderPriority;
    private User user;
    private Location destination;
    private PaymentDetails paymentDetails;
    private List<Item> items;
    private OrderStatus currentStatus;
    private Date timeOfOrderPlaced;
    private Date timeOfOrderDelivery;
    private Vehicle vehicleOfThisOrder;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderPriority getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(OrderPriority orderPriority) {
        this.orderPriority = orderPriority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(OrderStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getTimeOfOrderPlaced() {
        return timeOfOrderPlaced;
    }

    public void setTimeOfOrderPlaced(Date timeOfOrderPlaced) {
        this.timeOfOrderPlaced = timeOfOrderPlaced;
    }

    public Date getTimeOfOrderDelivery() {
        return timeOfOrderDelivery;
    }

    public void setTimeOfOrderDelivery(Date timeOfOrderDelivery) {
        this.timeOfOrderDelivery = timeOfOrderDelivery;
    }

    public Vehicle getVehicleOfThisOrder() {
        return vehicleOfThisOrder;
    }

    public void setVehicleOfThisOrder(Vehicle vehicleOfThisOrder) {
        this.vehicleOfThisOrder = vehicleOfThisOrder;
    }
}
