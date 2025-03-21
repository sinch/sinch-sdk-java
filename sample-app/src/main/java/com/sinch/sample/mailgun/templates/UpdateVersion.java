package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.UpdateVersionRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class UpdateVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(UpdateVersion.class.getName());

  public UpdateVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new UpdateVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Update a template's version");

    UpdateVersionRequest request =
        UpdateVersionRequest.builder()
            .setTemplate("<p>{{firstname}} {{lastname}}</p>")
            .setComment("a comment value modifed")
            .setActive(false)
            .setHeaders(
                Arrays.asList(
                    Pair.of("From", "edited@adress.org"), Pair.of("subject", "my subject")))
            .build();
    service.updateVersion(mailgunDomain, mailgunTemplateName, "a tag value", request);
  }
}
