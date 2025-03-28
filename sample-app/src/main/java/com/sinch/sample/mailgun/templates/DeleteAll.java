package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import java.io.IOException;
import java.util.logging.Logger;

public class DeleteAll extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(DeleteAll.class.getName());

  public DeleteAll() throws IOException {}

  public static void main(String[] args) {
    try {
      new DeleteAll().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Deleting all templates from domain: " + mailgunDomain);

    service.deleteAll(mailgunDomain);
  }
}
