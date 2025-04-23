package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.ListTemplatesQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.ListTemplatesResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class List extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("List templates");

    ListTemplatesResponse response =
        service.list(mailgunDomain, ListTemplatesQueryParameters.builder().setLimit(2).build());

    response.stream()
        .peek(a -> LOGGER.info(String.format("- '%s': %s", a.getName(), a)))
        .forEach(
            a -> {
              /* just here to consume the stream*/
            });
  }
}
