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
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.UpdateVersionRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunRegion;
import java.util.logging.Logger;
import utils.Settings;

public class UpdateVersion {

  private static final Logger LOGGER = Logger.getLogger(UpdateVersion.class.getName());

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

    LOGGER.info(String.format("Update template's version '%s'", mailgunTemplateVersionName));

    UpdateVersionRequest request =
        UpdateVersionRequest.builder().setComment("a comment value modified from snippet").build();

    templatesService.updateVersion(
        mailgunDomain, mailgunTemplateName, mailgunTemplateVersionName, request);

    LOGGER.info("Done");
  }
}
