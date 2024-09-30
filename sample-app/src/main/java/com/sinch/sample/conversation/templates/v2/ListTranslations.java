package com.sinch.sample.conversation.templates.v2;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

public class ListTranslations extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ListTranslations.class.getName());

  public ListTranslations() throws IOException {}

  public static void main(String[] args) {
    try {
      new ListTranslations().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesServiceV2 service = client.conversation().templates().v2();

    LOGGER.info("List translations for template: " + conversationTemplateId);

    Collection<TemplateTranslation> result = service.listTranslations(conversationTemplateId, null);

    LOGGER.info("Response: ");
    result.iterator().forEachRemaining(f -> LOGGER.info(String.format("- %s", f)));
  }
}
