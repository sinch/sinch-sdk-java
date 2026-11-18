package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    // Return the call flow directly; onHangup is honored here
    return SinchEventResponses.incomingCallResponse(
            commands ->
                commands
                    .answer()
                    .text(
                        "Thank you for calling. Goodbye.",
                        "Emma",
                        goodbye -> goodbye.onFinish(Calls.hangup())))
        .onHangup(Calls.hangup())
        .build();
  }

  public VoiceSinchEventResponse other(VoiceSinchEvent event) {

    // Acknowledge every other event with no commands
    return SinchEventResponses.response();
  }
}
