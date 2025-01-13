package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.OverrideProperties;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailHtmlInTemplateRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailHtmlInlineRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.TemplateProperties;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public class SendEmail extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(SendEmail.class.getName());

  public SendEmail() throws IOException {}

  public static void main(String[] args) {
    try {
      new SendEmail().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("Send email with Mailgun to: " + mailgunTo);

    SendEmailRequest parameters = createTextEmail();

    SendEmailResponse response = service.sendEmail(mailgunDomain, parameters);

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

    SendEmailRequest inline =
        SendEmailHtmlInlineRequest.builder()
            .setFrom(mailgunFrom)
            .setTo(Arrays.asList(mailgunTo))
            .setText("\uD83D\uDCE7 Text sent with Sinch SDK Java to %recipient.nickname%")
            .setHtml("&#128231; HTML sent with <bold>Sinch SDK Java</bold> to %recipient.nickname%")
            .setAttachment(Arrays.asList(tempFile, tempFile2))
            .setSubject("\uD83D\uDCE7 Hello from Sinch SDK Java (inline)")
            .setOverrideProperties(
                OverrideProperties.builder()
                    .setTag(Arrays.asList("my tag 1", "my tag 2"))
                    .setTrackingOpens(true)
                    .setDeliveryTime(Instant.now().plus(10, ChronoUnit.SECONDS))
                    .build())
            .setRecipientVariables(
                Collections.singletonMap(mailgunTo, Arrays.asList(Pair.of("nickname", "John"))))
            .setCustomVariables(
                Arrays.asList(
                    Pair.of("my-varkey", "var-value1"), Pair.of("my-varkey", "var-value2")))
            .setCustomHeaders(
                Arrays.asList(
                    Pair.of("my-headerkey", "header-value1"),
                    Pair.of("my-headerkey", "header-value2")))
            .build();

    SendEmailRequest inTemplate =
        SendEmailHtmlInTemplateRequest.builder()
            .setFrom(mailgunFrom)
            .setTo(Arrays.asList(mailgunTo))
            .setText("\uD83D\uDCE7 Text sent with Sinch SDK Java to %recipient.nickname%")
            .setAttachment(Arrays.asList(tempFile, tempFile2))
            .setSubject("\uD83D\uDCE7 Hello from Sinch SDK Java  (template)")
            .setOverrideProperties(
                OverrideProperties.builder()
                    .setTag(Arrays.asList("my tag 1", "my tag 2"))
                    .setTrackingOpens(true)
                    .setDeliveryTime(Instant.now().plus(10, ChronoUnit.SECONDS))
                    .build())
            .setRecipientVariables(
                Collections.singletonMap(mailgunTo, Arrays.asList(Pair.of("nickname", "John"))))
            .setCustomVariables(
                Arrays.asList(
                    Pair.of("my-varkey", "var-value1"), Pair.of("my-varkey", "var-value2")))
            .setCustomHeaders(
                Arrays.asList(
                    Pair.of("my-headerkey", "header-value1"),
                    Pair.of("my-headerkey", "header-value2")))
            .setTemplate("template.test")
            .setTemplateProperties(
                TemplateProperties.builder()
                    .setVariables(
                        "{\"title\": \"Sinch SDK Java\", \"ident\":{\"name\": false }, \"body\":"
                            + " \"Sending messages with templates\"}")
                    .build())
            .build();

    return inTemplate;
  }
}
