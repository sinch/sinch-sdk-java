package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateTemplateRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.CreateResponse;
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
            .setName("template created from Java SDK")
            .setDescription("my description value")
            .setCreatedBy("html")
            .setTemplate("<p>{{firstname}} {{lastname}}</p>")
            .setTag("a tag value")
            .setComment("a comment value")
            .setEngine("handlebars")
            .setHeaders(
                Arrays.asList(
                    Pair.of("From", "mygrom@adress.org"), Pair.of("subject", "my subject")))
            .build();
    CreateResponse value = service.create(mailgunDomain, request);
    LOGGER.info("Response:" + value);
  }
}
