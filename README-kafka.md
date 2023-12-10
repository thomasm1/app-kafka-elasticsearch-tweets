3 forms:  1) Kafka Java API, 2) Kafka connect [source and Sink], 3) Kafka REST Proxy 

#### PROD Instructions after install 
##### 1.)
```
./bin/windows/zookeeper-server-start.bat config/zookeeper.properties  
./bin/windows/kafka-server-start.bat config/server.properties  
```

##### 2.) TwitterProducer (TwitterMessageQueue + TwitterProducer)
###### Connects to Twitter API, polls for "crypto" tweets, Kafka produces to topic "twitter_tweets"
##### 3.) ElasticSearchConsumer ( )
###### Connects to ElasticSearch (bonsai.io API), consumes topic "twitter_tweets", 
######          // HTTP GET /twitter/tweets/k94853gBH4p2ivtBimUm OR 
######          // HTTP GET  /twitter/tweets/topictwitter_tweets_partition_2_offset_4135

#### KAFKA INSTALL 
Java 8, Kafka 2.0, extracted with winRAR
```
C:\kafka_2.12-2.0.0>bin\windows\kafka-topics.bat

 1:  Add into path
 2:  >kafka-topics.bat
 3:  mkdir data in c:\kafka_2.1.2-2.5.0  &&  mkdir kafka and zookeeper in data dir.
 4:   in kafka/config/zookeeper.properties ... REPLACE dataDir=tmp ...
 5:  dataDir=C:/kafka_2.12-2.0.0/data/zookeeper 
 6 >zookeeper-server-start.bat config\zookeeper.properties
 7>  EXPECT INFO binding to port 0.0.0.0/0.0.0.0:2181 
 8> from server.properties  find:   log.dirs=/tmp/kafka-logs
 9: REPLACE with ...  log.dirs=C:/kafka_2.12-2.0.0/data/kafka
10:  From c:\kafka_X  directory::  kafka-server-start.bat config\server.properties
11: From config/server.properties ... replace num.partitions=1 to =3
```
#### KAFKA START - from kafka dir 
```
./bin/windows/zookeeper-server-start.bat config/zookeeper.properties
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

./bin/windows/kafka-server-start.bat config/server.properties
bin\windows\kafka-server-start.bat config\server.properties

```
#### KAFKA GRACEFUL STOP 
```
./bin/windows/kafka-server-stop.bat  
./bin/windows/zookeeper-server-stop.bat 

```
#### Create Topic
```
./bin/windows/kafka-topics.bat --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3 --replication-factor 1
./bin/windows/kafka-topics.bat --zookeeper 127.0.0.1:2181 --list
kafka-topics.bat --zookeeper 127.0.0.1:2181 --topic first_topic --describe
```
#### Producer & Consumer
```
./bin/windows/kafka-console-producer.bat --broker-list 127.0.0.1:9092 --topic first_topic
./bin/windows/kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning

./bin/windows/kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-app
```
#### Groups
```
./bin/windows/kafka-consumer-groups.bat --bootstrap-server localhost:9092 --list
./bin/windows/kafka-consumer-groups.bat --bootstrap-server localhost:9092 --describe --group my-first-app
./bin/windows/kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group my-first-app --reset-offsets --to-earliest --execute --topic first_topic
```
#### With KEYS
```
kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic --property parse.key=true --property key.separator=,
> key,value
> another key,another value
 
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning --property print.key=true --property key.separator=,
```
#### KAFKA GUI  
```
download Conduktor here: https://www.conduktor.io/
Conduktor allows you to perform all the administrative tasks on Kafka (such as creating topics, partitions, etc), as well as produce and consume, all from within a desktop application that should work on Windows, Mac, and Linux.
Documentation: https://www.conduktor.io/docs
The FAQ for installation issues (at the bottom of the page): https://www.conduktor.io/download
Finally, follow @GetConduktor on Twitter to get the latest updates!
```
#### KAFKA --  KafkaCat as a replacement for Kafka CLI
```
KafkaCat (https://github.com/edenhill/kafkacat) is an open-source alternative to using the Kafka CLI, created by Magnus Edenhill.
KafkaCat recommend reading: https://medium.com/@coderunner/debugging-with-kafkacat-df7851d21968
```
#### Kafka connect confluent
KAFKA Connectors
```
I. Databases==>mongoDB, Cassandra, Oracle-golden-gate, JDBC, Amazon-dynamo-db
II. Analytics==>Vertica, Elastic, MixPanel
III. Datastore/File Store==>Hadoop, AmazonS3, Apache-ignite, syslog-ng
IV. Applications/Other==>GitHub, SyncSort, Vertica, #irc, Bloomberg, Twitter, Striim, Solr, Attunity
 
https://www.confluent.io/hub/
https://www.confluent.io/hub/#twitter 
https://github.com/jcustenborder/kafka-connect-twitter/releases

./bin/windows/kafka-topics.bat --zookeeper 127.0.0.1:2181 --create --topic twitter_status_connect --partitions 3 --replication-factor 1

./bin/windows/kafka-topics.bat --zookeeper 127.0.0.1:2181 --create --topic twitter_deletes_connect --partitions 3 --replication-factor 1

./bin/windows/kafka-topics.bat --zookeeper 127.0.0.1:2181 --list

./bin/windows/kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic twitter_status_connect --from-beginning

./connect-standalone.bat connect-standalone.properties twitter.properties
```
#### Kafka Streams
https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams

