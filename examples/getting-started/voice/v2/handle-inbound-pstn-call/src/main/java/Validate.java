import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.ValidateSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.ValidateSvamlResponse;
import java.util.logging.Logger;

public class Validate {

  private static final Logger LOGGER = Logger.getLogger(Validate.class.getName());

  public static void main(String[] args) {

    SinchClient sinchClient = Settings.sinchClient();

    // SVAML commands to validate: answer -> greet
    ValidateSvamlRequest request =
        ValidateSvamlRequest.builder()
            .setSvaml(
                SvamlInput.builder()
                    .setCommands(
                        CommandsSequenceCreator.create()
                            .answer()
                            .text("Welcome to Acme.", "Emma")
                            .build())
                    .build())
            .build();

    ValidateSvamlResponse response = sinchClient.voice().v2().svaml().validate(request);

    LOGGER.info("isValid=" + response.getIsValid() + " errors=" + response.getErrors());
  }
}
