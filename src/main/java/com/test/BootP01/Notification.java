package com.test.BootP01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Neither Business Logic nor DB
public class Notification {

    @Autowired
    private MessageService messageService;

    public Notification(){

    }

    public Notification(MessageService messageService){
        this.messageService=messageService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(){
        System.out.println(messageService.sendMessage());
    }

}
