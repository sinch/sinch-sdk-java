package com.sinch.sdk.e2e.domains.numbers.v1;

import com.sinch.sdk.domains.numbers.api.v1.SinchEventsService;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent.EventTypeEnum;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent.FailureCodeEnum;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent.StatusEnum;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.ResourceType;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class SinchEventsSteps {

  static final String WEBHOOKS_PATH = Config.NUMBERS_HOST_NAME + "/webhooks/numbers/";
  static final String SECRET = "strongPa$$PhraseWith36CharactersMax";

  SinchEventsService service;

  Map<String, String> triggerToURL =
      Stream.of(
              new AbstractMap.SimpleEntry<>(
                  "success_" + EventTypeEnum.PROVISIONING_TO_VOICE_PLATFORM.value(),
                  WEBHOOKS_PATH + "provisioning_to_voice_platform/succeeded"),
              new AbstractMap.SimpleEntry<>(
                  "failure_" + EventTypeEnum.PROVISIONING_TO_VOICE_PLATFORM.value(),
                  WEBHOOKS_PATH + "provisioning_to_voice_platform/failed"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  Map<String, WebhooksHelper.Response<NumberSinchEvent>> receivedEvents = new ConcurrentHashMap<>();

  @Given("^the Numbers Webhooks handler is available$")
  public void serviceAvailable() {

    service = Config.getSinchClient().numbers().v1().sinchEvents();
  }

  @When("I send a request to trigger the {string} for {string} event")
  public void triggerEvent(String status, String trigger) throws IOException {

    WebhooksHelper.Response<NumberSinchEvent> response =
        WebhooksHelper.callURL(
            new URL(triggerToURL.get(status + "_" + trigger)), service::parseEvent);
    receivedEvents.put(status + "_" + trigger, response);
  }

  @Then("the header of the {string} for {string} event contains a valid signature")
  public void validateEventSignature(String status, String trigger) {

    WebhooksHelper.Response<NumberSinchEvent> receivedEvent =
        receivedEvents.get(status + "_" + trigger);

    boolean validated =
        service.validateAuthenticationHeader(
            SECRET, receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the event describes a {string} for {string} event")
  public void validateResult(String status, String trigger) {

    NumberSinchEvent expectedSuccess =
        NumberSinchEvent.builder()
            .setEventId("01j1wefx7p3wf2r3x6h4dh6hh9")
            .setTimestamp(Instant.parse("2024-06-06T14:42:42.846638361Z"))
            .setProjectId("12c0ffee-dada-beef-cafe-baadc0de5678")
            .setResourceId("+12015555555")
            .setResourceType(ResourceType.ACTIVE_NUMBER)
            .setEventType(EventTypeEnum.PROVISIONING_TO_VOICE_PLATFORM)
            .setStatus(StatusEnum.SUCCEEDED)
            .setFailureCode(null)
            .setInternalFailureCode(null)
            .build();

    NumberSinchEvent expectedFailure =
        NumberSinchEvent.builder()
            .setEventId("01j1wf89pq3zy4xe81wg1jhjyx")
            .setTimestamp(Instant.parse("2024-06-06T14:42:42.047675109Z"))
            .setProjectId("12c0ffee-dada-beef-cafe-baadc0de5678")
            .setResourceId("+12015555555")
            .setResourceType(ResourceType.ACTIVE_NUMBER)
            .setEventType(EventTypeEnum.PROVISIONING_TO_VOICE_PLATFORM)
            .setStatus(StatusEnum.FAILED)
            .setFailureCode(FailureCodeEnum.from("PROVISIONING_TO_VOICE_PLATFORM_FAILED"))
            .setInternalFailureCode(null)
            .build();

    NumberSinchEvent expected =
        Objects.equals(status, "success") ? expectedSuccess : expectedFailure;
    NumberSinchEvent receivedEvent = receivedEvents.get(status + "_" + trigger).event;

    Assertions.assertEquals(expected, receivedEvent);
  }
}
