package com.sinch.sample.conversation.templates.v1;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import java.io.IOException;
import java.util.logging.Logger;

public class Delete extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Delete.class.getName());

  public Delete() throws IOException {}

  public static void main(String[] args) {
    try {
      new Delete().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesServiceV1 service = client.conversation().templates().v1();

    LOGGER.info("Deleting template: " + conversationTemplateId);

    service.delete(conversationTemplateId);

    LOGGER.info("Done");
  }
}