package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class GetCallbackUrls extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetCallbackUrls.class.getName());

  public GetCallbackUrls() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetCallbackUrls().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get callback URLs for application key '%s'".formatted(applicationKey));

    var response = client.voice().applications().getCallbackUrls(applicationKey);

    LOGGER.info("Response: " + response);
  }
}
