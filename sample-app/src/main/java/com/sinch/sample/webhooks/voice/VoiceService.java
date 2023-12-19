package com.sinch.sample.webhooks.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectConference;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStartRecording;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.svaml.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.svaml.TranscriptionOptions;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.NotifyEvent;
import com.sinch.sdk.domains.voice.models.webhooks.PromptInputEvent;
import java.util.Arrays;
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
    var action = ActionConnectPstn.builder().build();

    return SVAMLControl.builder().setAction(action).build();
  }

  public SVAMLControl answered(AnsweredCallEvent event) {

    LOGGER.info("decoded event :" + event);
    var action = ActionConnectConference.builder().setConferenceId("My Conference Id").build();

    var say = InstructionSay.builder().setText("Hello from instruction").build();
    var startRecoding =
        InstructionStartRecording.builder()
            .setOptions(
                StartRecordingOptions.builder()
                    .setDestinationUrl("s3://my-bucket/")
                    .setCredentials(
                        "AKIAIOSFODNN7EXAMPLE:wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY:eu-central-1")
                    .setTranscriptionOptions(
                        TranscriptionOptions.builder().setEnabled(true).build())
                    .setNotificationEvents(true)
                    .build())
            .build();
    var instructions = Arrays.asList(say, startRecoding);

    return SVAMLControl.builder().setAction(action).setInstructions(instructions).build();
  }

  public void disconnect(DisconnectCallEvent event) {

    LOGGER.info("decoded event :" + event);
  }

  public void prompt(PromptInputEvent event) {

    LOGGER.info("decoded event :" + event);
  }

  public void notify(NotifyEvent event) {

    LOGGER.info("decoded event :" + event);
  }
}
