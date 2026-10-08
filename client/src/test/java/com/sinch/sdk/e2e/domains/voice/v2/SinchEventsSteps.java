package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.SinchEventsService;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.CallDirection;
import com.sinch.sdk.domains.voice.models.v2.CallResult;
import com.sinch.sdk.domains.voice.models.v2.CallType;
import com.sinch.sdk.domains.voice.models.v2.Money;
import com.sinch.sdk.domains.voice.models.v2.OriginationType;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.SinchEventType;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public class SinchEventsSteps {

  static final String SERVICE_ID = "serviceKey";
  static final String SERVICE_SECRET = "BeIukql3pTKJ8RGL5zo0DA==";
  static final String WEBHOOKS_PATH_PREFIX = "/webhooks/voice-v2";

  SinchEventsService service;

  Map<String, WebhooksHelper.Response<VoiceSinchEvent>> receivedEvents = new HashMap<>();

  static Call.Builder baseCall() {
    return Call.builder()
        .setCallId("01HZXK7QNPMR8VD3JW9YF2C4CA")
        .setServiceId("f9e8d7c6-b5a4-4321-9876-c5d4e3f2a1b0")
        .setProjectId("a1b2c3d4-e5f6-4789-a012-b3c4d5e6f789")
        .setSessionId("01HZXK7QNPMR8VD3JW9YF2C4TB")
        .setCallType(CallType.PHONE)
        .setStartTime(Instant.parse("2026-09-04T10:14:55Z"))
        .setCallRate(Money.builder().setCurrencyCode("EUR").setAmount("0.0095").build())
        .setCallResourceUrl(
            "/v2/projects/a1b2c3d4-e5f6-4789-a012-b3c4d5e6f789/calls/01HZXK7QNPMR8VD3JW9YF2C4CA");
  }

  static final Call incomingCall =
      baseCall()
          .setFrom(Phone.builder().setNumber("+12015555555").build())
          .setTo(Phone.builder().setNumber("+12017777777").build())
          .setDirection(CallDirection.INBOUND)
          .setCallResult(CallResult.INITIATED)
          .setOriginationType(OriginationType.PHONE)
          .build();

  static final Call answeredCall =
      baseCall()
          .setFrom(Phone.builder().setNumber("+12017777777").build())
          .setTo(Phone.builder().setNumber("+12015555555").build())
          .setDirection(CallDirection.OUTBOUND)
          .setCallResult(CallResult.IN_PROGRESS)
          .setOriginationType(OriginationType.SERVER)
          .setAnswerTime(Instant.parse("2026-09-04T10:14:58Z"))
          .setUpdateTime(Instant.parse("2026-09-04T10:14:58Z"))
          .build();

  static final Map<String, VoiceSinchEvent> expectedEvents = new HashMap<>();

  static {
    expectedEvents.put(
        "call.incoming",
        VoiceSinchEvent.builder()
            .setEvent(SinchEventType.CALL_INCOMING)
            .setCall(incomingCall)
            .build());
    expectedEvents.put(
        "call.answered",
        VoiceSinchEvent.builder()
            .setEvent(SinchEventType.CALL_ANSWERED)
            .setCall(answeredCall)
            .build());
    expectedEvents.put(
        "call.webhook.on-answer",
        VoiceSinchEvent.builder()
            .setEvent(SinchEventType.from("call.customEvent.on-answer"))
            .setCall(answeredCall)
            .build());
  }

  static final VoiceSinchEventResponse onAnswerResponse =
      VoiceSinchEventResponse.builder()
          .setCommands(
              Collections.singletonList(
                  MessagesCommand.builder()
                      .setMessagesName("from-webhook-server")
                      .setMessages(
                          Collections.singletonList(
                              SayMessage.builder()
                                  .setText("This message came from your local webhook server.")
                                  .setVoiceName("Emma")
                                  .build()))
                      .setEvents(
                          MessageEvents.builder()
                              .setOnFinish(
                                  Collections.singletonList(HangupCommand.builder().build()))
                              .build())
                      .build()))
          .build();

  // "call.webhook.on-answer" is served at "/webhooks/voice-v2/call/webhook/on-answer"
  static String pathOf(String event) {
    return WEBHOOKS_PATH_PREFIX + "/" + event.replace('.', '/');
  }

  @Given("^the Voice-V2 Webhooks handler is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v2().sinchEvents();
  }

  @When("I send a request to trigger a {string} event")
  public void sendEvent(String event) throws IOException {
    receivedEvents.put(
        event,
        WebhooksHelper.callURL(
            new URL(Config.VOICE_V2_HOST_NAME + pathOf(event)), service::parseEvent));
  }

  @Then("the header of the {string} event contains a valid authorization")
  public void validateHeader(String event) {
    WebhooksHelper.Response<VoiceSinchEvent> received = receivedEvents.get(event);

    boolean validated =
        service.validateAuthenticationHeader(
            SERVICE_ID,
            SERVICE_SECRET,
            "POST",
            pathOf(event),
            received.headers,
            received.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the Voice-V2 event describes a {string} event")
  public void validateEvent(String event) {
    TestHelpers.recursiveEquals(receivedEvents.get(event).event, expectedEvents.get(event));
  }

  @Then("the response to the {string} event matches the expected call control instructions")
  public void validateResponse(String event) throws IOException {
    Assertions.assertEquals("call.webhook.on-answer", event);

    int status =
        WebhooksHelper.postJson(
            new URL(Config.VOICE_V2_HOST_NAME + pathOf(event) + "/confirm"),
            service.serializeResponse(onAnswerResponse));
    Assertions.assertEquals(200, status);
  }
}
