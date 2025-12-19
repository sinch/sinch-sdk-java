/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package voice.calls;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
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

public class ManageWithCallLeg {

  private static final Logger LOGGER = Logger.getLogger(ManageWithCallLeg.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The ID of the call to manage
    String callId = "CALL_ID";
    // The call leg to manage
    CallLeg callLeg = CallLeg.CALLEE;

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    CallsService callsService = client.voice().v1().calls();

    LOGGER.info(String.format("Manage call with ID '%s'", callId));

    SvamlAction action = SvamlActionHangup.DEFAULT;

    Collection<SvamlInstruction> instructions =
        Collections.singletonList(
            SvamlInstructionSay.builder()
                .setText("Hello, the call is over, hanging up now. Goodbye")
                .build());

    SvamlControl request =
        SvamlControl.builder().setInstructions(instructions).setAction(action).build();

    callsService.manageWithCallLeg(callId, callLeg, request);

    LOGGER.info("Done");
  }
}
