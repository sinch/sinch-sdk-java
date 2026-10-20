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
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.models.Configuration;
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

    // Dial the recipient: once the call is answered, play a greeting, then hang up
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        recipientPhoneNumber,
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
            .build();

    LOGGER.info("Start a call to: " + recipientPhoneNumber);

    StartCallResponse response = callsService.start(request);

    LOGGER.info("Response: " + response);
  }
}
