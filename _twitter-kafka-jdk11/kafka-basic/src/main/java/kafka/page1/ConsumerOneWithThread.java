package kafka.page1;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerOneWithThread {

    public static void main(String[] args) {
        System.out.println("Consumer One starting ....");
        new ConsumerOneWithThread().run();
    }
    private ConsumerOneWithThread() {

    }

    private void run(){
        Logger logger = LoggerFactory.getLogger(ConsumerOneWithThread.class.getName());

        String KAFKA_HOST = System.getenv("KAFKA_HOST");
        String KAFKA_PORT = System.getenv("KAFKA_PORT");
        String bootstrapServers = KAFKA_HOST + ":" + KAFKA_PORT;

        String groupId = "my-sixth-app";
        String topic = "first-topic";

        //latch for dealilng with multiple threads
        CountDownLatch latch = new CountDownLatch(1);

        //Create consumer runnable
        logger.info("Creating the consumer thread");
        Runnable myConsumerRunnable = new ConsumerRunnable(
                bootstrapServers,
                groupId,
                topic,
                latch
        );
        // start the thread
        Thread myThread = new Thread(myConsumerRunnable);
        myThread.start();

        // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            logger.info("Caught shutdown hook");
            ((ConsumerRunnable) myConsumerRunnable).shutdown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Application has exited");
        }

        ));

        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.error("Application got interrupted", e);
        } finally {
            logger.info("Application is closing");
        }
    }

    public class ConsumerRunnable implements Runnable {

        private CountDownLatch latch;
        private KafkaConsumer<String, String> consumer;
        private Logger logger = LoggerFactory.getLogger(ConsumerRunnable.class.getName());

        public ConsumerRunnable(String bootstrapServers,
                              String groupId,
                              String topic,
                              CountDownLatch latch) {
            this.latch = latch;
            // create consumer configs
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // earliest, none,latest

            // create consumer
            consumer = new KafkaConsumer<String, String>(properties);

            // subscribe consumer to topic(s)
            consumer.subscribe(Arrays.asList(topic));
        }
        @Override
        public void run() {
            // polling for new data
            try {
                while(true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                    for (ConsumerRecord<String, String> record : records) {
                        logger.info("Key: " + record.key() + ", Value: " + record.value());
                        logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                    }
                }
                } catch (WakeupException e) {
                    logger.info("Received Shutdown Signal!!");
            } finally {
                consumer.close();
                //tell our main code we're donwe with consumer
                latch.countDown();
            }
        }

        public void shutdown() {
            // the wakeup() method is special method to interrupt consumer.poll()
            // it will throw the exception WakUpException
            consumer.wakeup();

        }
    }
}
