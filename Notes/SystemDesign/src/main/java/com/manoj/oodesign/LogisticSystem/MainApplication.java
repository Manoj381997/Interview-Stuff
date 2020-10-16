package com.manoj.oodesign.LogisticSystem;

import com.manoj.oodesign.LogisticSystem.domain.*;
import com.manoj.oodesign.LogisticSystem.enumeration.OrderPriority;
import com.manoj.oodesign.LogisticSystem.enumeration.OrderStatus;
import com.manoj.oodesign.LogisticSystem.enumeration.PaymentMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        User user = new User();
        user.setUserID(1);
        user.setName("Manoj");
        Address address = new Address("OMR", "Chennai", "Tamil Nadu", "India", "600005");
        user.setAddress(address);
        user.setEmailId("manoj@gmail.com");
        user.setMobileNumber("37837298");

        Item item1 = new Item("Laptop", 1000, 1, 500);
        Item item2 = new Item("IPad Pro", 900, 2, 100);

        List<Item> items = new ArrayList<Item>() {{
            add(item1);
            add(item2);
        }};

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setTransactionId("11");
        paymentDetails.setAmount(100);
        paymentDetails.setPaymentMode(PaymentMode.NET_BANKING);

        Location location = new Location(72.5, 89.4);

        Order order = new Order();
        order.setOrderId(1);
        order.setUser(user);
        order.setCurrentStatus(OrderStatus.PENDING);
        order.setDestination(location);
        order.setItems(items);
        order.setOrderPriority(OrderPriority.MEDIUM);
        order.setTimeOfOrderDelivery(new Date());
        order.setPaymentDetails(paymentDetails);

        LogisticSystem logisticSystem = new LogisticSystem();
        logisticSystem.registerNewUser(user);
        logisticSystem.takeAnOrder(order);
        logisticSystem.processOrder(order);

    }
}
