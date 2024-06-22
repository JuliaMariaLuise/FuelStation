package com.fuelstation;

import com.fuelstation.queue.communication.MessageReceiver;
import com.fuelstation.queue.communication.MessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.test.RabbitListenerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RabbitListenerTest
public class RabbitMQIntegrationTest {

    @Autowired
    private MessageSender messageSender;

    @SpyBean
    private MessageReceiver messageReceiver;

    @Test
    public void testSendAndReceive() throws Exception {
        String testMessage = "Hello, RabbitMQ!";
        messageSender.sendMessage(testMessage);

        // Warten, bis die Nachricht empfangen wurde
        Thread.sleep(1000);

        // Überprüfen, ob die Nachricht empfangen wurde
        verify(messageReceiver, times(1)).receiveMessage(testMessage);
    }
}
