# Springboot-kafka-mongodb
Spring boot application(producer/consumer) using kafka and monodb


To start ZooKeeper you need a configuration file. Here is a sample, create it in conf/zoo.cfg:-->
tickTime=2000
dataDir=C:/logs/zookeeper
clientPort=2181

To start ZooKeeper you need to run below command:-->
./zkServer.sh start

To start the Kafka broker service:-->
./bin/kafka-server-start.sh ./config/server.properties

To create topic:-->
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic myTopic

To list the topic:-->
./kafka-topics.sh --list --zookeeper localhost:2181

To produce messages:-->
./kafka-console-producer.sh --broker-list localhost:9092 --topic myTopic

To Consume messages:-->
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myTopic --from-beginning

Example data:-

{
  "id": 1,
  "name": "Rajesh",
  "dept": "Software",
  "salary": 15000.0
}
