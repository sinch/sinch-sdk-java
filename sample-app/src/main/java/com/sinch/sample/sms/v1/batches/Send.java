package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Send extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public Send() throws IOException {}

  public static void main(String[] args) {
    try {
      new Send().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    BatchesService service = client.sms().v1().batches();

    LOGGER.info("Send Text to " + phoneNumber);

    Map<String, String> nameParameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>(phoneNumber, "John"),
                new AbstractMap.SimpleEntry<>("+12018888888", "Doe"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, String> codeParameters =
        Stream.of(new AbstractMap.SimpleEntry<>(phoneNumber, "HALLOWEEN20 \uD83C\uDF83"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Map<String, Map<String, String>> parameters =
        Stream.of(
                new AbstractMap.SimpleEntry<>("name", nameParameters),
                new AbstractMap.SimpleEntry<>("code", codeParameters))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    TextRequest.Builder builder =
        TextRequest.builder()
            .setTo(Collections.singletonList(phoneNumber))
            .setBody("Hello ${name}, this your code: ${code}")
            .setClientReference("a client reference")
            .setFrom("+33123456789")
            .setParameters(parameters)
            .setDeliveryReport(DeliveryReportType.FULL);

    // Overload default dashboard webhooks URL if defined
    webhooksSmsPath.ifPresent(builder::setCallbackUrl);

    BatchResponse value = service.send(builder.build());

    LOGGER.info("Response: " + value);
  }
}
