package com.sinch.sample.conversation.templates.v1;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import java.io.IOException;
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

    TemplatesServiceV1 service = client.conversation().templates().v1();

    LOGGER.info("List templates V1");

    var result = service.list();

    LOGGER.info("Response: ");
    result.iterator().forEachRemaining(f -> LOGGER.info(String.format("- %s: %s", f.getId(), f)));
  }
}
