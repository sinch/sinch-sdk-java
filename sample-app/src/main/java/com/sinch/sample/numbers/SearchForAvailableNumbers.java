package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

public class SearchForAvailableNumbers extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(SearchForAvailableNumbers.class.getName());

  public SearchForAvailableNumbers() throws IOException {}

  public static void main(String[] args) {
    try {
      new SearchForAvailableNumbers().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("SearchForAvailableNumbers");

    int page = 1;
    AvailableNumberListResponse response =
        service.searchForAvailableNumbers(
            AvailableNumbersListQueryParameters.builder()
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
