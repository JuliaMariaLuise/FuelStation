package com.fuelstation.queue;

import org.springframework.stereotype.Component;

@Component
public
class MessageRecevier {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
