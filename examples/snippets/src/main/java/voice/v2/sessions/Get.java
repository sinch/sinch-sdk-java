/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.v2.sessions;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.SessionsService;
import com.sinch.sdk.domains.voice.models.v2.sessions.response.Session;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Get {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The ID of the session to retrieve
    String sessionId = "SESSION_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    SessionsService sessionsService = client.voice().v2().sessions();

    LOGGER.info(String.format("Get session with ID '%s'", sessionId));

    Session response = sessionsService.get(sessionId);

    LOGGER.info("Response: " + response);
  }
}
