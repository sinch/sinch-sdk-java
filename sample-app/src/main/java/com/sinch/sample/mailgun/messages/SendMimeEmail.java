package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.OverrideProperties;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class SendMimeEmail extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(SendMimeEmail.class.getName());

  public SendMimeEmail() throws IOException {}

  public static void main(String[] args) {
    try {
      new SendMimeEmail().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("Send MIME email with Mailgun to: " + mailgunTo);

    SendMimeEmailRequest parameters = createMime();

    SendEmailResponse response = service.sendInMimeFormat(mailgunDomain, parameters);

    LOGGER.info("Response: " + response);
  }

  SendMimeEmailRequest createMime() {
    String mimeBody =
        """
From: %s
Subject: SendMime Email Example
Content-Type: multipart/alternative; boundary="boundary-string"

--boundary-string
Content-Type: text/plain; charset="utf-8"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: inline

Plain text email goes here!
This is the fallback if email client does not support HTML

--boundary-string
Content-Type: text/html; charset="utf-8"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: inline

<h1>This is the HTML Section!</h1>
<p>This is what displays in most modern email clients</p>

--boundary-string--

""";

    // create a temporary file to be sent
    File tempFile;
    try {
      tempFile = File.createTempFile("sinch-sdk-java", ".txt");
      tempFile.deleteOnExit();
      try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile))) {
        out.write(String.format(mimeBody, mailgunFrom));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return SendMimeEmailRequest.builder()
        .setTo(Arrays.asList(mailgunTo))
        .setMessage(tempFile)
        .setOverrideProperties(
            OverrideProperties.builder()
                .setTestMode(false)
                .setTag(Arrays.asList("my tag 1", "my tag 2"))
                .build())
        .setCustomVariables(Arrays.asList(Pair.of("my-varkey", "var-value")))
        .setCustomHeaders(Arrays.asList(Pair.of("my-headerkey", "header-value")))
        .build();
  }
}
