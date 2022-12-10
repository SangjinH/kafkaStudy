package com.han.kafka.application.kafkaservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

  private static final String TOPIC = "exam-topic";

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    log.info("Produce message : {}", message);
    this.kafkaTemplate.send(TOPIC, message);
  }


}
