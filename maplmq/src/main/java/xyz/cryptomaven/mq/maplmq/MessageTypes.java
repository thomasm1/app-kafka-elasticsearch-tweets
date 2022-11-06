package xyz.cryptomaven.mq.maplmq;

import javax.jms.BytesMessage;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class MessageTypes {

    public static void main(String[] args) throws NamingException, InterruptedException, JMSException {


        InitialContext context = new InitialContext();
        Queue queue = (Queue) context.lookup("queue/maplQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSProducer producer = jmsContext.createProducer();
            TextMessage textMessage = jmsContext.createTextMessage("Arise Awake, oh MaPL, and stop not till the goal is reached");
            BytesMessage bytesMessage = jmsContext.createBytesMessage();
            bytesMessage.writeUTF("UserLong_123");
            bytesMessage.writeLong(123l);

            StreamMessage streamMessage = jmsContext.createStreamMessage();
            streamMessage.writeBoolean(true);
            streamMessage.writeFloat(2.5f);

            MapMessage mapMessage = jmsContext.createMapMessage();
            mapMessage.setBoolean("isActive", true);

            ObjectMessage objectMessage = jmsContext.createObjectMessage();
            User user = new User();
            user.setId(123);
            user.setUserName("User123");
            objectMessage.setObject(user);

            producer.send(queue, user);

//            BytesMessage messageReceived = (BytesMessage) jmsContext.createConsumer(queue).receive(5000);
//            System.out.println(messageReceived.readUTF());
//            System.out.println(messageReceived.readLong());
////
//
//            StreamMessage streamMessageReceived = (StreamMessage) jmsContext.createConsumer(queue).receive(5000);
//            System.out.println(streamMessageReceived.readBoolean());
//            System.out.println(streamMessageReceived.readFloat());
//
//            MapMessage mapMessageReceived = (MapMessage) jmsContext.createConsumer(queue).receive(5000);
//            System.out.println(mapMessageReceived.getBoolean("isActive"));

            User userReceived = jmsContext.createConsumer(queue).receiveBody(User.class);
            //User object = (User) messageReceived.getObject();
            System.out.println(userReceived.getId());
            System.out.println(userReceived.getUserName());

        }

    }

}
