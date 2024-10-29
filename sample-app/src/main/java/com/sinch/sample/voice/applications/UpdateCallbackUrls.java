package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.CallbacksUrl;
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

    ApplicationsService service = client.voice().v1().applications();

    var urls =
        Callbacks.builder()
            .setUrl(
                CallbacksUrl.builder()
                    .setPrimary(webhooksVoicePath.get())
                    .setFallback("fallback value")
                    .build())
            .build();

    LOGGER.info(
        "Update callback URLs for application key '%s': '%s'".formatted(applicationKey, urls));

    service.updateCallbackUrls(applicationKey, urls);
  }
}
