import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.logging.Logger;

public class TtsCall {

  private static final Logger LOGGER = Logger.getLogger(TtsCall.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands: dial -> on answer speak one line of TTS -> hangup
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        destinationNumber,
                        dial ->
                            dial.from(sinchNumber)
                                .name("tts-hello")
                                .timeoutDurationSeconds(30)
                                .maxDurationSeconds(120)
                                .onAnswer(
                                    answered ->
                                        answered.text(
                                            "Hello. This is text to speech from the Sinch Voice"
                                                + " API.",
                                            "Emma",
                                            hello -> hello.name("hello").onFinish(Calls.hangup())))
                                .onHangup(Calls.hangup()))
                    .build())
            .build();

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }
}
