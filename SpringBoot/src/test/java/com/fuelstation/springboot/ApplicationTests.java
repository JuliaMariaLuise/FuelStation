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

import static org.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RabbitListenerTest
public class ApplicationTest {

	@Autowired
	private MessageSender messageSender;

	@SpyBean
	private MessageReceiver messageReceiver;

	@Test
	public void testSendAndReceive() throws Exception {
		String testMessage = "Hello, RabbitMQ!";
		messageSender.sendMessage(testMessage);

		// Verwenden von Awaitility, um auf den Empfang der Nachricht zu warten
		await().atMost(10, SECONDS).untilAsserted(() ->
				verify(messageReceiver, times(1)).receiveMessage(testMessage)
		);
	}
}
