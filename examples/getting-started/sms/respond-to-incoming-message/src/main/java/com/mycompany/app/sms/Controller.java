package com.mycompany.app.sms;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.SinchEventsService;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("SMS")
public class Controller {

  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = "/SmsSinchEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> smsDeliveryEvent(@RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.sms().v1().sinchEvents();

    // decode the request payload
    SmsSinchEvent event = sinchEvents.parseEvent(body);

    // let business layer process the request
    switch (event) {
      case TextMessage e -> serverBusinessLogic.processInboundEvent(e);
      default -> throw new IllegalStateException("Unexpected value: " + event);
    }

    return ResponseEntity.ok().build();
  }
}
