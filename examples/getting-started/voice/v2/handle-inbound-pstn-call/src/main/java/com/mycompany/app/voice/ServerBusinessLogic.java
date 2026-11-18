package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  @Value("${SINCH_NUMBER:}")
  private String sinchNumber;

  @Value("${DESTINATION_NUMBER:}")
  private String destinationNumber;

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    // SVAML commands: answer -> greet -> bridge with the agent leg dialed below
    return SinchEventResponses.incomingCallResponse(
            commands ->
                commands
                    .answer()
                    .text(
                        "Welcome to Acme. Please hold while we connect your call.",
                        "Emma",
                        greeting -> greeting.name("greeting"))
                    .bridgeCall("inbound-bridge")
                    .dial(
                        destinationNumber,
                        agent ->
                            agent
                                .from(sinchNumber)
                                .name("agent")
                                .timeoutDurationSeconds(30)
                                .onAnswer(Calls.bridgeCall("inbound-bridge"))
                                .onHangup(Calls.hangup("incoming"))
                                .onTimeout(Calls.hangup("incoming"))))
        // "name" names the inbound (caller) leg; it only takes effect for "call.incoming" events
        .name("incoming")
        .onHangup(Calls.hangup("agent"))
        .build();
  }

  public VoiceSinchEventResponse other(VoiceSinchEvent event) {

    // For all other events, acknowledge with no commands
    return SinchEventResponses.response();
  }
}
