/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package mailgun.messages;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailHtmlInlineRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunRegion;
import java.util.Arrays;
import java.util.logging.Logger;
import utils.Settings;

public class SendEmail {

  private static final Logger LOGGER = Logger.getLogger(SendEmail.class.getName());

  public static void main(String[] args) {

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

    LOGGER.info(String.format("Send email to '%s'", recipient));

    SendEmailRequest request = createTextEmail(recipient, from);

    SendEmailResponse response = emailsService.sendEmail(mailgunDomain, request);

    LOGGER.info("Response: " + response);
  }

  static SendEmailRequest createTextEmail(String recipient, String from) {

    return SendEmailHtmlInlineRequest.builder()
        .setFrom(from)
        .setTo(Arrays.asList(recipient))
        .setText("\uD83D\uDCE7 Text sent from Sinch SDK Java snippet")
        .setHtml("&#128231; HTML sent from <b>Sinch SDK Java</b> snippet")
        .setSubject("\uD83D\uDCE7 Hello from Sinch SDK Java snippet")
        .build();
  }
}
