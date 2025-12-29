/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.templates.v2;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Collection;
import java.util.logging.Logger;
import utils.Settings;

public class ListTranslations {

  private static final Logger LOGGER = Logger.getLogger(ListTranslations.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the template to retrieve translations for
    String conversationTemplateId = "TEMPLATE_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    TemplatesServiceV2 templatesServiceV2 = client.conversation().templates().v2();

    LOGGER.info(
        String.format("List translations for template with ID '%s'", conversationTemplateId));

    Collection<TemplateTranslation> response =
        templatesServiceV2.listTranslations(conversationTemplateId, null);

    LOGGER.info("Response: ");

    response.iterator().forEachRemaining(f -> LOGGER.info(String.format("- %s", f)));
  }
}
