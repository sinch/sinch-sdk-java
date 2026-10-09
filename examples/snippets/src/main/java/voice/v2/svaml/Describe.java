/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.v2.svaml;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.SvamlService;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.DescribeSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.logging.Logger;
import utils.Settings;

public class Describe {

  private static final Logger LOGGER = Logger.getLogger(Describe.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    SvamlService svamlService = client.voice().v2().svaml();

    DescribeSvamlRequest request =
        DescribeSvamlRequest.builder()
            .setSvaml(
                SvamlInput.builder()
                    .setCommands(
                        Collections.singletonList(
                            MessagesCommand.builder()
                                .setMessages(
                                    Collections.singletonList(
                                        SayMessage.builder()
                                            .setText("Hello, your call is now connected.")
                                            .setVoiceName("Emma")
                                            .build()))
                                .build()))
                    .build())
            .build();

    LOGGER.info("Describe a SVAML payload");

    SvamlDescriptionResponse response = svamlService.describe(request);

    LOGGER.info("Response: " + response);
  }
}
