package com.test.BootP01;


import org.springframework.stereotype.Service;


@Service //Business Logic
public class EmailService implements MessageService{

    @Override
    public String sendMessage() {
        return "Email: you got new email";
    }
}
