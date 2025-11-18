package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.ResendRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class ReSend extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ReSend.class.getName());

  public ReSend() throws IOException {}

  public static void main(String[] args) {
    try {
      new ReSend().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("ReSend email with Mailgun to: " + mailgunTo);

    String storageKey = "storage key value";

    ResendRequest parameters = ResendRequest.builder().setTo(Arrays.asList(mailgunTo)).build();

    SendEmailResponse response = service.resend(mailgunDomain, storageKey, parameters);

    LOGGER.info("Response: " + response);
  }
}
