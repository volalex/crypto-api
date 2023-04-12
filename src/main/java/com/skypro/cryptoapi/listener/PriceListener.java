package com.skypro.cryptoapi.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypro.cryptoapi.service.PriceService;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PriceListener {

  private final PriceService priceService;
  private final ObjectMapper objectMapper;


  private static final Logger LOG = LoggerFactory.getLogger(PriceListener.class);

  public PriceListener(PriceService priceService, ObjectMapper objectMapper) {
    this.priceService = priceService;
    this.objectMapper = objectMapper;
  }

  @RabbitListener(queues = "price-message")
  public void listenMessage(@Payload String message) {
    try {
      var price = objectMapper.reader().readValue(message, PriceMessage.class);
      priceService.savePrice(price);
    } catch (IOException e) {
      LOG.info("Failed to convert price message to json", e);
    }
  }
}
