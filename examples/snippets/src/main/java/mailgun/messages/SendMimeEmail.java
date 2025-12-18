/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package mailgun.messages;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunRegion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import utils.Settings;

public class SendMimeEmail {

  private static final Logger LOGGER = Logger.getLogger(SendMimeEmail.class.getName());

  public static void main(String[] args) throws IOException {

    String mailgunApiKey = Settings.getMailgunApiKey().orElse("MY_MAILGUN_API_KEY");
    String mailgunRegion = Settings.getMailgunRegion().orElse("MY_MAILGUN_REGION");

    String mailgunDomain = "A_MAILGUN_DOMAIN";
    String recipient = "A_RECIPIENT_EMAIL_ADDRESS";
    String from = "A_FROM_EMAIL_ADDRESS";

    Configuration configuration =
        Configuration.builder()
            .setMailgunApiKey(mailgunApiKey)
            .setMailgunRegion(MailgunRegion.from(mailgunRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    EmailsService emailsService = client.mailgun().v1().emails();

    LOGGER.info(String.format("Send MIME email to '%s'", recipient));

    SendMimeEmailRequest request = createMime(recipient, from);

    SendEmailResponse response = emailsService.sendMimeEmail(mailgunDomain, request);

    LOGGER.info("Response: " + response);
  }

  static SendMimeEmailRequest createMime(String recipient, String from) throws IOException {
    String mimeBody =
        "From: %s\n"
            + "Subject: SendMime Email sent from Sinch Java SDK snippet\n"
            + "Content-Type: multipart/alternative; boundary=\"boundary-string\"\n"
            + "\n"
            + "--boundary-string\n"
            + "Content-Type: text/plain; charset=\"utf-8\"\n"
            + "Content-Transfer-Encoding: quoted-printable\n"
            + "Content-Disposition: inline\n"
            + "\n"
            + "Plain text email goes here!\n"
            + "This is the fallback if email client does not support HTML\n"
            + "\n"
            + "--boundary-string\n"
            + "Content-Type: text/html; charset=\"utf-8\"\n"
            + "Content-Transfer-Encoding: quoted-printable\n"
            + "Content-Disposition: inline\n"
            + "\n"
            + "<h1>This is the HTML Section!</h1>\n"
            + "<p>This is what displays in most modern email clients</p>\n"
            + "\n"
            + "--boundary-string--\n"
            + "\n"
            + "\n";

    File tempFile;
    tempFile = File.createTempFile("sinch-sdk-java", ".txt");
    tempFile.deleteOnExit();
    try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile))) {
      out.write(String.format(mimeBody, from));
    } catch (IOException e) {
      throw e;
    }

    return SendMimeEmailRequest.builder()
        .setTo(Arrays.asList(recipient))
        .setMessage(tempFile)
        .build();
  }
}
