package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v1.sinchevents.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.DisconnectedCallEvent;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.NotificationEvent;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.PromptInputEvent;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("VoiceServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public SvamlControl incoming(IncomingCallEvent event) {

    LOGGER.info("Handle event :" + event);

    return SvamlControl.builder().build();
  }

  public SvamlControl answered(AnsweredCallEvent event) {

    LOGGER.info("Handle event: " + event);

    return SvamlControl.builder().build();
  }

  public void disconnect(DisconnectedCallEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void prompt(PromptInputEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void notify(NotificationEvent event) {

    LOGGER.info("Handle event: " + event);
  }
}
