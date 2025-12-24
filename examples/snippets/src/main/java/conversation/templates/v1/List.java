/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.templates.v1;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Collection;
import java.util.logging.Logger;
import utils.Settings;

public class List {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    TemplatesServiceV1 templatesServiceV1 = client.conversation().templates().v1();

    LOGGER.info("List templates V1");

    Collection<TemplateV1> result = templatesServiceV1.list();

    LOGGER.info("Response: ");

    result.iterator().forEachRemaining(f -> LOGGER.info(String.format("- %s: %s", f.getId(), f)));
  }
}
