import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.helpers.CallBehaviorHelper;
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import java.util.logging.Logger;

public class ConfigureService {

  private static final Logger LOGGER = Logger.getLogger(ConfigureService.class.getName());

  public static void main(String[] args) {

    String serviceId = Settings.get("SINCH_SERVICE_ID", "MY_SERVICE_ID");
    String webhookUrl = Settings.get("WEBHOOK_URL", "MY_WEBHOOK_URL");

    SinchClient sinchClient = Settings.sinchClient();

    // Send the service's call events to the webhook server, with the same URL as fallback
    UpdateServiceRequest request =
        UpdateServiceRequest.builder()
            .setCallBehavior(CallBehaviorHelper.eventDestination(webhookUrl, webhookUrl))
            .build();

    ServiceResponse response = sinchClient.voice().v2().services().update(serviceId, request);

    LOGGER.info("Service updated: " + response);
  }
}
