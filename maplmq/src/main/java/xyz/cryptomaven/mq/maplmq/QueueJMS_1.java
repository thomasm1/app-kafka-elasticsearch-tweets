package xyz.cryptomaven.mq.maplmq;



import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.QueueBrowser;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;



import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Enumeration;


public class QueueJMS_1 {
	static int count = 0;
	public static void main(String[] args) {
		// MANUAL CONFIGURATION JMS 1.0
		InitialContext initialContext = null;
		Connection connection = null;

		try {
			initialContext = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) (initialContext.lookup("ConnectionFactory"));
			connection = cf.createConnection();
			Session session = connection.createSession();
			Queue queue = (Queue) initialContext.lookup("queue/maplQueue");
			MessageProducer producer = session.createProducer(queue);
			TextMessage message = session.createTextMessage("Good morning M.a.P.L. AAre you at my Service? My Personal Librarian");
			TextMessage message2 = session.createTextMessage("Good evening M.a.P.L. AAre you at my Service? My Personal Librarian");
			producer.send(message);
			producer.send(message2);

			System.out.println(count++ + "message sent: " + message.getText());
			System.out.println(count++ + "message 2 sent: " + message2.getText());

			QueueBrowser browser = session.createBrowser(queue);
			Enumeration messagesEnum = browser.getEnumeration();

			while (messagesEnum.hasMoreElements()) {
				TextMessage eachMsg = (TextMessage) messagesEnum.nextElement();
				System.out.println(count++ + "Browsing: " + eachMsg.getText());
			}

			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();

			TextMessage messageReceived = (TextMessage) consumer.receive(5000);
			System.out.println(count++ + "message received: " + messageReceived.getText());

			messageReceived = (TextMessage) consumer.receive(5000);
			System.out.println(count++ + "message 2 received: " + messageReceived.getText());

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			System.out.println(e.getMessage());
		} finally {
			if (initialContext != null) {
				try {
					initialContext.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
