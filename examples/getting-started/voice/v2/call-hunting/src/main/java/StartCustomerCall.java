import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.logging.Logger;

public class StartCustomerCall {

  private static final Logger LOGGER = Logger.getLogger(StartCustomerCall.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String customerNumber = Settings.get("CUSTOMER_NUMBER", "MY_CUSTOMER_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    // The dial has no events of its own, so its events go to the hunt server
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        customerNumber,
                        customer ->
                            customer.from(sinchNumber).name("customer").timeoutDurationSeconds(30))
                    .build())
            .build();

    StartCallResponse response = sinchClient.voice().v2().calls().start(request);

    LOGGER.info("Call created successfully: " + response);
  }
}
