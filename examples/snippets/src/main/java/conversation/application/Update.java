/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.application;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.AppService;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the Conversation App to update
    String conversationApplicationId = "CONVERSATION_APP_ID";
    // New name for the Conversation App
    String updatedAppName = "Updated from Java SDK snippet";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    AppService appService = client.conversation().v1().app();

    LOGGER.info(String.format("Update application with ID '%s'", conversationApplicationId));

    AppUpdateRequest parameters = AppUpdateRequest.builder().setDisplayName(updatedAppName).build();

    AppResponse result = appService.update(conversationApplicationId, parameters);

    LOGGER.info("Response: " + result);
  }
}
