package com.saman.tutorial;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class MessageReceiver {

    @Resource(mappedName = "jms/sampleConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/sampleQueue")
    private static Queue queue;

    public void getMessages() {
        String message;
        boolean goodByeReceived = false;
        JMSContext jmsContext = connectionFactory.createContext();
        JMSConsumer jMSConsumer = jmsContext.createConsumer(queue);
        System.out.println("Waiting for messages...");
        while (!goodByeReceived) {
            message = jMSConsumer.receiveBody(String.class);
            if (message != null) {
                System.out.print("Received the following message: ");
                System.out.println(message);
                System.out.println();
                if (message.equals("Good bye!")) {
                    goodByeReceived = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }
}