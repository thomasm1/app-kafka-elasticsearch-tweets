package kafka.page1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerOne {
    public static void main(String[] args) {
        System.out.println("Kafka producer one");

        String KAFKA_HOST = System.getenv("KAFKA_HOST");
        String KAFKA_PORT = System.getenv("KAFKA_PORT");
        String bootstrapServers = KAFKA_HOST + ":" + KAFKA_PORT;

        // Create Producer props
        Properties properties = new Properties();
        //properties.setProperty("bootstrap.servers", bootstrapServers);
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //create producer
        KafkaProducer<String, String > producer = new KafkaProducer<String, String>(properties);

        // create producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "producer one");

        //send data
        producer.send(record);

        producer.flush();
        producer.close();
    }

}