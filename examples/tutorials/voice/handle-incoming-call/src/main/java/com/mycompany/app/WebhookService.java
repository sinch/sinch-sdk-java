package com.mycompany.app;

import com.sinch.sdk.domains.voice.models.svaml.ActionHangUp;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import java.util.Collections;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class WebhookService {

  private static final Logger LOGGER = Logger.getLogger(WebhookService.class.getName());

  public SVAMLControl answered(IncomingCallEvent event) {

    LOGGER.info(
        "Incoming call from '%s' received for '%s' :".formatted(event.getCli(), event.getTo()));

    var hangupAction = ActionHangUp.builder().build();

    var sayInstruction =
        InstructionSay.builder()
            .setText("Thank you for calling Sinch. This call will now end.")
            .build();

    return SVAMLControl.builder()
        .setInstructions(Collections.singletonList(sayInstruction))
        .setAction(hangupAction)
        .build();
  }
}
