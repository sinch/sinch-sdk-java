import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.logging.Logger;

public class TtsSampler {

  private static final Logger LOGGER = Logger.getLogger(TtsSampler.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");
    // Override voices: VOICE_PLAIN=Emma VOICE_SSML=Brian
    String voicePlain = Settings.get("VOICE_PLAIN", "Emma");
    String voiceSsml = Settings.get("VOICE_SSML", "Brian");

    SinchClient sinchClient = Settings.sinchClient();

    String ssml =
        "<speak>"
            + "<prosody rate='slow'>"
            + "Now hear an S S M L example. "
            + "Your code is <say-as interpret-as='characters'>4837</say-as>."
            + "</prosody>"
            + "<break time='400ms'/>"
            + "Goodbye."
            + "</speak>";

    // SVAML commands: dial -> on answer play a plain text SAY, a PLAY clip and an SSML SAY in
    // sequence -> hangup
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        destinationNumber,
                        dial ->
                            dial.from(sinchNumber)
                                .name("tts-sampler")
                                .timeoutDurationSeconds(30)
                                .maxDurationSeconds(120)
                                .onAnswer(
                                    answered ->
                                        answered.messages(
                                            messages ->
                                                messages
                                                    .name("sampler")
                                                    .text(
                                                        String.format(
                                                            "Hello, this is a plain text message"
                                                                + " with the %s voice.",
                                                            voicePlain),
                                                        voicePlain)
                                                    .play("https://samplelib.com/mp3/sample-3s.mp3")
                                                    .ssml(ssml, voiceSsml)
                                                    .onFinish(Calls.hangup())))
                                .onHangup(Calls.hangup()))
                    .build())
            .build();

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }
}
