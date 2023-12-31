package com.sinch.sample.numbers.active;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import java.io.IOException;
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

    LOGGER.info("List");

    ActiveNumberListResponse response =
        client
            .numbers()
            .active()
            .list(
                ActiveNumberListRequestParameters.builder()
                    .setRegionCode("US")
                    .setType(NumberType.LOCAL)
                    .setPageSize(2)
                    .build());

    LOGGER.info("Response");

    response.stream()
        .peek(a -> LOGGER.info(String.format("%s: %s", a.getPhoneNumber(), a)))
        .forEach(
            a -> {
              /* just here to consume the stream*/
            });
  }
}
