import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SequentialHunt {

  private static final Logger LOGGER = Logger.getLogger(SequentialHunt.class.getName());

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

    // Built from the last agent back to the first: each agent's timeout dials the next one,
    // and the last agent's timeout hangs up the customer
    DialCommand dialAgent3 = dialAgent(agent3, "agent-3", sinchNumber, Calls.hangup("customer"));
    DialCommand dialAgent2 = dialAgent(agent2, "agent-2", sinchNumber, dialAgent3);
    DialCommand dialAgent1 = dialAgent(agent1, "agent-1", sinchNumber, dialAgent2);

    // SVAML commands: dial the customer -> on answer play a hold message and dial agent 1 -> on
    // timeout dial agent 2 -> on timeout dial agent 3 -> on timeout hang up the customer
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
                                                "Please hold while we connect you to an agent.",
                                                "Emma_3",
                                                hold -> hold.name("hold"))
                                            .command(dialAgent1))
                                .onHangup(Calls.hangup()))
                    .build())
            .build();

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }

  // Dial an agent: on answer, stop the hold message and bridge them in; on timeout, run onTimeout
  private static DialCommand dialAgent(
      String number, String name, String sinchNumber, SvamlCommand onTimeout) {
    return Calls.dial(number)
        .from(sinchNumber)
        .name(name)
        .timeoutDurationSeconds(20)
        .onAnswer(answered -> answered.stopMessages("hold").bridgeCall("hunt-bridge"))
        .onTimeout(onTimeout)
        .build();
  }
}
