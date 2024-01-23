package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.svaml.ActionContinue;
import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

public class ManageWithCallLeg extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ManageWithCallLeg.class.getName());

  public ManageWithCallLeg() throws IOException {}

  public static void main(String[] args) {
    try {
      new ManageWithCallLeg().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info(
        "Updating call information for '%s' (conference '%s')".formatted(callId, conferenceId));

    var action = ActionContinue.builder().build();

    Collection<Instruction> instructions =
        Collections.singletonList(
            InstructionSay.builder().setText("Hello from sample app").setLocale("en").build());

    var parameters = SVAMLControl.builder().setInstructions(instructions).setAction(action).build();
    client.voice().calls().manageWithCallLeg(callId, CallLegType.BOTH, parameters);
  }
}
