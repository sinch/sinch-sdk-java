package com.mycompany.app.voice.v2;

import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import java.util.Collections;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("VoiceV2ServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  // An empty list of commands takes no action
  private static final VoiceSinchEventResponse NO_ACTION =
      VoiceSinchEventResponse.builder().setCommands(Collections.emptyList()).build();

  public VoiceSinchEventResponse incoming(VoiceSinchEvent event) {

    LOGGER.info("Handle event: " + event);

    // play a greeting, then hang up
    // "callName" and "events" only take effect in responses to "call.incoming" events
    return VoiceSinchEventResponse.builder()
        .setCallName("incoming")
        .setCommands(
            Collections.singletonList(
                MessagesCommand.builder()
                    .setMessages(
                        Collections.singletonList(
                            SayMessage.builder()
                                .setText("Thank you for calling. Goodbye.")
                                .setVoiceName("Emma")
                                .build()))
                    .setEvents(
                        MessageEvents.builder()
                            .setOnFinish(Collections.singletonList(HangupCommand.builder().build()))
                            .build())
                    .build()))
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
