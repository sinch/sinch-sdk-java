package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateTemplateRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Create extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public Create() throws IOException {}

  public static void main(String[] args) {
    try {
      new Create().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("Create a template");

    CreateTemplateRequest request =
        CreateTemplateRequest.builder()
            .setName(mailgunTemplateName)
            .setDescription("my description value")
            .setCreatedBy("html")
            .setTemplate("<p>{{firstname}} {{lastname}}</p>")
            .setTag("version created during template creation")
            .setComment("a comment value")
            .setHeaders(
                Arrays.asList(
                    Pair.of("From", "mygrom@adress.org"), Pair.of("subject", "my subject")))
            .build();
    Template value = service.create(mailgunDomain, request);
    LOGGER.info("Response:" + value);
  }
}
