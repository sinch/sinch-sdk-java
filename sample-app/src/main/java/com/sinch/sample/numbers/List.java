package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse;
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

    NumbersService service = client.numbers().v1();

    LOGGER.info("List");

    ActiveNumberListResponse response =
        service.list(
            ActiveNumbersListQueryParameters.builder()
                .setRegionCode("US")
                .setType(NumberType.LOCAL)
                .setPageSize(1)
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
