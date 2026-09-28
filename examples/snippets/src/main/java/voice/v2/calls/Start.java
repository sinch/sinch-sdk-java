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
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
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
    // The phone number you want to call, in E.164 format (e.g., +12025550123)
    String recipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    CallsService callsService = client.voice().v2().calls();

    // Played to the recipient once the call is answered
    MessagesCommand greeting =
        MessagesCommand.builder()
            .setMessages(
                Collections.singletonList(
                    SayMessage.builder()
                        .setText("Hello, your call is now connected.")
                        .setVoiceName("Emma")
                        .build()))
            .build();

    DialCommand dial =
        DialCommand.builder()
            .setCallName("Java_SDK_Snippet_Call")
            .setFrom(Phone.builder().setNumber(sinchPhoneNumber).build())
            .setTo(Phone.builder().setNumber(recipientPhoneNumber).build())
            .setEvents(
                CallEvents.builder()
                    .setOnAnswer(Collections.singletonList(greeting))
                    .setOnHangup(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    StartCallRequest request =
        StartCallRequest.builder().setCommands(Collections.singletonList(dial)).build();

    LOGGER.info("Start a call to: " + recipientPhoneNumber);

    StartCallResponse response = callsService.start(request);

    LOGGER.info("Response: " + response);
  }
}
