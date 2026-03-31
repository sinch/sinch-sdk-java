package sms;

import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.api.v1.SMSService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import java.util.Collections;
import java.util.logging.Logger;

public class Snippet {

  private static final Logger LOGGER = Logger.getLogger(Snippet.class.getName());

  static void execute(SMSService smsService) {

    BatchesService batchesService = smsService.batches();

    String sender = "SENDER_NUMBER";
    String recipient = "RECIPIENT_PHONE_NUMBER";
    String body = "This is a test SMS message using the Sinch Java SDK.";

    LOGGER.info(String.format("Submitting batch to send SMS to '%s'", recipient));

    BatchResponse value =
        batchesService.send(
            TextRequest.builder()
                .setTo(Collections.singletonList(recipient))
                .setBody(body)
                .setFrom(sender)
                .build());

    LOGGER.info("Response: " + value);
  }
}
