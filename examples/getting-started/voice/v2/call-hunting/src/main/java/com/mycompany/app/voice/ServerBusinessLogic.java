package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.SinchEventType;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Set<SinchEventType> FAILED_EVENTS =
      Set.of(
          SinchEventType.CALL_TIMEOUT,
          SinchEventType.CALL_BUSY,
          SinchEventType.CALL_REJECTED,
          SinchEventType.CALL_FAILED);

  private final String sinchNumber;
  private final List<String> agents;

  // In-memory hunt cursor: session ID -> index of the agent being dialed.
  // A restart loses the hunts in progress: use a real store in production
  private final Map<String, Integer> cursors = new ConcurrentHashMap<>();

  public ServerBusinessLogic(
      @Value("${SINCH_NUMBER:}") String sinchNumber,
      @Value("${AGENT_NUMBERS:}") String agentNumbers) {
    this.sinchNumber = sinchNumber;
    List<String> numbers =
        Arrays.stream(agentNumbers.split(","))
            .map(String::trim)
            .filter(number -> !number.isEmpty())
            .collect(Collectors.toList());
    this.agents = numbers.isEmpty() ? List.of("MY_AGENT_NUMBER") : numbers;
  }

  public VoiceSinchEventResponse handle(VoiceSinchEvent event) {

    SinchEventType type = event.getEvent();
    String sessionId = event.getCall().getSessionId();
    String callName = null == event.getCall().getCallName() ? "" : event.getCall().getCallName();
    boolean agentLeg = callName.startsWith("agent-");

    if (SinchEventType.CALL_INCOMING.equals(type)) {
      // Inbound call: the inbound leg is the customer. Answer, join the bridge and dial the first
      // agent
      cursors.put(sessionId, 0);
      return SinchEventResponses.incomingCallResponse(
              commands ->
                  commands
                      .answer()
                      .text(
                          "Please hold while we find an agent.",
                          "Emma_3",
                          hold -> hold.name("hold"))
                      .bridgeCall("hunt-bridge")
                      .command(dialAgent(0)))
          .onHangup(Calls.hangup())
          .build();
    }

    if (SinchEventType.CALL_ANSWERED.equals(type) && "customer".equals(callName)) {
      // Outbound customer leg answered: play the hold message, join the bridge and dial the first
      // agent
      cursors.put(sessionId, 0);
      return SinchEventResponses.response(
          commands ->
              commands
                  .text("Please hold while we find an agent.", "Emma_3", hold -> hold.name("hold"))
                  .bridgeCall("hunt-bridge")
                  .command(dialAgent(0)));
    }

    if (SinchEventType.CALL_ANSWERED.equals(type) && agentLeg) {
      // Agent answered: stop the hold message and bridge them in
      return SinchEventResponses.response(
          commands -> commands.stopMessages("hold").bridgeCall("hunt-bridge"));
    }

    if (FAILED_EVENTS.contains(type) && agentLeg) {
      // Agent didn't connect: advance the cursor and try the next agent
      int index = cursors.getOrDefault(sessionId, 0) + 1;
      cursors.put(sessionId, index);
      if (index >= agents.size()) {
        // No more agents: apologise and hang up
        cursors.remove(sessionId);
        return SinchEventResponses.response(
            commands ->
                commands.text(
                    "We are sorry, no agent is available. Please try again later.",
                    "Emma_3",
                    noAnswer -> noAnswer.name("noanswer").onFinish(Calls.hangup())));
      }
      return SinchEventResponses.response(dialAgent(index));
    }

    // The hunt is over once the customer leg hangs up. Agent legs also send "call.hangup",
    // so they must not clear the cursor of a hunt still in progress
    if (SinchEventType.CALL_HANGUP.equals(type) && !agentLeg) {
      cursors.remove(sessionId);
    }
    return SinchEventResponses.response();
  }

  private DialCommand dialAgent(int index) {
    return Calls.dial(agents.get(index))
        .from(sinchNumber)
        .name("agent-" + index)
        .timeoutDurationSeconds(20)
        .build();
  }
}
