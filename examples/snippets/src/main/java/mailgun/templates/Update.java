/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package mailgun.templates;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.UpdateTemplateRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String mailgunApiKey = Settings.getMailgunApiKey().orElse("MY_MAILGUN_API_KEY");
    String mailgunRegion = Settings.getMailgunRegion().orElse("MY_MAILGUN_REGION");

    String mailgunDomain = "A_MAILGUN_DOMAIN";
    String mailgunTemplateName = "A_TEMPLATE_NAME";

    Configuration configuration =
        Configuration.builder()
            .setMailgunApiKey(mailgunApiKey)
            .setMailgunRegion(MailgunRegion.from(mailgunRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    TemplatesService templatesService = client.mailgun().v1().templates();

    LOGGER.info(String.format("Update template '%s'", mailgunTemplateName));

    UpdateTemplateRequest request =
        UpdateTemplateRequest.builder().setDescription("New description value").build();

    templatesService.update(mailgunDomain, mailgunTemplateName, request);

    LOGGER.info("Done");
  }
}
