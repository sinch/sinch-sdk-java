package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
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

    try {
      LOGGER.info("List with error");
      page = 1;
      response =
          client
              .numbers()
              .available()
              .list(
                  AvailableNumberListAllRequestParameters.builder()
                      .setRegionCode("SE")
                      // this will throw an error but from server side as an invalid parameter: we
                      // can pass new values (or private)
                      .setType(NumberType.from("foo"))
                      .setNumberPattern(
                          NumberPattern.builder()
                              .setPattern("93652")
                              .setSearchPattern(SearchPattern.CONTAINS)
                              .build())
                      .setCapabilities(Collections.singletonList(Capability.SMS))
                      .setSize(3)
                      .build());
      LOGGER.info(String.format("Response (page %d): %s", page, response));

      while (response.hasNextPage()) {
        response = response.nextPage();
        page++;
        LOGGER.info(String.format("Response (page %d): %s", page, response));
      }

    } catch (ApiException e) {
      LOGGER.severe("Error: " + e);
    }
  }
}
