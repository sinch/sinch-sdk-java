package com.sinch.sample.numbers.callback;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
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

    LOGGER.info("Update");

    String hmac = "HMAC value";
    CallbackConfigurationUpdateRequestParameters parameters =
        CallbackConfigurationUpdateRequestParameters.builder().setHMACSecret(hmac).build();

    CallbackConfiguration value = client.numbers().callback().update(parameters);

    LOGGER.info("Response :" + value);
  }
}
