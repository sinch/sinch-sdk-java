package com.sinch.sdk.e2e.domains.voice.v0;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.WebHooksService;
import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationNumberType;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.MenuInputType;
import com.sinch.sdk.domains.voice.models.webhooks.MenuResult;
import com.sinch.sdk.domains.voice.models.webhooks.MenuResultInputMethodType;
import com.sinch.sdk.domains.voice.models.webhooks.PromptInputEvent;
import com.sinch.sdk.domains.voice.models.webhooks.WebhooksEvent;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import com.sinch.sdk.models.E164PhoneNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import org.junit.jupiter.api.Assertions;

public class WebhooksEventsSteps {

  static final String WEBHOOKS_PATH_PREFIX = "/webhooks/voice";
  static final String WEBHOOKS_URL = Config.VOICE_HOST_NAME + WEBHOOKS_PATH_PREFIX;

  WebHooksService service;

  WebhooksHelper.Response<WebhooksEvent> pieReturn;
  WebhooksHelper.Response<WebhooksEvent> pieSequence;
  WebhooksHelper.Response<WebhooksEvent> diceEvent;
  WebhooksHelper.Response<WebhooksEvent> aceEvent;
  WebhooksHelper.Response<WebhooksEvent> iceEvent;

  PromptInputEvent expectedPieReturnEvent =
      PromptInputEvent.builder()
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000013")
          .setTimestamp(Instant.parse("2024-06-06T17:35:01Z"))
          .setVersion(1)
          .setCustom("Custom text")
          .setMenuResult(
              MenuResult.builder()
                  .setType(MenuInputType.RETURN)
                  .setValue("cancel")
                  .setMenuId("main")
                  .setInputMethod(MenuResultInputMethodType.DTMF)
                  .build())
          .build();

  PromptInputEvent expectedPieSequenceEvent =
      PromptInputEvent.builder()
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000023")
          .setTimestamp(Instant.parse("2024-06-06T17:35:58Z"))
          .setVersion(1)
          .setCustom("Custom text")
          .setMenuResult(
              MenuResult.builder()
                  .setType(MenuInputType.SEQUENCE)
                  .setValue("1234")
                  .setMenuId("confirm")
                  .setInputMethod(MenuResultInputMethodType.DTMF)
                  .build())
          .build();

  WebhooksEvent expectedDiceEvent =
      DisconnectCallEvent.builder()
          .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000033")
          .setTimestamp(Instant.parse("2024-06-06T16:59:42Z"))
          .setReason(CallReasonType.MANAGER_HANGUP)
          .setResult(CallResultType.ANSWERED)
          .setVersion(1)
          .setCustom("Custom text")
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.0095F).build())
          .setUserRate(Price.builder().setCurrencyId("EUR").setAmount(0.0095F).build())
          .setTo(DestinationNumber.valueOf("12017777777"))
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setDuration(12)
          .setFrom("12015555555")
          .build();
  WebhooksEvent expectedAceEvent =
      AnsweredCallEvent.builder()
          .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000043")
          .setTimestamp(Instant.parse("2024-06-06T17:10:34Z"))
          .setVersion(1)
          .setCustom("Custom text")
          .build();

  IncomingCallEvent expectedIceEvent =
      IncomingCallEvent.builder()
          .setCallId("1ce0ffee-ca11-ca11-ca11-abcdef000053")
          .setCallResourceUrl(
              "https://calling-use1.api.sinch.com/calling/v1/calls/id/1ce0ffee-ca11-ca11-ca11-abcdef000053")
          .setTimestamp(Instant.parse("2024-06-06T17:20:14Z"))
          .setVersion(1)
          .setUserRate(Price.builder().setCurrencyId("USD").setAmount(0.0F).build())
          .setCli("12015555555")
          .setTo(
              new DestinationNumber(
                  E164PhoneNumber.valueOf("+12017777777"), DestinationNumberType.DID))
          .setDomain(DomainType.PSTN)
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setOriginationType(DomainType.PSTN)
          .setRdnis("")
          .build();

  @Given("^the Voice Webhooks handler is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().webhooks();
  }

  @When("^I send a request to trigger a \"PIE\" event with a \"return\" type$")
  public void sendPieReturn() throws IOException {
    pieReturn =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/pie-return"), service::unserializeWebhooksEvent);
  }

  @When("^I send a request to trigger a \"PIE\" event with a \"sequence\" type$")
  public void sendPieSequence() throws IOException {
    pieSequence =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/pie-sequence"), service::unserializeWebhooksEvent);
  }

  @When("^I send a request to trigger a \"DICE\" event$")
  public void sendDICEEvent() throws IOException {
    diceEvent =
        WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/dice"), service::unserializeWebhooksEvent);
  }

  @When("^I send a request to trigger a \"ACE\" event$")
  public void sendACEEvent() throws IOException {
    aceEvent =
        WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/ace"), service::unserializeWebhooksEvent);
  }

  @When("^I send a request to trigger a \"ICE\" event$")
  public void sendICEEvent() throws IOException {
    iceEvent =
        WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/ice"), service::unserializeWebhooksEvent);
  }

  @Then("the header of the {string} event with a {string} type contains a valid authorization")
  public void validatePieHeader(String event, String type) {

    WebhooksHelper.Response<?> receivedEvent = null;
    if (event.equals("PIE") && type.equals("return")) {
      receivedEvent = pieReturn;
    } else if (event.equals("PIE") && type.equals("sequence")) {
      receivedEvent = pieSequence;
    } else {
      Assertions.fail();
    }
    boolean validated =
        service.validateAuthenticatedRequest(
            "POST", WEBHOOKS_PATH_PREFIX, receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the header of the {string} event contains a valid authorization")
  public void validateHeader(String event) {

    WebhooksHelper.Response<?> receivedEvent = null;
    if (event.equals("DICE")) {
      receivedEvent = diceEvent;
    } else if (event.equals("ACE")) {
      receivedEvent = aceEvent;
    } else if (event.equals("ICE")) {
      receivedEvent = iceEvent;
    } else {
      Assertions.fail();
    }
    boolean validated =
        service.validateAuthenticatedRequest(
            "POST", WEBHOOKS_PATH_PREFIX, receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the Voice event describes a {string} event with a {string} type")
  public void validatePieEvent(String event, String type) {

    WebhooksHelper.Response<?> receivedEvent = null;
    WebhooksEvent expectedEvent = null;
    if (event.equals("PIE") && type.equals("return")) {
      receivedEvent = pieReturn;
      expectedEvent = expectedPieReturnEvent;
    } else if (event.equals("PIE") && type.equals("sequence")) {
      receivedEvent = pieSequence;
      expectedEvent = expectedPieSequenceEvent;
    } else {
      Assertions.fail();
    }

    TestHelpers.recursiveEquals(expectedEvent, receivedEvent.event);
  }

  @Then("the Voice event describes a {string} event")
  public void validateEvent(String event) {

    WebhooksHelper.Response<?> receivedEvent = null;
    WebhooksEvent expectedEvent = null;
    if (event.equals("DICE")) {
      receivedEvent = diceEvent;
      expectedEvent = expectedDiceEvent;
    } else if (event.equals("ACE")) {
      receivedEvent = aceEvent;
      expectedEvent = expectedAceEvent;
    } else if (event.equals("ICE")) {
      receivedEvent = iceEvent;
      expectedEvent = expectedIceEvent;
    } else {
      Assertions.fail();
    }

    TestHelpers.recursiveEquals(expectedEvent, receivedEvent.event);
  }
}
