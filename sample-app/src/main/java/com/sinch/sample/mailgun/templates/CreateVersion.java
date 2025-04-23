package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateVersionRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class CreateVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(CreateVersion.class.getName());

  public CreateVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new CreateVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Create a template's version");

    CreateVersionRequest request =
        CreateVersionRequest.builder()
            .setTemplate("<p>{{firstname}} {{lastname}}</p>")
            .setTag(mailgunTemplateVersionName)
            .setComment("a comment value")
            .setActive(true)
            .setHeaders(
                Arrays.asList(
                    Pair.of("From", "mygrom@adress.org"), Pair.of("subject", "my subject")))
            .build();
    VersionDetails value = service.createVersion(mailgunDomain, mailgunTemplateName, request);
    LOGGER.info("Response:" + value);
  }
}
