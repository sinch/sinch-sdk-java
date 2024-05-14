import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import java.util.Collections;
import java.util.logging.Logger;

public class SendSms {

  private static final Logger LOGGER = Logger.getLogger(SendSms.class.getName());

  public void send(SMSService service) {

    String fromPhoneNumber = "YOUR_sinch_phone_number";
    String toPhoneNumber = "YOUR_recipient_phone_number";
    String body = "This is a test SMS message using the Sinch Java SDK.";

    LOGGER.info("Send Text to '%s'".formatted(toPhoneNumber));

    SendSmsBatchTextRequest.Builder builder =
        SendSmsBatchTextRequest.builder()
            .setTo(Collections.singletonList(toPhoneNumber))
            .setBody(body)
            .setFrom(fromPhoneNumber);

    BatchText value = service.batches().send(builder.build());

    LOGGER.info("Response: " + value);
  }
}
