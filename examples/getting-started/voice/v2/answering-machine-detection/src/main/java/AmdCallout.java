import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.logging.Logger;

public class AmdCallout {

  private static final Logger LOGGER = Logger.getLogger(AmdCallout.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    // On an outbound call, the `amd` command goes in the `onAnswer` event of the `dial` command
    // (on an inbound call, right after `answer`: see the server).
    // It fires different SVAML commands based on what AMD detects.
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        destinationNumber,
                        dial ->
                            dial.from(sinchNumber)
                                .name("amd-call")
                                .timeoutDurationSeconds(45)
                                .maxDurationSeconds(300)
                                .onAnswer(
                                    answered ->
                                        answered.amd(
                                            amd ->
                                                amd
                                                    // Human picked up: play a personalized
                                                    // greeting
                                                    .onHuman(
                                                        human ->
                                                            human.text(
                                                                "Hello! This is a call from Acme"
                                                                    + " Corp. An agent will be with"
                                                                    + " you shortly.",
                                                                "Emma",
                                                                greeting ->
                                                                    greeting
                                                                        .name("human-greeting")
                                                                        .onFinish(Calls.hangup())))
                                                    // Machine greeting detected (beep not yet
                                                    // heard): just hang up
                                                    .onMachine(Calls.hangup())
                                                    // Beep detected: leave a voicemail message now
                                                    .onBeep(
                                                        beep ->
                                                            beep.text(
                                                                "Hi, this is Acme Corp calling"
                                                                    + " about your recent inquiry."
                                                                    + " Please call us back at"
                                                                    + " 555-1234. Thank you.",
                                                                "Emma",
                                                                voicemail ->
                                                                    voicemail
                                                                        .name("voicemail-message")
                                                                        .onFinish(Calls.hangup())))
                                                    // Unknown: hang up safely
                                                    .onUnknown(Calls.hangup()))))
                    .build())
            .build();

    LOGGER.info(
        String.format("Placing AMD callout from %s to %s ...", sinchNumber, destinationNumber));

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("AMD call created successfully: " + response);
  }
}
