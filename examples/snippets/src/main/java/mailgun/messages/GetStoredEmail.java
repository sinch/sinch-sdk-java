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
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunRegion;
import java.util.logging.Logger;
import utils.Settings;

public class GetStoredEmail {

  private static final Logger LOGGER = Logger.getLogger(GetStoredEmail.class.getName());

  public static void main(String[] args) {

    String mailgunApiKey = Settings.getMailgunApiKey().orElse("MY_MAILGUN_API_KEY");
    String mailgunRegion = Settings.getMailgunRegion().orElse("MY_MAILGUN_REGION");

    String mailgunDomain = "A_MAILGUN_DOMAIN";
    String storageKey = "A_STORAGE_KEY";

    Configuration configuration =
        Configuration.builder()
            .setMailgunApiKey(mailgunApiKey)
            .setMailgunRegion(MailgunRegion.from(mailgunRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    EmailsService emailsService = client.mailgun().v1().emails();

    LOGGER.info(String.format("Get stored email with storageKey '%s'", storageKey));

    GetStoredEmailResponse response = emailsService.getStoredEmail(mailgunDomain, storageKey);

    LOGGER.info("Response: " + response);
  }
}
