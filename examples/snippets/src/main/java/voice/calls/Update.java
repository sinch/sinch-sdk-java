/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.calls;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The ID of the call to update
    String callId = "CALL_ID";
    // The instruction to be performed
    SvamlInstruction instruction = SvamlInstructionSay.builder().setText("Goodbye").build();
    // The instruction to add to the call
    SvamlAction action = SvamlActionHangup.DEFAULT;

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    CallsService callsService = client.voice().v1().calls();

    LOGGER.info(String.format("Updating call with ID '%s'", callId));

    Collection<SvamlInstruction> instructions = Collections.singletonList(instruction);

    SvamlControl request =
        SvamlControl.builder().setInstructions(instructions).setAction(action).build();

    callsService.update(callId, request);

    LOGGER.info("Done");
  }
}
