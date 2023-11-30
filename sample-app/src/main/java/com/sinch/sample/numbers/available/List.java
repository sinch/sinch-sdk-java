package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import java.io.IOException;
import java.util.Collections;
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

    int page = 1;
    AvailableNumberListResponse response =
        client
            .numbers()
            .available()
            .list(
                AvailableNumberListAllRequestParameters.builder()
                    .setRegionCode("US")
                    .setType(NumberType.LOCAL)
                    .setCapabilities(Collections.singletonList(Capability.from("SMS")))
                    .build());
    LOGGER.info(String.format("Response (page %d): %s", page, response));

    while (response.hasNextPage()) {
      response = response.nextPage();
      page++;
      LOGGER.info(String.format("Response (page %d): %s", page, response));
    }
  }
}
