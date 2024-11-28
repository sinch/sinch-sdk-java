package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Send extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public Send() throws IOException {}

  public static void main(String[] args) {
    try {
      new Send().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("Send message with Mailgun to: " + mailgunTo);

    SendEmailRequest parameters = createTextEmail();

    SendEmailResponse response = service.send(mailgunDomain, parameters);

    LOGGER.info("Response: " + response);
  }

  SendEmailRequest createTextEmail() {

    // create a temporary file to be sent
    File tempFile;
    try {
      tempFile = File.createTempFile("sinch-sdk-java", ".txt");
      tempFile.deleteOnExit();
      try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile))) {
        out.write("\uD83D\uDCE7 Sample content \uD83D\uDCE7");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    File tempFile2;
    try {
      tempFile2 = File.createTempFile("sinch-sdk-java", ".txt");
      tempFile2.deleteOnExit();
      try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile2))) {
        out.write("\uD83D\uDCE7 Sample content 2 \uD83D\uDCE7");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return SendEmailRequest.builder()
        .setFrom(mailgunFrom)
        .setTo(Arrays.asList(mailgunTo, "jean-pierre.portier@mailgun.com"))
        .setText("\uD83D\uDCE7 Text sent with Sinch SDK Java")
        .setHtml("&#128231; HTML sent with <bold>Sinch SDK Java</bold>")
        .setAttachment(Arrays.asList(tempFile, tempFile2))
        .setSubject("\uD83D\uDCE7 Hello from Sinch SDK Java")
        .setTag(Arrays.asList("my tag 1", "my tag 2"))
        // .setTestMode(TestMode.YES)
        .build();
  }
}