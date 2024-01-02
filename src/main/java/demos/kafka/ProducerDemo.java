package demos.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class ProducerDemo {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        log.info("I am a Kafka Producer !");

        // create Producer Properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "https://cunning-peacock-10479-us1-kafka.upstash.io:9092");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"Y3VubmluZy1wZWFjb2NrLTEwNDc5JAwOgexjmV_mDGOy3xGhpFBzqTAYk7n6i_8\" password=\"YzAzOWUxY2MtZjZkYS00NGY1LTg4NzktMTA5YzI2NjVkZTQ3\";");

        // set producer properties
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // create a Producer Record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java", "hello world please");

        // send data
        producer.send(producerRecord);

        // tell the producer to send all data and block until done -- synchronous
        producer.flush();

        // close the producer
        producer.close();
    }
}
