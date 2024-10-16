package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
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

    ApplicationsService service = client.voice().v1().applications();

    LOGGER.info("Get callback URLs for application key '%s'".formatted(applicationKey));

    var response = service.getCallbackUrls(applicationKey);

    LOGGER.info("Response: " + response);
  }
}
