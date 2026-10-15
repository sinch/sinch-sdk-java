/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.v2.calls;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.CallsService;
import com.sinch.sdk.domains.voice.models.v2.calls.request.CallPatchRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.logging.Logger;
import utils.Settings;

public class InteractByCallName {

  private static final Logger LOGGER = Logger.getLogger(InteractByCallName.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The ID of the session that contains the call
    String sessionId = "SESSION_ID";
    // The name of the call leg within the session, as assigned by the `callName` property in the
    // `dial` command
    String callName = "CALL_NAME";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    CallsService callsService = client.voice().v2().calls();

    CallPatchRequest request =
        CallPatchRequest.builder()
            .setCommands(Collections.singletonList(HangupCommand.HANGUP_COMMAND))
            .build();

    LOGGER.info(
        String.format("Interact with call named '%s' in session '%s'", callName, sessionId));

    callsService.interactByCallName(sessionId, callName, request);

    LOGGER.info("Commands accepted for processing");
  }
}
