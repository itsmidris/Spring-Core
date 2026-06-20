package com.imran.notification;

public class FakeEmailService implements NotificationService{

    @Override
    public void sendNotification() {
        System.out.println("dummy Email Sent");
    }
}
