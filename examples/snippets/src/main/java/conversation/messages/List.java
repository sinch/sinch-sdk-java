/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.messages;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
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

    // The ID of the Conversation Application to list messages for
    String conversationApplicationId = "APPLICATION_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    MessagesService messagesService = client.conversation().v1().messages();

    LOGGER.info(
        String.format("List messages for application with ID '%s'", conversationApplicationId));

    MessagesListRequest request =
        MessagesListRequest.builder().setAppId(conversationApplicationId).build();

    MessagesListResponse response = messagesService.list(request);

    LOGGER.info("Response:");

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
