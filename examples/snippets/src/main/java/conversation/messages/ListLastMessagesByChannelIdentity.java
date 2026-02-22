/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.messages;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.LastMessagesByChannelIdentityListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import utils.Settings;

public class ListLastMessagesByChannelIdentity {

  private static final Logger LOGGER =
      Logger.getLogger(ListLastMessagesByChannelIdentity.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    List<String> channelIdentities = Arrays.asList("CHANNEL_IDENTITY1", "CHANNEL_IDENTITY2");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    MessagesService messagesService = client.conversation().v1().messages();

    LOGGER.info(String.format("List last messages for identities '%s'", channelIdentities));

    LastMessagesByChannelIdentityListQueryParameters request =
        LastMessagesByChannelIdentityListQueryParameters.builder()
            .setChannelIdentities(channelIdentities)
            .build();

    MessagesListResponse response = messagesService.listLastMessagesByChannelIdentity(request);

    LOGGER.info("Response:");

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
