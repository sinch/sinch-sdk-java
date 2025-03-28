package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateTemplateRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateVersionRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class CreateWithActiveVersion extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(CreateWithActiveVersion.class.getName());

  public CreateWithActiveVersion() throws IOException {}

  public static void main(String[] args) {
    try {
      new CreateWithActiveVersion().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Create a template with an active version");

    CreateTemplateRequest templateParameters =
        CreateTemplateRequest.builder()
            .setName(mailgunTemplateName)
            .setDescription("my description value")
            .setCreatedBy("html")
            .build();

    CreateVersionRequest versionParameters =
        CreateVersionRequest.builder()
            .setTemplate("<p>{{firstname}} {{lastname}}</p>")
            .setTag(mailgunTemplateVersionName)
            .setComment("a comment value")
            .setHeaders(
                Arrays.asList(
                    Pair.of("From", "mygrom@adress.org"), Pair.of("subject", "my subject")))
            .build();

    Pair<Template, VersionDetails> response =
        service.createWithActiveVersion(mailgunDomain, templateParameters, versionParameters);
    LOGGER.info("Response:" + response);
  }
}
