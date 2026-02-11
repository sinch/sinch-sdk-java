package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent;
import java.util.Collections;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public SvamlControl incoming(IncomingCallEvent event) {

    LOGGER.info("Handle event: " + event);

    String instruction =
        "Thank you for calling your Sinch number. You've just handled an incoming call.";

    return SvamlControl.builder()
        .setAction(SvamlActionHangup.builder().build())
        .setInstructions(
            Collections.singletonList(SvamlInstructionSay.builder().setText(instruction).build()))
        .build();
  }

  public void disconnect(DisconnectedCallEvent event) {

    LOGGER.info("Handle event: " + event);
  }
}
