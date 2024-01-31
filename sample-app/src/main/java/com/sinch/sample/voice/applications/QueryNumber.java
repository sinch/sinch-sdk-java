package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.models.E164PhoneNumber;
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

    LOGGER.info("Query number '%s'".formatted(phoneNumber));

    var response = client.voice().applications().queryNumber(E164PhoneNumber.valueOf(phoneNumber));

    LOGGER.info("Response: " + response);
  }
}
