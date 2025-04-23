package com.sinch.sample.mailgun.templates;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.ListVersionsQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.ListVersionsResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ListVersions extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(ListVersions.class.getName());

  public ListVersions() throws IOException {}

  public static void main(String[] args) {
    try {
      new ListVersions().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    TemplatesService service = client.mailgun().v1().templates();

    LOGGER.info("List versions");

    ListVersionsResponse response =
        service.listVersions(
            mailgunDomain,
            mailgunTemplateName,
            ListVersionsQueryParameters.builder().setLimit(2).build());

    response.stream()
        .peek(a -> LOGGER.info(String.format("- '%s': %s", a.getTag(), a)))
        .forEach(
            a -> {
              /* just here to consume the stream*/
            });
  }
}
