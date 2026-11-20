import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.logging.Logger;

public class MaskedBridgeCall {

  private static final Logger LOGGER = Logger.getLogger(MaskedBridgeCall.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");
    // Default the two legs; override with two real phones for a proper test
    String partyANumber = Settings.get("PARTY_A_NUMBER", destinationNumber);
    String partyBNumber = Settings.get("PARTY_B_NUMBER", sinchNumber);

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands: dial Party A -> on answer greet, join the bridge and dial Party B -> on
    // Party B answer join the bridge. Both legs show the Sinch number.
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        partyANumber,
                        partyA ->
                            partyA
                                .from(sinchNumber)
                                .name("party-a")
                                .timeoutDurationSeconds(30)
                                .onAnswer(
                                    answered ->
                                        answered
                                            .text(
                                                "Please hold while we connect the other party.",
                                                "Emma",
                                                greeting -> greeting.name("greeting"))
                                            .bridgeCall("masked-bridge")
                                            .dial(
                                                partyBNumber,
                                                partyB ->
                                                    partyB
                                                        .from(sinchNumber)
                                                        .name("party-b")
                                                        .timeoutDurationSeconds(30)
                                                        .onAnswer(Calls.bridgeCall("masked-bridge"))
                                                        .onHangup(Calls.hangup("party-a"))))
                                .onHangup(Calls.hangup("party-b")))
                    .build())
            .build();

    LOGGER.info(
        String.format(
            "Initiating masked bridge call between %s and %s ...", partyANumber, partyBNumber));
    LOGGER.info(String.format("(Both parties will see %s as the caller ID)", sinchNumber));

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Bridge call created successfully: " + response);
  }
}
