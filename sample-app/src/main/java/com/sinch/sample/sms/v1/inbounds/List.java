package com.sinch.sample.sms.v1.inbounds;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.InboundsService;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import java.io.IOException;
import java.time.Instant;
import java.time.Period;
import java.util.logging.Logger;

public class List extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    InboundsService service = client.sms().v1().inbounds();

    LOGGER.info("List inbounds");

    ListInboundMessagesQueryParameters queryParameters =
        ListInboundMessagesQueryParameters.builder()
            .setPageSize(1)
            .setStartDate(Instant.now().minus(Period.ofWeeks(3)))
            .build();

    LOGGER.info("Response:");
    service.list(queryParameters).iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