```sh

kafka-topics --zookeeper 127.0.0.1:2181 --topic important_tweets --create --partitions 3 --replication-factor 1

kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic important_tweets --from-beginning
```

##### Example JSON FROM TWITTERS STREAM:
{
  "created_at": "Sat Apr 17 21:30:02 +0000 2021",
  "id": 1383533234814738434,
  "id_str": "1383533234814738434",
  "text": "Bitcoin subiu!\n\ud83c\udde7\ud83c\uddf7\ud83d\udcb5 BTC\/BRL R$ 344,595.59\n\ud83c\uddfa\ud83c\uddf8\ud83d\udcb5 BTC\/USD $ 61,437.88\nVaria\u00e7\u00e3o 24h(%): -0.84",
  "source": "\u003ca href=\"https:\/\/donthaveaurl.com\" rel=\"nofollow\"\u003eSeuBitcoinBot\u003c\/a\u003e",
  "truncated": false,
  "in_reply_to_status_id": null,
  "in_reply_to_status_id_str": null,
  "in_reply_to_user_id": null,
  "in_reply_to_user_id_str": null,
  "in_reply_to_screen_name": null,
  "user": {
    "id": 1238318943942651904,
    "id_str": "1238318943942651904",
    "name": "Seu Bitcoin",
    "screen_name": "SeuBitcoin",
    "location": null,
    "url": null,
    "description": "Tenha acesso ao pre\u00e7o do Bitcoin sem sair da sua rede social!",
    "translator_type": "none",
    "protected": false,
    "verified": false,
    "followers_count": 115,
    "friends_count": 8,
    "listed_count": 2,
    "favourites_count": 3,
    "statuses_count": 57250,
    "created_at": "Fri Mar 13 04:20:36 +0000 2020",
    "utc_offset": null,
    "time_zone": null,
    "geo_enabled": false,
    "lang": null,
    "contributors_enabled": false,
    "is_translator": false,
    "profile_background_color": "F5F8FA",
    "profile_background_image_url": "",
    "profile_background_image_url_https": "",
    "profile_background_tile": false,
    "profile_link_color": "1DA1F2",
    "profile_sidebar_border_color": "C0DEED",
    "profile_sidebar_fill_color": "DDEEF6",
    "profile_text_color": "333333",
    "profile_use_background_image": true,
    "profile_image_url": "http:\/\/pbs.twimg.com\/profile_images\/1238319344251293696\/g2YCxm3c_normal.jpg",
    "profile_image_url_https": "https:\/\/pbs.twimg.com\/profile_images\/1238319344251293696\/g2YCxm3c_normal.jpg",
    "profile_banner_url": "https:\/\/pbs.twimg.com\/profile_banners\/1238318943942651904\/1584074187",
    "default_profile": true,
    "default_profile_image": false,
    "following": null,
    "follow_request_sent": null,
    "notifications": null,
    "withheld_in_countries": []
  },
  "geo": null,
  "coordinates": null,
  "place": null,
  "contributors": null,
  "is_quote_status": false,
  "quote_count": 0,
  "reply_count": 0,
  "retweet_count": 0,
  "favorite_count": 0,
  "entities": {
    "hashtags": [],
    "urls": [],
    "user_mentions": [],
    "symbols": []
  },
  "favorited": false,
  "retweeted": false,
  "filter_level": "low",
  "lang": "fi",
  "timestamp_ms": "1618695002641"
}