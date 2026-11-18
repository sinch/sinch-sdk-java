import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.domains.voice.models.v2.svaml.IncomingCallResponseEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.ValidateSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.ValidateSvamlResponse;
import java.util.Collections;
import java.util.logging.Logger;

public class Validate {

  private static final Logger LOGGER = Logger.getLogger(Validate.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands to validate: the masking flow the server returns on call.incoming
    ValidateSvamlRequest request =
        ValidateSvamlRequest.builder()
            .setSvaml(
                SvamlInput.builder()
                    .setCommands(
                        CommandsSequenceCreator.create()
                            .answer()
                            .text(
                                "Please hold while we connect your call.",
                                "Emma",
                                greeting -> greeting.name("greeting"))
                            .bridgeCall("main-bridge")
                            .dial(
                                destinationNumber,
                                callee ->
                                    callee
                                        .from(sinchNumber)
                                        .name("callee")
                                        .timeoutDurationSeconds(30)
                                        .onAnswer(Calls.bridgeCall("main-bridge"))
                                        .onHangup(Calls.hangup("caller")))
                            .build())
                    .setCallName("caller")
                    .setEvents(
                        IncomingCallResponseEvents.builder()
                            .setOnHangup(Collections.singletonList(Calls.hangup("callee")))
                            .build())
                    .build())
            .setValidationType(ValidateSvamlRequest.ValidationTypeEnum.STRICT)
            .build();

    ValidateSvamlResponse response = sinchClient.voice().v2().svaml().validate(request);

    LOGGER.info("isValid=" + response.getIsValid() + " errors=" + response.getErrors());
  }
}
