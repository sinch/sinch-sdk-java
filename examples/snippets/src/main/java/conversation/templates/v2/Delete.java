/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.templates.v2;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Delete {

  private static final Logger LOGGER = Logger.getLogger(Delete.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the template to delete
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

    LOGGER.info(String.format("Deleting template with ID '%s'", conversationTemplateId));

    templatesServiceV2.delete(conversationTemplateId);

    LOGGER.info("Done");
  }
}
