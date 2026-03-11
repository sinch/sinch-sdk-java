package com.sinch.sdk.e2e.domains.verification.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.api.v1.SinchEventsService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationResultEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationSinchEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationSmsDeliveredEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationSmsDeliveredEvent.SmsResultEnum;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class SinchEventsEventsSteps {

  static final String WEBHOOKS_PATH = Config.VERIFICATION_HOST_NAME + "/webhooks/verification/";

  SinchEventsService service;

  static VerificationSinchEvent expectedVerificationRequestEvent =
      VerificationRequestEvent.builder()
          .setId("1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
          .setMethod(VerificationMethod.SMS)
          .setIdentity(NumberIdentity.builder().setEndpoint("+33612345678").build())
          .setPrice(Price.builder().setCurrencyId("EUR").setAmount(0.0453F).build())
          .build();

  static VerificationSinchEvent expectedVerificationResultEvent =
      VerificationResultEvent.builder()
          .setId("1ce0ffee-c0de-5eed-d00d-f00dfeed1337")
          .setMethod(VerificationMethod.SMS)
          .setIdentity(NumberIdentity.builder().setEndpoint("+33612345678").build())
          .setStatus(VerificationStatus.SUCCESSFUL)
          .build();

  static VerificationSinchEvent expectedVerificationSMSDeliveredEvent =
      VerificationSmsDeliveredEvent.builder()
          .setSmsResult(SmsResultEnum.SUCCESSFUL)
          .setId("0198511c-d1d1-8bf3-109b-85455d310123")
          .setMethod(VerificationMethod.SMS)
          .setIdentity(NumberIdentity.valueOf("+33123456789"))
          .build();

  static Map<String, String> triggerToURL =
      Stream.of(
              new SimpleEntry<>(
                  "Verification Request", WEBHOOKS_PATH + "verification-request-event"),
              new SimpleEntry<>("Verification Result", WEBHOOKS_PATH + "verification-result-event"),
              new SimpleEntry<>(
                  "Verification SMS Delivered Event",
                  WEBHOOKS_PATH + "verification-sms-delivery-event"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  static Map<String, VerificationSinchEvent> triggerToExpectedEvents =
      Stream.of(
              new SimpleEntry<>("Verification Request", expectedVerificationRequestEvent),
              new SimpleEntry<>("Verification Result", expectedVerificationResultEvent),
              new SimpleEntry<>(
                  "Verification SMS Delivered Event", expectedVerificationSMSDeliveredEvent))
          .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

  Map<String, WebhooksHelper.Response<VerificationSinchEvent>> receivedEvents =
      new ConcurrentHashMap<>();

  @Given("^the Verification Webhooks handler is available$")
  public void serviceAvailable() {

    service = Config.getSinchClient().verification().v1().sinchEvents();
  }

  @When("I send a request to trigger a {string} event")
  public void triggerEvent(String trigger) throws IOException {

    WebhooksHelper.Response<VerificationSinchEvent> response =
        WebhooksHelper.callURL(new URL(triggerToURL.get(trigger)), service::parseEvent);
    receivedEvents.put(trigger, response);
  }

  @Then("the header of the Verification event {string} contains a valid authorization")
  public void validateEventSignature(String trigger) {

    WebhooksHelper.Response<VerificationSinchEvent> receivedEvent = receivedEvents.get(trigger);

    boolean validated =
        service.validateAuthenticationHeader(
            "POST", "/webhooks/verification", receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the Verification event describes a {string} event type")
  public void validateResult(String trigger) {

    VerificationSinchEvent expected = triggerToExpectedEvents.get(trigger);
    VerificationSinchEvent receivedEvent = receivedEvents.get(trigger).event;

    TestHelpers.recursiveEquals(receivedEvent, expected);
  }
}
