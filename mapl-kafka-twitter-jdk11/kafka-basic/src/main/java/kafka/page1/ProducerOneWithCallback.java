
package kafka.page1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerOneWithCallback {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Kafka producer one Starting");

        final Logger logger;
        logger = LoggerFactory.getLogger(ProducerOneWithCallback.class);

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
        KafkaProducer<String, String > producer;
        producer = new KafkaProducer<String, String>(properties);

        for(int i=0;i<10;i++) {

            // create producer record
            String topic = "first_topic";
            String value = "producer one times..."+ Integer.toString(i);
            String key = "id_" + Integer.toString(i);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);

            logger.info("Key: " + key + "...and Value: " + value); // GIVEN KEY GOING TO SAME PARTITION

            //send data
            producer.send(record, new Callback() {
                        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                          // executes every time a record is successfully sent or an exception thrown
                          if (e == null) {
                              // record successfully sent
                              logger.info("Received new metadata: \n" +
                                      "Topic:" + recordMetadata.topic() + "\n" +
                                      "Partition" + recordMetadata.partition() + "\n"+
                                      "Offset:" + recordMetadata.offset() + "\n" +
                                      "Timestamp" + recordMetadata.timestamp());

                          } else {
                            logger.error("Error while producing"+e);
                          }
                        }
                    }).get(); // block the .send() to make synchronous (not for prod)
        }
        producer.flush();
        producer.close();
    }

}