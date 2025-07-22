package com.mycompany.app;

import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent;
import java.util.Collections;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class WebhookService {

  private static final Logger LOGGER = Logger.getLogger(WebhookService.class.getName());

  public SvamlControl answered(IncomingCallEvent event) {

    LOGGER.info(
        "Incoming call from '%s' received for '%s' :".formatted(event.getCli(), event.getTo()));

    var hangupAction = SvamlActionHangup.builder().build();

    var sayInstruction =
        SvamlInstructionSay.builder()
            .setText("Thank you for calling Sinch. This call will now end.")
            .build();

    return SvamlControl.builder()
        .setInstructions(Collections.singletonList(sayInstruction))
        .setAction(hangupAction)
        .build();
  }
}
