import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimRing {

  private static final Logger LOGGER = Logger.getLogger(SimRing.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String customerNumber = Settings.get("CUSTOMER_NUMBER", "MY_CUSTOMER_NUMBER");

    // Read the first three agents; missing ones repeat the previous agent
    List<String> agents =
        Arrays.stream(Settings.get("AGENT_NUMBERS", "MY_AGENT_NUMBER").split(","))
            .map(String::trim)
            .filter(number -> !number.isEmpty())
            .collect(Collectors.toList());
    String agent1 = agents.get(0);
    String agent2 = agents.size() > 1 ? agents.get(1) : agent1;
    String agent3 = agents.size() > 2 ? agents.get(2) : agent2;

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands: dial the customer -> on answer play a hold message and ring the three
    // agents at once (dial is non-blocking) -> first to answer wins
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        customerNumber,
                        customer ->
                            customer
                                .from(sinchNumber)
                                .name("customer")
                                .timeoutDurationSeconds(30)
                                .onAnswer(
                                    answered ->
                                        answered
                                            .text(
                                                "Connecting you now.",
                                                "Emma_3",
                                                hold -> hold.name("hold"))
                                            .command(
                                                ringAgent(
                                                    agent1,
                                                    "agent-A",
                                                    sinchNumber,
                                                    "agent-B",
                                                    "agent-C"),
                                                ringAgent(
                                                    agent2,
                                                    "agent-B",
                                                    sinchNumber,
                                                    "agent-A",
                                                    "agent-C"),
                                                ringAgent(
                                                    agent3,
                                                    "agent-C",
                                                    sinchNumber,
                                                    "agent-A",
                                                    "agent-B")))
                                .onHangup(Calls.hangup()))
                    .build())
            .build();

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }

  // First agent to answer stops the hold message, hangs up the other agent legs and joins the
  // bridge
  private static DialCommand ringAgent(
      String number, String name, String sinchNumber, String other1, String other2) {
    return Calls.dial(number)
        .from(sinchNumber)
        .name(name)
        .timeoutDurationSeconds(25)
        .onAnswer(
            answered ->
                answered
                    .stopMessages("hold")
                    .hangup(other1)
                    .hangup(other2)
                    .bridgeCall("hunt-bridge"))
        .build();
  }
}
