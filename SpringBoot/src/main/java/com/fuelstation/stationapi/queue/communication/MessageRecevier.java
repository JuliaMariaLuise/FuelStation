package com.fuelstation.queue.communication;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
