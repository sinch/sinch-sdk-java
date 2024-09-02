package com.sinch.sample.conversation.templates.v1;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import java.io.IOException;
import java.util.logging.Logger;

public class Get extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public Get() throws IOException {}

  public static void main(String[] args) {
    try {
      new Get().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesServiceV1 service = client.conversation().templates().v1();

    LOGGER.info("GET template");

    TemplateV1 response = service.get(conversationTemplateId);

    LOGGER.info("Response: " + response);
  }
}
