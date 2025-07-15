package com.sinch.sdk.e2e.domains.verification.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.WebHooksService;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class WebhooksEventsSteps {

  static final String WEBHOOKS_PATH = Config.VERIFICATION_HOST_NAME + "/webhooks/verification/";

  WebHooksService service;

  static VerificationEvent expectedVerificationRequestEvent =
      new VerificationRequestEvent(
          "1ce0ffee-c0de-5eed-d00d-f00dfeed1337",
          VerificationMethodType.SMS,
          NumberIdentity.builder().setEndpoint("+33612345678").build(),
          Price.builder().setCurrencyId("EUR").setAmount(0.0453F).build(),
          null,
          null,
          null);

  static VerificationEvent expectedVerificationResultEvent =
      new VerificationResultEvent(
          "1ce0ffee-c0de-5eed-d00d-f00dfeed1337",
          VerificationMethodType.SMS,
          NumberIdentity.builder().setEndpoint("+33612345678").build(),
          null,
          null,
          VerificationStatusType.SUCCESSFUL,
          null,
          null);

  static Map<String, String> triggerToURL =
      Stream.of(
              new AbstractMap.SimpleEntry<>(
                  "Verification Request", WEBHOOKS_PATH + "verification-request-event"),
              new AbstractMap.SimpleEntry<>(
                  "Verification Result", WEBHOOKS_PATH + "verification-result-event"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  static Map<String, VerificationEvent> triggerToExpectedEvents =
      Stream.of(
              new AbstractMap.SimpleEntry<>(
                  "Verification Request", expectedVerificationRequestEvent),
              new AbstractMap.SimpleEntry<>("Verification Result", expectedVerificationResultEvent))
          .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

  Map<String, WebhooksHelper.Response<VerificationEvent>> receivedEvents =
      new ConcurrentHashMap<>();

  @Given("^the Verification Webhooks handler is available$")
  public void serviceAvailable() {

    service = Config.getSinchClient().verification().webhooks();
  }

  @When("I send a request to trigger a {string} event")
  public void triggerEvent(String trigger) throws IOException {

    WebhooksHelper.Response<VerificationEvent> response =
        WebhooksHelper.callURL(new URL(triggerToURL.get(trigger)), service::parseEvent);
    receivedEvents.put(trigger, response);
  }

  @Then("the header of the Verification event {string} contains a valid authorization")
  public void validateEventSignature(String trigger) {

    WebhooksHelper.Response<VerificationEvent> receivedEvent = receivedEvents.get(trigger);

    boolean validated =
        service.validateAuthenticationHeader(
            "POST", "/webhooks/verification", receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the Verification event describes a {string} event type")
  public void validateResult(String trigger) {

    VerificationEvent expected = triggerToExpectedEvents.get(trigger);
    VerificationEvent receivedEvent = receivedEvents.get(trigger).event;

    TestHelpers.recursiveEquals(receivedEvent, expected);
  }
}
