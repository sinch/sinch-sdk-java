/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.projectsettings;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ProjectSettingsService;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.ContactSettings;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.request.ProjectSettingsRequest;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.response.ProjectSettingsResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.io.IOException;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) throws IOException {

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

    ProjectSettingsService service = client.conversation().v1().projectSettings();

    LOGGER.info("conversation project settings");

    ContactSettings contactSettings =
        ContactSettings.builder().setUnifiedContactIdEnabled(false).build();

    ProjectSettingsRequest request =
        ProjectSettingsRequest.builder().setContactSettings(contactSettings).build();

    ProjectSettingsResponse result = service.update(request);

    LOGGER.info("Response: " + result);
  }
}
