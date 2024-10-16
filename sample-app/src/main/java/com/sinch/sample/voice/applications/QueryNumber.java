package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import java.io.IOException;
import java.util.logging.Logger;

public class QueryNumber extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(QueryNumber.class.getName());

  public QueryNumber() throws IOException {}

  public static void main(String[] args) {
    try {
      new QueryNumber().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ApplicationsService service = client.voice().v1().applications();

    LOGGER.info("Query number '%s'".formatted(virtualPhoneNumber));

    var response = service.queryNumber(virtualPhoneNumber);

    LOGGER.info("Response: " + response);
  }
}
