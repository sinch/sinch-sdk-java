package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.UpdateResponse;
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

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Delete a template");

    UpdateResponse value = service.delete(mailgunDomain, "template created from Java SDK");
    LOGGER.info("Response:" + value);
  }
}
