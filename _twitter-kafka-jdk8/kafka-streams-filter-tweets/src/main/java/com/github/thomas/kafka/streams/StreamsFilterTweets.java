package com.github.thomas.kafka.streams;

import com.google.gson.JsonParser;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class StreamsFilterTweets {
    private static String KAFKA_HOST = System.getenv("KAFKA_HOST");
    private static String KAFKA_PORT = System.getenv("KAFKA_PORT");
    public static void main(String[] args) {
        // create properties
        Properties properties = new Properties();
        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_HOST +":"+ KAFKA_PORT);
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "thomas-kafka-streams");
        properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());

        // create topology
        StreamsBuilder streamsBuilder = new StreamsBuilder();

        // input topic
//        KStream<String, String> inputTopic = streamsBuilder.stream("twitter_topics");
        KStream<String, String> inputTopic = streamsBuilder.stream("twitter_tweets");
        KStream<String, String> filteredStream = inputTopic.filter(
                (k, jsonTweet) -> extractUserFollowersInTweet(jsonTweet) > 1000

                // filter for tweets which have user with >1000 followers
        );

        // build topology
        KafkaStreams kafkaStreams = new KafkaStreams(
                streamsBuilder.build(),
                properties
        );

        // start streams application
        kafkaStreams.start();
    }
    private static JsonParser jsonParser = new JsonParser();

    private static Integer extractUserFollowersInTweet(String tweetJson) {
        // gson library
        try {
            return jsonParser.parse(tweetJson)
                    .getAsJsonObject()
                    .get("user")
                    .getAsJsonObject()
                    .get("followers_count")
                    .getAsInt();
        } catch (NullPointerException e) {
            return 0;
        }
    }

}
