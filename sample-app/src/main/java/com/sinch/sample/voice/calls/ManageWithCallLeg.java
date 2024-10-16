package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionContinue;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionPlayFiles;
import java.io.IOException;
import java.util.Arrays;
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

    CallsService service = client.voice().v1().calls();

    LOGGER.info(
        "Updating call information for '%s' (conference '%s')".formatted(callId, conferenceId));

    var action = SvamlActionContinue.DEFAULT;

    Collection<SvamlInstruction> instructions =
        Collections.singletonList(
            SvamlInstructionPlayFiles.builder()
                .setIds(
                    Arrays.asList("https://samples-files.com/samples/Audio/mp3/sample-file-4.mp3"))
                .build());

    var parameters = SvamlControl.builder().setInstructions(instructions).setAction(action).build();

    service.manageWithCallLeg(callId, CallLeg.CALLEE, parameters);
  }
}
