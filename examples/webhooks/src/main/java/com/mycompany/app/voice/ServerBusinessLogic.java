package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.NotificationEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.PromptInputEvent;
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
