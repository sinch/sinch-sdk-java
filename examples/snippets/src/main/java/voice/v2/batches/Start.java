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
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
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

    // Played to each recipient once their call is answered, then the call is hung up
    MessagesCommand greeting =
        MessagesCommand.builder()
            .setMessages(
                Collections.singletonList(
                    SayMessage.builder()
                        .setText("Hello, your call is now connected.")
                        .setVoiceName("Emma")
                        .build()))
            .setEvents(
                MessageEvents.builder()
                    .setOnFinish(Collections.singletonList(HangupCommand.HANGUP_COMMAND))
                    .build())
            .build();

    // "@toNumber" is a placeholder, replaced in each call by that call's parameter value
    DialCommand dial =
        DialCommand.builder()
            .setCallName("Java_SDK_Snippet_Call")
            .setFrom(Phone.builder().setNumber(sinchPhoneNumber).build())
            .setTo(Phone.builder().setNumber("@toNumber").build())
            .setEvents(
                CallEvents.builder().setOnAnswer(Collections.singletonList(greeting)).build())
            .build();

    StartBatchRequest request =
        StartBatchRequest.builder()
            .setCommands(Collections.singletonList(dial))
            .setParameters(parameters)
            .build();

    LOGGER.info("Start a batch of calls to: " + parameters);

    StartBatchResponse response = batchesService.start(request);

    LOGGER.info("Response: " + response);
  }
}
