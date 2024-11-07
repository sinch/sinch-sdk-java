package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    CallsService service = client.voice().v1().calls();

    LOGGER.info(
        "Updating call information for '%s' (conference '%s')".formatted(callId, conferenceId));

    SvamlAction action = SvamlActionHangup.DEFAULT;
    SvamlInstruction instruction = SvamlInstructionSay.builder().setText("Good bye").build();

    Collection<SvamlInstruction> instructions = Collections.singletonList(instruction);

    var parameters = SvamlControl.builder().setInstructions(instructions).setAction(action).build();

    service.update(callId, parameters);
  }
}
