package com.mycompany.app.sms;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import java.util.Collections;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("SMSServerBusinessLogic")
public class ServerBusinessLogic {

  private final BatchesService batches;

  public ServerBusinessLogic(SinchClient sinchClient) {
    this.batches = sinchClient.sms().v1().batches();
  }

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public void processInboundEvent(TextMessage event) {

    LOGGER.info("Handle event: " + event);

    TextRequest smsRequest =
        TextRequest.builder()
            .setTo(Collections.singletonList(event.getFrom()))
            .setBody("You sent: " + event.getBody())
            .setFrom(event.getTo())
            .build();

    LOGGER.info("Replying with: " + smsRequest);

    BatchResponse response = batches.send(smsRequest);

    LOGGER.info("Response: " + response);
  }
}
