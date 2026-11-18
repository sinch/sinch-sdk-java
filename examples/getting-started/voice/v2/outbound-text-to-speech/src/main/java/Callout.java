import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.logging.Logger;

public class Callout {

  private static final Logger LOGGER = Logger.getLogger(Callout.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands: dial -> on answer play an audio file then TTS -> hangup
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        destinationNumber,
                        dial ->
                            dial.from(sinchNumber)
                                .name("audio-notification")
                                .timeoutDurationSeconds(30)
                                .maxDurationSeconds(300)
                                .onAnswer(
                                    answered ->
                                        answered.messages(
                                            messages ->
                                                messages
                                                    .name("notification")
                                                    .play(
                                                        "https://samplelib.com/mp3/sample-12s.mp3")
                                                    .text(
                                                        "Hello! This is a test notification from"
                                                            + " Sinch. Your verification code is 4"
                                                            + " 8 3 7.",
                                                        "Emma")
                                                    .onFinish(Calls.hangup()))))
                    .build())
            .build();

    LOGGER.info(String.format("Placing callout from %s to %s ...", sinchNumber, destinationNumber));

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }
}
