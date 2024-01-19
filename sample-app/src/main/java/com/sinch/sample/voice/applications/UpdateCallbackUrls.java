package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.ApplicationURL;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import java.io.IOException;
import java.util.logging.Logger;

public class UpdateCallbackUrls extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(UpdateCallbackUrls.class.getName());

  public UpdateCallbackUrls() throws IOException {}

  public static void main(String[] args) {
    try {
      new UpdateCallbackUrls().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    var urls =
        CallbackUrls.builder()
            .setUrl(
                ApplicationURL.builder()
                    .setPrimary("primary value")
                    .setFallback("fallback value")
                    .build())
            .build();
    LOGGER.info(
        "Update callback URLs for application key '%s': '%s'".formatted(applicationKey, urls));

    client.voice().applications().updateCallbackUrls(applicationKey, urls);
  }
}
