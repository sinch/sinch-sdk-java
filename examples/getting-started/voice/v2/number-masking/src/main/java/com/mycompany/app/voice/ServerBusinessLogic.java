package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  @Value("${SINCH_NUMBER:}")
  private String sinchNumber;

  @Value("${DESTINATION_NUMBER:}")
  private String destinationNumber;

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    return SinchEventResponses.incomingCallResponse(
            commands ->
                commands
                    .answer()
                    .text(
                        "Please hold while we connect your call.",
                        "Emma",
                        greeting -> greeting.name("greeting"))
                    // Add Party A to a named bridge
                    .bridgeCall("main-bridge")
                    .dial(
                        // In production, look up the destination from your DB (event.getCall()
                        // .getTo())
                        destinationNumber,
                        callee ->
                            callee
                                // Party B sees the Sinch number
                                .from(sinchNumber)
                                .name("callee")
                                .timeoutDurationSeconds(30)
                                .onAnswer(Calls.bridgeCall("main-bridge"))
                                .onHangup(Calls.hangup("caller"))))
        // "name" names the inbound (caller) leg and "onHangup" handles the caller hanging up
        .name("caller")
        .onHangup(Calls.hangup("callee"))
        .build();
  }

  public VoiceSinchEventResponse other(VoiceSinchEvent event) {

    LOGGER.info("Unhandled event: " + event.getEvent());

    return SinchEventResponses.response();
  }
}
