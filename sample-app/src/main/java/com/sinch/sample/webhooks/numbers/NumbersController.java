package com.sinch.sample.webhooks.numbers;

import com.sinch.sdk.SinchClient;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumbersController {

  private final SinchClient sinchClient;
  private final NumbersService service;
  private static final Logger LOGGER = Logger.getLogger(NumbersController.class.getName());

  @Autowired
  public NumbersController(SinchClient sinchClient, NumbersService service) {
    this.sinchClient = sinchClient;
    this.service = service;
  }

  @PostMapping(
      value = "/NumbersEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public void NumbersEvent(@RequestHeader Map<String, String> headers, @RequestBody String body) {

    LOGGER.finest("Received body:" + body);
    LOGGER.finest("Received headers: " + headers);

    // decode the request payload
    var event = sinchClient.numbers().webhooks().unserializeEventNotification(body);

    // let business layer process the request
    service.numbersEvent(event);
  }
}
