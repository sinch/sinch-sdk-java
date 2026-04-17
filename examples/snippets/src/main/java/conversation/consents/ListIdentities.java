/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.consents;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ConsentsService;
import com.sinch.sdk.domains.conversation.models.v1.consents.ConsentsListType;
import com.sinch.sdk.domains.conversation.models.v1.consents.response.ConsentsListResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class ListIdentities {

  private static final Logger LOGGER = Logger.getLogger(ListIdentities.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the Conversation App
    String appId = "CONVERSATION_APP_ID";

    // The consent list type to query
    ConsentsListType listType = ConsentsListType.OPT_OUT_ALL;

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ConsentsService consentsService = client.conversation().v1().consents();

    LOGGER.info(
        String.format("List identities from consent list '%s' for app '%s'", listType, appId));

    ConsentsListResponse response = consentsService.listIdentities(appId, listType);

    LOGGER.info("Response: ");

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
