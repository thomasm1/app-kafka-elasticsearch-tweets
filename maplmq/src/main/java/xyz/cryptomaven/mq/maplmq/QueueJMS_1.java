package xyz.cryptomaven.mq.maplmq;
 
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueJMS_1 {

	public static void main(String[] args) {
		// MANUAL CONFIGURATION JMS 1.0
		InitialContext initialContext = null;
		
		try {
			initialContext = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) ( initialContext.lookup("ConnectionFactory"));
			Connection connection = cf.createConnection();
			Session session = connection.createSession();
			Queue queue = (Queue) initialContext.lookup("queue/maplQueue");
			MessageProducer producer = session.createProducer(queue);
			TextMessage message = session.createTextMessage("M.a.P.L. At your Service, your Personal Librarian");
			producer.send(message);
			System.out.println("message sent: "+ message.getText());
			
			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();
			TextMessage messageReceived = (TextMessage) consumer.receive(5000);
			System.out.println("message received: " + messageReceived.getText());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			System.out.println(e.getMessage());
		}
		// initialContext.close();
		// connection.close();
	} 
}
