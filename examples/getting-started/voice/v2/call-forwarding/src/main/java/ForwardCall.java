import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ForwardCall {

  private static final Logger LOGGER = Logger.getLogger(ForwardCall.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String callerNumber = Settings.get("CALLER_NUMBER", "MY_CALLER_NUMBER");
    String primaryNumber = Settings.get("PRIMARY_NUMBER", "MY_PRIMARY_NUMBER");
    String fallbackNumber = Settings.get("FALLBACK_NUMBER", "MY_FALLBACK_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    // Destination answered: stop the hold prompt, join the caller in the bridge
    Consumer<CommandsSequenceCreator> joinBridge =
        answered -> answered.stopMessages("hold").bridgeCall("fwd-bridge");

    // SVAML commands: dial the caller -> on answer play hold prompt, join the bridge and dial the
    // primary -> on primary timeout dial the fallback -> on fallback timeout hang up the caller
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        callerNumber,
                        caller ->
                            caller
                                .from(sinchNumber)
                                .name("caller")
                                .timeoutDurationSeconds(30)
                                .onAnswer(
                                    answered ->
                                        answered
                                            // Step 1: play a hold prompt while we try the primary
                                            .text(
                                                "Connecting your call.",
                                                "Emma",
                                                hold -> hold.name("hold"))
                                            // Step 2: caller joins the bridge (created on first
                                            // reference)
                                            .bridgeCall("fwd-bridge")
                                            // Step 3: dial the primary number
                                            .dial(
                                                primaryNumber,
                                                primary ->
                                                    primary
                                                        .from(sinchNumber)
                                                        .name("primary")
                                                        .timeoutDurationSeconds(20)
                                                        // Primary answered: bridge them
                                                        .onAnswer(joinBridge)
                                                        // Primary didn't answer: try the fallback
                                                        .onTimeout(
                                                            timeout ->
                                                                timeout.dial(
                                                                    fallbackNumber,
                                                                    fallback ->
                                                                        fallback
                                                                            .from(sinchNumber)
                                                                            .name("fallback")
                                                                            .timeoutDurationSeconds(
                                                                                20)
                                                                            .onAnswer(joinBridge)
                                                                            .onTimeout(
                                                                                Calls.hangup(
                                                                                    "caller"))))))
                                .onHangup(Calls.hangup("primary"), Calls.hangup("fallback")))
                    .build())
            .build();

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }
}
