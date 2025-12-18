/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.conversations;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListRecentResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class ListRecent {

  private static final Logger LOGGER = Logger.getLogger(ListRecent.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the application to list recent conversations for
    String conversationApplicationId = "APPLICATION_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ConversationsService conversationsService = client.conversation().v1().conversations();

    LOGGER.info(
        String.format(
            "List recent conversations for application with ID '%s'", conversationApplicationId));

    ConversationsListRecentRequest request =
        ConversationsListRecentRequest.builder()
            .setOnlyActive(false)
            .setAppId(conversationApplicationId)
            .build();

    ConversationsListRecentResponse response = conversationsService.listRecent(request);

    LOGGER.info("Response:");

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
