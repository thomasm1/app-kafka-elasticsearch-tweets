package xyz.cryptomaven.mq.maplmq;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;


import javax.jms.*;
import javax.jms.JMSConsumer;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RequestReply {
    public static void main(String[] args)  throws NamingException, JMSException {
        InitialContext context = new InitialContext();
        Queue queue = (Queue) context.lookup("queue/requestQueue");
//        Queue responseQueue = (Queue) context.lookup("queue/responseQueue");

        try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
                JMSContext jmsContext = cf.createContext()){
            JMSProducer producer = jmsContext.createProducer();

            TemporaryQueue responseQueue = jmsContext.createTemporaryQueue();
            TextMessage message = jmsContext.createTextMessage("Hey MaPL, are you there?");
            message.setJMSReplyTo(responseQueue);
            producer.send(queue,message);

            JMSConsumer consumer = jmsContext.createConsumer(queue);
            TextMessage messageReceived = (TextMessage) consumer.receive();
            System.out.println(messageReceived.getText());

            JMSProducer responseProducer = jmsContext.createProducer();
            responseProducer.send(messageReceived.getJMSReplyTo(), "Yes, I'm Here");

            JMSConsumer responseConsumer = ((JMSContext) jmsContext).createConsumer(responseQueue);
            System.out.println(responseConsumer.receiveBody(String.class));
        }

    }
}
