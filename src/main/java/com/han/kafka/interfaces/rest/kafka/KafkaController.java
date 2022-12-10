package com.han.kafka.interfaces.rest.kafka;

import com.han.kafka.application.kafkaservice.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaProducer producer;

  @PostMapping
  @ResponseBody
  public String sendMessage(@RequestParam String message) {
    log.info("Message : {}", message);
    this.producer.sendMessage(message);

    return "success";
  }

}
