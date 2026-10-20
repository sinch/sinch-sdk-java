package com.mycompany.app.voice.v2;

import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.SinchEventResponses;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("VoiceV2ServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  // An empty list of commands takes no action
  private static final VoiceSinchEventResponse NO_ACTION = SinchEventResponses.response();

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    LOGGER.info("Handle event: " + event);

    // play a greeting, then hang up
    // the call name only takes effect in responses to "call.incoming" events
    return SinchEventResponses.incomingCallResponse(
            commands ->
                commands.messages(
                    messages ->
                        messages
                            .text("Thank you for calling. Goodbye.", "Emma")
                            .onFinish(Calls.hangup())))
        .name("incoming")
        .build();
  }

  public VoiceSinchEventResponse answered(VoiceSinchEvent event) {

    LOGGER.info("Handle event: " + event);

    return NO_ACTION;
  }

  public VoiceSinchEventResponse menu(VoiceSinchEvent event) {

    // event.getMenu() holds the menu name and the input gathered from the user
    LOGGER.info("Handle event: " + event);

    return NO_ACTION;
  }

  public VoiceSinchEventResponse customEvent(VoiceSinchEvent event) {

    LOGGER.info("Handle event: " + event);

    return NO_ACTION;
  }

  public VoiceSinchEventResponse other(VoiceSinchEvent event) {

    LOGGER.info("Handle event: " + event);

    return NO_ACTION;
  }
}
