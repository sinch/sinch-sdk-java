package com.sinch.sample.numbers.callback;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
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

    CallbackConfigurationService service = client.numbers().v1().callbackConfiguration();

    LOGGER.info("Update");

    String hmac = "HMAC value";
    CallbackConfigurationUpdateRequest parameters =
        CallbackConfigurationUpdateRequest.builder().setHmacSecret(hmac).build();

    CallbackConfigurationResponse value = service.update(parameters);

    LOGGER.info("Response :" + value);
  }
}
