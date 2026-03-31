package com.mycompany.app.numbers;

import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("NumbersServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public void numbersEvent(NumberSinchEvent event) {

    LOGGER.info("Handle event: " + event);
  }
}
