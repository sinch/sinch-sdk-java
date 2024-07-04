package com.sinch.sample.webhooks.sms;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.InboundBinary;
import com.sinch.sdk.domains.sms.models.InboundText;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

  private final SinchClient sinchClient;
  private final SmsService service;
  private static final Logger LOGGER = Logger.getLogger(SmsController.class.getName());

  @Autowired
  public SmsController(SinchClient sinchClient, SmsService service) {
    this.sinchClient = sinchClient;
    this.service = service;
  }

  @PostMapping(
      value = "/SmsEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public void smsDeliveryEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    LOGGER.finest("Received body:" + body);
    LOGGER.finest("Received headers: " + headers);

    // decode the request payload
    var event = sinchClient.sms().webHooks().parse(body);

    // let business layer process the request
    switch (event) {
      case InboundBinary e -> service.processInboundEvent(e);
      case InboundText e -> service.processInboundEvent(e);
      case DeliveryReportRecipient e -> service.processDeliveryReportEvent(e);
      case DeliveryReportBatch e -> service.processDeliveryReportEvent(e);
      default -> throw new IllegalStateException("Unexpected value: " + event);
    }
  }
}
