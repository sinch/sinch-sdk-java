package com.sinch.sample.numbers.regions;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import java.io.IOException;
import java.util.Arrays;
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

    AvailableRegionService service = client.numbers().v1().regions();

    LOGGER.info("List");
    int page = 1;

    AvailableRegionListResponse response =
        service.list(
            AvailableRegionListRequest.builder()
                .setTypes(Arrays.asList(NumberType.MOBILE, NumberType.LOCAL))
                .build());

    LOGGER.info(String.format("Response (page %d): %s", page, response));

    while (response.hasNextPage()) {
      response = response.nextPage();
      page++;
      LOGGER.info(String.format("Response (page %d): %s", page, response));
    }
  }
}
