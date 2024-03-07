package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info(String.format("Updating application '%s'", conversationAppId));
    throw new RuntimeException("TODO");
    /*   var parameters =
        AppRequestParameters.builder()
            .setDisplayName("Updated from Java SDK")
            .setCallbackSettings(
                CallbackSettings.builder().setSecretForOverriddenCallbackUrls("foo secret").build())
            .build();
    var result = client.conversation().app().update(conversationAppId, parameters);

    LOGGER.info("Response: " + result);*/
  }
}
