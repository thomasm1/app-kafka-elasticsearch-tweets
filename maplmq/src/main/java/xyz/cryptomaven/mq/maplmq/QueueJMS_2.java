package xyz.cryptomaven.mq.maplmq;


import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class QueueJMS_2 {
	static int count = 0;
	public static void main(String[] args) throws NamingException {

		InitialContext context = new InitialContext();
		Queue queue = (Queue) context.lookup("queue/maplQueue");

		try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
			JMSContext jmsContext = cf.createContext()) {

//			jmsContext.createProducer().send(queue, "MaPL? Are you there my personal librarian ...");
			JMSProducer producer  = jmsContext.createProducer();

			String[] messages = new String[3];
			messages[0] = "msg one";
			messages[1] = "msg two";
			messages[2] = "msg three";
			producer.setPriority(3);
			producer.send(queue, messages[0]);

			producer.setPriority(1);
			producer.send(queue, messages[1]);
			producer.setPriority(3); // 9 to 1 to not interfere later on
			producer.send(queue, messages[2]);

//			String receivedMessage = jmsContext.createConsumer(queue).receiveBody(String.class);
			JMSConsumer consumer = jmsContext.createConsumer(queue);
			for(int i=0; i<3; i++) {
				Message receivedMessage = consumer.receive();
				System.out.println(receivedMessage.getJMSPriority());
				System.out.println(receivedMessage.getBody(String.class));
			}
//			System.out.println(receivedMessage);

		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	} 
}
