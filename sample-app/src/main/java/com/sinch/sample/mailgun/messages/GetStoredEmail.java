package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class GetStoredEmail extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetStoredEmail.class.getName());

  public GetStoredEmail() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetStoredEmail().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    String storageKey = "value";
    LOGGER.info("Get stored email with storageKey: " + storageKey);

    GetStoredEmailResponse response = service.getStoredEmail(mailgunDomain, storageKey);

    LOGGER.info("Response: " + response);
  }
}
