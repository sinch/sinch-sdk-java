/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package mailgun.templates;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunRegion;
import java.util.logging.Logger;
import utils.Settings;

public class DeleteVersion {

  private static final Logger LOGGER = Logger.getLogger(DeleteVersion.class.getName());

  public static void main(String[] args) {

    String mailgunApiKey = Settings.getMailgunApiKey().orElse("MY_MAILGUN_API_KEY");
    String mailgunRegion = Settings.getMailgunRegion().orElse("MY_MAILGUN_REGION");

    String mailgunDomain = "A_MAILGUN_DOMAIN";
    String mailgunTemplateName = "A_TEMPLATE_NAME";
    String mailgunTemplateVersionName = "A_TEMPLATE_VERSION_NAME";

    Configuration configuration =
        Configuration.builder()
            .setMailgunApiKey(mailgunApiKey)
            .setMailgunRegion(MailgunRegion.from(mailgunRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    TemplatesService templatesService = client.mailgun().v1().templates();

    LOGGER.info(String.format("Delete template version '%s'", mailgunTemplateVersionName));

    templatesService.deleteVersion(mailgunDomain, mailgunTemplateName, mailgunTemplateVersionName);

    LOGGER.info("Done");
  }
}
