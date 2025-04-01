package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CopyVersionQueryParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class CopyVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(CopyVersion.class.getName());

  public CopyVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new CopyVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Copy a template's version");

    CopyVersionQueryParameters request =
        CopyVersionQueryParameters.builder().setComment("a comment value from copy").build();

    VersionDetails value =
        service.copyVersion(
            mailgunDomain, mailgunTemplateName, mailgunTemplateVersionName, "(cloned)", request);

    LOGGER.info("Response:" + value);
  }
}
