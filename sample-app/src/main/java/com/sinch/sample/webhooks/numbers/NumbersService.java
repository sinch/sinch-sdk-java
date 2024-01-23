package com.sinch.sample.webhooks.numbers;

import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class NumbersService {

  private static final Logger LOGGER = Logger.getLogger(NumbersService.class.getName());

  public void numbersEvent(EventNotification event) {

    LOGGER.info("Handle event :" + event);
  }
}
