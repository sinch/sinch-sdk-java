package com.sinch.sample.webhooks.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectConference;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.PromptInputEvent;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoiceService {

  private final SinchClient sinchClient;

  private static final Logger LOGGER = Logger.getLogger(VoiceService.class.getName());

  @Autowired
  public VoiceService(SinchClient sinchClient) {
    this.sinchClient = sinchClient;
  }

  public SVAMLControl incoming(IncomingCallEvent event) {

    LOGGER.info("decoded event :" + event);
    return SVAMLControl.builder().build();
  }

  public SVAMLControl answered(AnsweredCallEvent event) {

    LOGGER.info("decoded event :" + event);
    return SVAMLControl.builder()
        .setAction(ActionConnectConference.builder().setConferenceId("My Conference Id").build())
        .build();
  }

  public void disconnect(DisconnectCallEvent event) {

    LOGGER.info("decoded event :" + event);
  }

  public void prompt(PromptInputEvent event) {

    LOGGER.info("decoded event :" + event);
  }
}
