package xyz.cryptomaven.mq.maplmq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicOne {
	public static void main(String[] args) throws NamingException, Exception {
		
		InitialContext initialContext = new InitialContext();
		Topic topic = (Topic) initialContext.lookup("topic/mplTopic");
		
		ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
		Connection connection = cf.createConnection();
		
		Session session = connection.createSession();
		MessageProducer producer = session.createProducer(topic);
		System.out.println(topic.getClass());
		MessageConsumer consumer1 = session.createConsumer(topic);
		MessageConsumer consumer2 = session.createConsumer(topic);

		System.out.println(consumer1.getClass());
		TextMessage message = session.createTextMessage("TOPIC: My Personal Libarian: MaPL");
		producer.send(message);
		System.out.println(message);
		TextMessage message1 = (TextMessage) consumer1.receive();
		System.out.println("Consumer 1 message received: " + message1.getText());

		System.out.println(message1);
		TextMessage message2 = (TextMessage) consumer2.receive();
		System.out.println("Consumer 2 message received: " + message2.getText());
		
		connection.close();
		initialContext.close();
		
		
	}
}
