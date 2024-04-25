package com.mycompany.app;

import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.sms.models.InboundText;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoSubscribeController {

  private final SMSService smsService;
  private final AutoSubscribeService service;

  @Autowired
  public AutoSubscribeController(SMSService smsService, AutoSubscribeService service) {
    this.smsService = smsService;
    this.service = service;
  }

  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void smsDeliveryEvent(@RequestBody String body) {

    // decode the request payload
    var event = smsService.webHooks().parse(body);

    // let business layer process the request
    if (Objects.requireNonNull(event) instanceof InboundText e) {
      service.processInboundEvent(e);
    } else {
      throw new IllegalStateException("Unexpected value: " + event);
    }
  }
}
