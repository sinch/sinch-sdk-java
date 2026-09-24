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
import com.sinch.sdk.domains.voice.models.v2.destination.PhoneDetails;
import com.sinch.sdk.domains.voice.models.v2.svaml.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.Say;
import com.sinch.sdk.domains.voice.models.v2.svaml.SayMessage;
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
    // The phone numbers you want to call, in E.164 format (e.g., +12025550123): one call each
    List<String> recipientPhoneNumbers =
        Arrays.asList("RECIPIENT_PHONE_NUMBER_1", "RECIPIENT_PHONE_NUMBER_2");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    BatchesService batchesService = client.voice().v2().batches();

    // Played to each recipient once their call is answered
    MessagesCommand greeting =
        MessagesCommand.builder()
            .setMessages(
                Collections.singletonList(
                    SayMessage.builder()
                        .setSay(
                            Say.builder()
                                .setText("Hello, your call is now connected.")
                                .setVoiceName("Emma")
                                .build())
                        .build()))
            .build();

    // "@toNumber" is a placeholder, replaced in each call by that call's parameter value
    DialCommand dial =
        DialCommand.builder()
            .setCallName("Java_SDK_Snippet_Call")
            .setFrom(
                Phone.builder()
                    .setPhone(PhoneDetails.builder().setNumber(sinchPhoneNumber).build())
                    .build())
            .setTo(
                Phone.builder()
                    .setPhone(PhoneDetails.builder().setNumber("@toNumber").build())
                    .build())
            .setEvents(
                CallEvents.builder()
                    .setOnAnswer(Collections.singletonList(greeting))
                    .setOnHangup(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    // One parameter set per call, each giving a value for the "@toNumber" placeholder
    List<Map<String, String>> parameters =
        Arrays.asList(
            Collections.singletonMap("toNumber", recipientPhoneNumbers.get(0)),
            Collections.singletonMap("toNumber", recipientPhoneNumbers.get(1)));

    StartBatchRequest request =
        StartBatchRequest.builder()
            .setCommands(Collections.singletonList(dial))
            .setParameters(parameters)
            .build();

    LOGGER.info("Start a batch of calls to: " + recipientPhoneNumbers);

    StartBatchResponse response = batchesService.start(request);

    LOGGER.info("Response: " + response);
  }
}
