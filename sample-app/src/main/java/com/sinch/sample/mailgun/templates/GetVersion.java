package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Version;
import java.io.IOException;
import java.util.logging.Logger;

public class GetVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(GetVersion.class.getName());

  public GetVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Get for :" + mailgunTemplateName);

    Version value =
        service.getVersion(mailgunDomain, mailgunTemplateName, mailgunTemplateVersionName);

    LOGGER.info("Response:" + value);
  }
}
