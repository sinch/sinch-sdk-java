package com.sinch.sample.conversation.templates.v1;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import java.io.IOException;
import java.util.Arrays;
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

    TemplatesServiceV1 service = client.conversation().templates().v1();

    TemplateV1 request =
        TemplateV1.builder()
            .setDescription("Updated description from V1 API")
            .setDefaultTranslation("fr-FR")
            .setTranslations(
                Arrays.asList(TemplateTranslation.builder().setLanguageCode("fr-FR").build()))
            .build();

    LOGGER.info("Update template: " + request);
    TemplateV1 result = service.update(conversationTemplateId, request);
    LOGGER.info("Response: " + result);
  }
}
