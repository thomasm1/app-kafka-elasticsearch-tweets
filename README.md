3 forms:  1) Kafka Java API, 2) Kafka connect [source and Sink], 3) Kafka REST Proxy 

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

./bin/windows/kafka-server-start.bat config/server.properties
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