# Spring Boot Kafka Demo


## Step


**Setup Kafka Infra**

1. change to infra dir 
    ```
   cd infra
   ```
   
2. start kafka in docker compose
   ```shell
   docker compose -f docker-compose.yml up
   ```
   
3. access kafka broker use cli `docker exec -it <container_name> <command_dir>`

   + enter Kafka container
   ```shell
   docker exec -it kafka /bin/sh
   ```
   + change to bin folder `cd /opt/kafka_<version>/bin`
   ```shell
   cd opt/kafka_2.13-2.8.1/bin
   ```
   + create kafka topic
   ```shell
   kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic lea-seydoux
   ```
   + start kafka-producer console and send messages
   ```shell
   kafka-console-producer.sh --topic lea-seydoux --bootstrap-server localhost:9092
   ```
   + start kafka-consumer console and consume messages
   ```shell
   kafka-console-consumer.sh --topic  lea-seydoux --from-beginning --bootstrap-server localhost:9092
   ```

By following above steps, you can get your hands dirty with kafka producer, broker and consumer only using kafka.

In this demo, we will create standalone producer spring boot application and consumer spring boot application.

**Kafka UI Tool - Kadeck**
You can download kafka UI tool to visualize the kafka topics and messages
Link: https://www.kadeck.com/

**Kafka UI Tool - Kadeck**