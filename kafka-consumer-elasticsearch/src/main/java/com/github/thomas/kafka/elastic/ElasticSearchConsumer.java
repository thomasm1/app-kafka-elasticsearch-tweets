package com.github.thomas.kafka.elastic;


import com.google.gson.JsonParser;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

// ./bin/windows/kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic twitter_tweets
// ./bin/windows/kafka-consumer-groups --bootstrap-server 127.0.0.1:9092 --group kafka-demo-elasticsearch --describe


public class ElasticSearchConsumer {

    private static String KAFKA_HOST = System.getenv("KAFKA_HOST");
    private static String KAFKA_PORT = System.getenv("KAFKA_PORT");
    private static String bootstrapServers = KAFKA_HOST + ":" + KAFKA_PORT;

    public static RestHighLevelClient createClient(){

        String hostname = "twitter-searcher-3257558923.us-east-1.bonsaisearch.net";
        String username = "kmqmyqmj1j";
        String password = System.getenv("ELASTIC_PASSWORD");


        // Not for local ElasticSearch
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        RestClientBuilder builder = RestClient.builder(
                new HttpHost(hostname, 443, "https"))
                .setHttpClientConfigCallback(new RestClientBuilder
                        .HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient
                            (HttpAsyncClientBuilder httpClientBuilder) {
                        return httpClientBuilder.setDefaultCredentialsProvider
                                (credentialsProvider);
                    }
                });
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }

    public static KafkaConsumer<String, String> createConsumer(String topic) {

//        String bootstrapServers = KAFKA_HOST + ":" + KAFKA_PORT;
        String groupId = "kafka-elasticsearch";
//        String topic = "twitter_tweets";

        // create consumer configs
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // latest, none

        // create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topic));
        return consumer;
    }
    private static JsonParser jsonParser = new JsonParser();

    private static String extractIdFromTweet(String tweetJson) {
        // gson library
        return JsonParser.parseString(tweetJson)
                .getAsJsonObject()
                .get("id_str")
                .getAsString();
    }

    public static void main(String[] args)  throws IOException {
        Logger logger = LoggerFactory.getLogger(ElasticSearchConsumer.class.getName());
        RestHighLevelClient client = createClient();

//        String jsonString = "{ \"crypto\": \"tom\" }";
        KafkaConsumer<String, String> consumer = createConsumer("twitter_tweets");

        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            Integer recordCount = records.count();
            logger.info("Received " + recordCount + " records");
            logger.info(" ++++ " + records.toString() + " ++++++++");
            BulkRequest bulkRequest = new BulkRequest();

            for (ConsumerRecord<String, String> record : records) {
                // Three strategies
                // 1. idKafkaRecord ... Kafka generic ID
                 String idKafkaRecord = "topic"+ record.topic() + "_partition_" + record.partition() + "_offset_"+ record.offset();
                logger.info("idKafkaRecord: "+idKafkaRecord);
                // HTTP GET /twitter/tweets/topictwitter_tweets_partition_2_offset_4135
                try {
                    // 2. idTwitter ... Twitter feed specific id
                    String idTwitter = extractIdFromTweet(record.value());
                    logger.info("idTwitter: "+idTwitter);

                    // where to insert data into ElasticSearch
                    IndexRequest indexRequest = new IndexRequest(
                            "twitter"  ,
                            "tweets" //,
//                            idTwitter   /// THIRD FIELD No Good
//                            idKafkaRecord // this/ is to make consumer idempotent
                    ).source(record.value(), XContentType.JSON)
                            .id(idKafkaRecord)
                            ; // idTwitter OR idKafkaRecord
                    IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

                    // 2. idElasticResp ... Elasticache Response id
                    String idElasticResp = indexResponse.getId();
                    logger.info("idElasticResp: "+idElasticResp);
                    // HTTP GET /twitter/tweets/k94853gBH4p2ivtBimUm

                    bulkRequest.add(indexRequest); // add to bulk request (takes no time)
                } catch (NullPointerException e) {
                    logger.warn("skipping  bad data: " + record.value());
                }

            }
     if (recordCount > 0) {
//         BulkResponse bulkResponses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
         logger.info("Committing offsets ...");
         consumer.commitSync();
         logger.info("Offsets have been committed");

//                IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
//                logger.info(indexResponse.getId());
         try {
             Thread.sleep(1000); // introduce small delay here ...
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
        }
        // close the client gracefully
//        client.close();
    }
}
