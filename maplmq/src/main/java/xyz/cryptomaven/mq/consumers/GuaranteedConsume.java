package xyz.cryptomaven.mq.consumers;

import javax.jms.JMSConsumer;
        import javax.jms.JMSContext;
        import javax.jms.JMSException;
        import javax.jms.JMSProducer;
        import javax.jms.Queue;
        import javax.jms.TextMessage;
        import javax.naming.InitialContext;
        import javax.naming.NamingException;

        import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class GuaranteedConsume {

    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext initialContext = new InitialContext();
        Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext(JMSContext.SESSION_TRANSACTED)) {

            JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());


            TextMessage message2 = (TextMessage) consumer.receive();
            System.out.println(message2.getText());

            jmsContext.rollback();

            //	message.acknowledge();

        }

    }

}
