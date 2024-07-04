package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.AvailableNumberService;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumberListResponse;
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

    AvailableNumberService service = client.numbers().v1().available();

    LOGGER.info("List");

    int page = 1;
    AvailableNumberListResponse response =
        service.list(
            AvailableNumberListRequest.builder()
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
