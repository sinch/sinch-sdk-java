package com.sinch.sdk.e2e.domains.voice.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v1.WebHooksService;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.Price;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallResult;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationDid;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent.ReasonEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.MenuResult;
import com.sinch.sdk.domains.voice.models.v1.webhooks.MenuResult.InputMethodEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.MenuResult.TypeEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.NotificationEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.PromptInputEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.VoiceWebhookEvent;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
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

  WebhooksHelper.Response<VoiceWebhookEvent> pieReturn;
  WebhooksHelper.Response<VoiceWebhookEvent> pieSequence;
  WebhooksHelper.Response<VoiceWebhookEvent> diceEvent;
  WebhooksHelper.Response<VoiceWebhookEvent> aceEvent;
  WebhooksHelper.Response<VoiceWebhookEvent> iceEvent;
  WebhooksHelper.Response<VoiceWebhookEvent> recordingFinishedEvent;
  WebhooksHelper.Response<VoiceWebhookEvent> recordingAvailableEvent;
  WebhooksHelper.Response<VoiceWebhookEvent> transcriptionAvailableEvent;

  PromptInputEvent expectedPieReturnEvent =
      PromptInputEvent.builder()
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setCallid("1ce0ffee-ca11-ca11-ca11-abcdef000013")
          .setTimestamp(Instant.parse("2024-06-06T17:35:01Z"))
          .setVersion(1)
          .setCustom("Custom text")
          .setMenuResult(
              MenuResult.builder()
                  .setType(TypeEnum.RETURN)
                  .setValue("cancel")
                  .setMenuId("main")
                  .setInputMethod(InputMethodEnum.DTMF)
                  .build())
          .build();

  PromptInputEvent expectedPieSequenceEvent =
      PromptInputEvent.builder()
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setCallid("1ce0ffee-ca11-ca11-ca11-abcdef000023")
          .setTimestamp(Instant.parse("2024-06-06T17:35:58Z"))
          .setVersion(1)
          .setCustom("Custom text")
          .setMenuResult(
              MenuResult.builder()
                  .setType(TypeEnum.SEQUENCE)
                  .setValue("1234")
                  .setMenuId("confirm")
                  .setInputMethod(InputMethodEnum.DTMF)
                  .build())
          .build();

  DisconnectedCallEvent expectedDiceEvent =
      DisconnectedCallEvent.builder()
          .setCallid("1ce0ffee-ca11-ca11-ca11-abcdef000033")
          .setTimestamp(Instant.parse("2024-06-06T16:59:42Z"))
          .setReason(ReasonEnum.MANAGERHANGUP)
          .setResult(CallResult.ANSWERED)
          .setVersion(1)
          .setCustom("Custom text")
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.0095F).build())
          .setUserRate(Price.builder().setCurrencyId("EUR").setAmount(0.0095F).build())
          .setTo(DestinationPstn.from("12017777777"))
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setDuration(12)
          .setFrom("12015555555")
          .build();
  AnsweredCallEvent expectedAceEvent =
      AnsweredCallEvent.builder()
          .setCallid("1ce0ffee-ca11-ca11-ca11-abcdef000043")
          .setTimestamp(Instant.parse("2024-06-06T17:10:34Z"))
          .setVersion(1)
          .setCustom("Custom text")
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .build();

  IncomingCallEvent expectedIceEvent =
      IncomingCallEvent.builder()
          .setCallid("1ce0ffee-ca11-ca11-ca11-abcdef000053")
          .setCallResourceUrl(
              "https://calling-use1.api.sinch.com/calling/v1/calls/id/1ce0ffee-ca11-ca11-ca11-abcdef000053")
          .setTimestamp(Instant.parse("2024-06-06T17:20:14Z"))
          .setVersion(1)
          .setUserRate(Price.builder().setCurrencyId("USD").setAmount(0.0F).build())
          .setCli("12015555555")
          .setTo(DestinationDid.from("+12017777777"))
          .setDomain(Domain.PSTN)
          .setApplicationKey("f00dcafe-abba-c0de-1dea-dabb1ed4caf3")
          .setOriginationType(Domain.PSTN2)
          .setRdnis("")
          .build();

  NotificationEvent expectedRecordingFinishedEvent =
      NotificationEvent.builder()
          .setCallid("33dd8e62-0ac6-4e0c-a89f-36d121f861f9")
          .setVersion(1)
          .setType("recording_finished")
          .build();

  NotificationEvent expectedRecordingAvailableEvent =
      NotificationEvent.builder()
          .setCallid("33dd8e62-0ac6-4e0c-a89f-36d121f861f9")
          .setVersion(1)
          .setType("recording_available")
          .setDestination("azure://sinchsdk/voice-recordings/my-recording.mp3")
          .build();

  NotificationEvent expectedTranscriptionAvailableEvent =
      NotificationEvent.builder()
          .setCallid("33dd8e62-0ac6-4e0c-a89f-36d121f861f9")
          .setVersion(1)
          .setType("transcription_available")
          .setDestination("azure://sinchsdk/voice-recordings/my-recording-transcript.json")
          .build();

  @Given("^the Voice Webhooks handler is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v1().webhooks();
  }

  @When("^I send a request to trigger a \"PIE\" event with a \"return\" type$")
  public void sendPieReturn() throws IOException {
    pieReturn = WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/pie-return"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"PIE\" event with a \"sequence\" type$")
  public void sendPieSequence() throws IOException {
    pieSequence =
        WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/pie-sequence"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"DICE\" event$")
  public void sendDICEEvent() throws IOException {
    diceEvent = WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/dice"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"ACE\" event$")
  public void sendACEEvent() throws IOException {
    aceEvent = WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/ace"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"ICE\" event$")
  public void sendICEEvent() throws IOException {
    iceEvent = WebhooksHelper.callURL(new URL(WEBHOOKS_URL + "/ice"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"recording_finished\" event$")
  public void sendRecordingFinishedEvent() throws IOException {
    recordingFinishedEvent =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/notify/recording_finished"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"recording_available\" event$")
  public void sendRecordingAvailableEvent() throws IOException {
    recordingAvailableEvent =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/notify/recording_available"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"transcription_available\" event$")
  public void sendTranscriptionAvailableEvent() throws IOException {
    transcriptionAvailableEvent =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_URL + "/notify/transcription_available"), service::parseEvent);
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
        service.validateAuthenticationHeader(
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
    } else if (event.equals("recording_finished")) {
      receivedEvent = recordingFinishedEvent;
    } else if (event.equals("recording_available")) {
      receivedEvent = recordingAvailableEvent;
    } else if (event.equals("transcription_available")) {
      receivedEvent = transcriptionAvailableEvent;
    } else {
      Assertions.fail();
    }
    boolean validated =
        service.validateAuthenticationHeader(
            "POST", WEBHOOKS_PATH_PREFIX, receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the Voice event describes a {string} event with a {string} type")
  public void validateTypeEvent(String event, String type) {

    WebhooksHelper.Response<?> receivedEvent = null;
    VoiceWebhookEvent expectedEvent = null;
    if (event.equals("PIE") && type.equals("return")) {
      receivedEvent = pieReturn;
      expectedEvent = expectedPieReturnEvent;
    } else if (event.equals("PIE") && type.equals("sequence")) {
      receivedEvent = pieSequence;
      expectedEvent = expectedPieSequenceEvent;
    } else if (event.equals("notify") && type.equals("recording_finished")) {
      receivedEvent = recordingFinishedEvent;
      expectedEvent = expectedRecordingFinishedEvent;
    } else if (event.equals("notify") && type.equals("recording_available")) {
      receivedEvent = recordingAvailableEvent;
      expectedEvent = expectedRecordingAvailableEvent;
    } else if (event.equals("notify") && type.equals("transcription_available")) {
      receivedEvent = transcriptionAvailableEvent;
      expectedEvent = expectedTranscriptionAvailableEvent;
    } else {
      Assertions.fail();
    }

    TestHelpers.recursiveEquals(expectedEvent, receivedEvent.event);
  }

  @Then("the Voice event describes a {string} event")
  public void validateEvent(String event) {

    WebhooksHelper.Response<?> receivedEvent = null;
    VoiceWebhookEvent expectedEvent = null;
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
