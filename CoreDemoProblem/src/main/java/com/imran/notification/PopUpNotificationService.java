package com.imran.notification;

public class PopUpNotificationService implements NotificationService{

    @Override
    public void sendNotification() {
        System.out.println("Popup Notification Sent");
    }
}
