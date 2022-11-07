package xyz.cryptomaven.mq.producers;

import javax.jms.JMSContext;
        import javax.jms.JMSException;
        import javax.jms.JMSProducer;
        import javax.jms.Queue;
        import javax.naming.InitialContext;
        import javax.naming.NamingException;

        import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class GuaranteedProduce {

    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext initialContext = new InitialContext();
        Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext(JMSContext.SESSION_TRANSACTED)) {

            JMSProducer producer = jmsContext.createProducer();
            producer.send(requestQueue, "Message 1");

            producer.send(requestQueue, "Message 2");
            jmsContext.commit();
            //jmsContext.rollback();

        }

    }

}
