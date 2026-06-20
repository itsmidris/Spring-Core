package com.imran;

import com.imran.notification.EmailService;
import com.imran.notification.FakeEmailService;
import com.imran.notification.NotificationService;
import com.imran.notification.PopUpNotificationService;

public class Main {
    public static void main(String[] args) {

        NotificationService notification = new EmailService();

        //OrderService order = new OrderService(notification);

        OrderService order = new OrderService();
        order.setNotification(notification);

        order.placeOrder();

    }
}

// A class should ask what it needs and
// not build everything itself
// Follow SOLID Principle