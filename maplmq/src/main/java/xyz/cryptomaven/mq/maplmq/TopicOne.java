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
	public static void main(String[] args) throws  Exception {

		InitialContext initialContext = new InitialContext();
		Topic topic = (Topic) initialContext.lookup("topic/MaPLTopic");
		
		ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
		Connection connection = cf.createConnection();
		
		Session session = connection.createSession();
		MessageProducer producer = session.createProducer(topic);

		MessageConsumer consumer1 = session.createConsumer(topic);
		MessageConsumer consumer2 = session.createConsumer(topic);

		TextMessage message = session.createTextMessage("TOPIC: My Personal Libarian: MaPL");
		producer.send(message);

		connection.start();
		TextMessage message1 = (TextMessage) consumer1.receive();
		System.out.println("Consumer 1 message received: " + message1.getText());

		TextMessage message2 = (TextMessage) consumer2.receive();
		System.out.println("Consumer 2 message received: " + message2.getText());
		
		connection.close();
		initialContext.close();
		
		
	}
}
