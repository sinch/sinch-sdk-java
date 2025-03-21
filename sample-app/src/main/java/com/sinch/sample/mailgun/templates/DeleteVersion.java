package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import java.io.IOException;
import java.util.logging.Logger;

public class DeleteVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(DeleteVersion.class.getName());

  public DeleteVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new DeleteVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Deleting :" + mailgunTemplateVersionName);

    service.deleteVersion(mailgunDomain, mailgunTemplateName, mailgunTemplateVersionName);
  }
}
