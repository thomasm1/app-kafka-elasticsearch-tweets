package xyz.cryptomaven.mq.maplmq;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Properties {

    public static void main(String[] args) throws NamingException, InterruptedException, JMSException {

        InitialContext context = new InitialContext();
        Queue queue = (Queue) context.lookup("queue/maplQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSProducer producer = jmsContext.createProducer();
            TextMessage textMessage = jmsContext.createTextMessage("MaPL Awake and stop not till the goal is reached");
            textMessage.setBooleanProperty("loggedIn", true);
            textMessage.setStringProperty("userToken", "abc-XYZ");
            producer.send(queue, textMessage);

            Message messageReceived = jmsContext.createConsumer(queue).receive(5000);

            System.out.println(messageReceived.getBooleanProperty("loggedIn"));
            System.out.println(messageReceived.getStringProperty("userToken"));


        }

    }
}
