package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.GetTemplateQueryParameters;
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

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Get for :" + mailgunTemplateName);

    Template value =
        service.get(
            mailgunDomain,
            mailgunTemplateName,
            GetTemplateQueryParameters.builder().setActive(true).build());

    LOGGER.info("Response:" + value);
  }
}
