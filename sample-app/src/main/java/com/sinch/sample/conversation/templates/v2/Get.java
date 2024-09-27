package com.sinch.sample.conversation.templates.v2;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
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

    TemplatesServiceV2 service = client.conversation().templates().v2();

    LOGGER.info("GET template");

    TemplateV2 response = service.get(conversationTemplateId);

    LOGGER.info("Response: " + response);
  }
}
