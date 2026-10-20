/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.v2.batches;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.BatchesService;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.models.Configuration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import utils.Settings;

public class Start {

  private static final Logger LOGGER = Logger.getLogger(Start.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The phone number to be used as the caller ID, in E.164 format (e.g., +12025550123)
    String sinchPhoneNumber = Settings.getPhoneNumber().orElse("MY_SINCH_PHONE_NUMBER");
    // The phone numbers you want to call, in E.164 format (e.g., +12025550123).
    // One call per entry, each one filling the "@toNumber" placeholder of the dial command
    List<Map<String, String>> parameters =
        Arrays.asList(
            Collections.singletonMap("toNumber", "RECIPIENT_PHONE_NUMBER_1"),
            Collections.singletonMap("toNumber", "RECIPIENT_PHONE_NUMBER_2"));

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    BatchesService batchesService = client.voice().v2().batches();

    // Dial each recipient: once the call is answered, play a greeting, then hang up.
    // "@toNumber" is a placeholder, replaced in each call by that call's parameter value
    StartBatchRequest request =
        StartBatchRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        "@toNumber",
                        dial ->
                            dial.name("Java_SDK_Snippet_Call")
                                .from(sinchPhoneNumber)
                                .onAnswer(
                                    answered ->
                                        answered.messages(
                                            messages ->
                                                messages
                                                    .text(
                                                        "Hello, your call is now connected.",
                                                        "Emma")
                                                    .onFinish(Calls.hangup()))))
                    .build())
            .setParameters(parameters)
            .build();

    LOGGER.info("Start a batch of calls to: " + parameters);

    StartBatchResponse response = batchesService.start(request);

    LOGGER.info("Response: " + response);
  }
}
