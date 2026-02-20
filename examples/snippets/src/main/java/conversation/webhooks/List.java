/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.webhooks;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.WebhooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.response.WebhooksListResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class List {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the conversation application to list webhooks for
    String conversationApplicationId = "APPLICATION_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    WebhooksService webHooksService = client.conversation().v1().webhooks();

    LOGGER.info("List");

    WebhooksListResponse response = webHooksService.list(conversationApplicationId);

    LOGGER.info("Response: ");
    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
