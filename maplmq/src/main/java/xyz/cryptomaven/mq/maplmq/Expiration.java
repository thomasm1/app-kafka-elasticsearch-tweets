package xyz.cryptomaven.mq.maplmq;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Expiration {


    public static void main(String[] args) throws NamingException, InterruptedException  {

        InitialContext context = new InitialContext();
        Queue queue = (Queue) context.lookup("queue/maplQueue");
        Queue expiryQueue = (Queue) context.lookup("queue/expiryQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            // EXPIRATION
            JMSProducer producer = jmsContext.createProducer();
            producer.setTimeToLive(2000);
            producer.send(queue, "MaPL Arise Awake");
            Thread.sleep(5000);

            Message messageReceived = jmsContext.createConsumer(queue).receive(5000);
            System.out.println(messageReceived.getBody(String.class));

            System.out.println(jmsContext.createConsumer(expiryQueue).receiveBody(String.class));
            System.out.println(messageReceived.getBody(String.class));

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
