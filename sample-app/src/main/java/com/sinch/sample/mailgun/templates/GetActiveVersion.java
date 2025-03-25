package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import java.io.IOException;
import java.util.logging.Logger;

public class GetActiveVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(GetActiveVersion.class.getName());

  public GetActiveVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetActiveVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Get for active version for Template: " + mailgunTemplateName);

    VersionDetails value = service.getActiveVersion(mailgunDomain, mailgunTemplateName);

    LOGGER.info("Response:" + value);
  }
}
