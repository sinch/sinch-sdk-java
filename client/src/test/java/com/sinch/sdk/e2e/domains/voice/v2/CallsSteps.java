package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.CallsService;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.CallDirection;
import com.sinch.sdk.domains.voice.models.v2.CallReason;
import com.sinch.sdk.domains.voice.models.v2.CallResult;
import com.sinch.sdk.domains.voice.models.v2.CallType;
import com.sinch.sdk.domains.voice.models.v2.Money;
import com.sinch.sdk.domains.voice.models.v2.OriginationType;
import com.sinch.sdk.domains.voice.models.v2.calls.request.CallPatchRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.ListCallsQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.CallsListResponse;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.PlayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class CallsSteps {

  CallsService service;
  StartCallResponse startResponse;
  Call getResponse;
  CallsListResponse listOnePageResponse;
  boolean interactionAccepted;

  @Given("^the Voice-V2 service \"Calls\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v2().calls();
    Assertions.assertNotNull(service, "Voice V2 Calls service is not available");
  }

  @When("^I send a request to start a call$")
  public void start() {
    MessagesCommand notification =
        MessagesCommand.builder()
            .setMessagesName("notification")
            .setMessages(
                Arrays.asList(
                    PlayMessage.builder()
                        .setUrl("https://samplelib.com/mp3/sample-12s.mp3")
                        .build(),
                    SayMessage.builder()
                        .setText(
                            "Hello! This is a test notification from Sinch. Your"
                                + " verification code is 4 8 3 7.")
                        .setVoiceName("Emma")
                        .build()))
            .setEvents(
                MessageEvents.builder()
                    .setOnFinish(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    DialCommand dial =
        DialCommand.builder()
            .setCallName("audio-notification")
            .setFrom(Phone.builder().setNumber("+12015555555").build())
            .setTo(Phone.builder().setNumber("+12017777777").build())
            .setDialTimeoutDurationSeconds(30)
            .setMaxCallDurationSeconds(300)
            .setEvents(
                CallEvents.builder().setOnAnswer(Collections.singletonList(notification)).build())
            .build();

    startResponse =
        service.start(
            StartCallRequest.builder()
                .setCommands(Collections.singletonList(dial))
                .setIdempotencyKey("3f1c7a52-8d3e-4b9a-9c0e-2f6d1b7a4e21")
                .build());
  }

  @Then("^the response contains the information about the call started$")
  public void startResult() {
    StartCallResponse expected =
        StartCallResponse.builder()
            .setProjectId("a1b2c3d4-e5f6-4789-a012-b3c4d5e6f789")
            .setServiceId("f9e8d7c6-b5a4-4321-9876-c5d4e3f2a1b0")
            .setSessionId("01HZXK7QNPMR8VD3JW9YF2C4TB")
            .build();

    TestHelpers.recursiveEquals(startResponse, expected);
  }

  @When("^I send a request to get call details$")
  public void get() {
    getResponse = service.get("01HZXK8FQNPMR8VD3JW9YF2C5A");
  }

  @Then("^the response contains the call details$")
  public void getResult() {
    Call expected =
        Call.builder()
            .setCallId("01HZXK8FQNPMR8VD3JW9YF2C5A")
            .setServiceId("f9e8d7c6-b5a4-4321-9876-c5d4e3f2a1b0")
            .setProjectId("a1b2c3d4-e5f6-4789-a012-b3c4d5e6f789")
            .setCallName("audio-notification")
            .setSessionId("01HZXK7QNPMR8VD3JW9YF2C4TB")
            .setFrom(Phone.builder().setNumber("+12015555555").build())
            .setTo(Phone.builder().setNumber("+12017777777").build())
            .setDirection(CallDirection.OUTBOUND)
            .setCallResult(CallResult.NO_ANSWER)
            .setCallType(CallType.PHONE)
            .setOriginationType(OriginationType.SERVER)
            .setStartTime(Instant.parse("2026-09-14T10:24:34Z"))
            .setEndTime(Instant.parse("2026-09-14T10:24:49Z"))
            .setUpdateTime(Instant.parse("2026-09-14T10:24:49Z"))
            .setCallDurationSeconds(0)
            .setCallRate(Money.builder().setCurrencyCode("EUR").setAmount("0.4085").build())
            .setCallReason(CallReason.NOT_AVAILABLE)
            .setCallResourceUrl(
                "https://eu1.voice.api.sinch.com/v2/projects/a1b2c3d4-e5f6-4789-a012-b3c4d5e6f789/calls/01HZXK8FQNPMR8VD3JW9YF2C5A")
            .build();

    TestHelpers.recursiveEquals(getResponse, expected);
  }

  @When("^I send a request to list calls$")
  public void listOnePage() {
    listOnePageResponse = service.list(ListCallsQueryParameters.builder().setPageSize(2).build());
  }

  @When("^I send a request to list all the calls$")
  public void listAll() {
    listOnePageResponse = service.list(ListCallsQueryParameters.builder().setPageSize(2).build());
  }

  @When("^I iterate manually over the calls pages$")
  public void listAllByPage() {
    listOnePageResponse = service.list(ListCallsQueryParameters.builder().setPageSize(2).build());
  }

  @Then("the response content contains \"{int}\" calls")
  public void onePageResult(int expected) {

    Assertions.assertEquals(expected, listOnePageResponse.getContent().size());
  }

  @Then("the calls list contains \"{int}\" calls")
  public void listAllResult(int expected) {

    AtomicInteger count = new AtomicInteger();
    listOnePageResponse.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(expected, count.get());
  }

  @Then("the calls iteration result contains the data from \"{int}\" pages")
  public void listAllByPageResult(int expected) {

    int count = listOnePageResponse.getContent().isEmpty() ? 0 : 1;
    CallsListResponse currentPage = listOnePageResponse;
    while (currentPage.hasNextPage()) {
      count++;
      currentPage = currentPage.nextPage();
    }
    Assertions.assertEquals(expected, count);
  }

  @When("^I send a request to interact with an ongoing call by call ID$")
  public void interactByCallId() {
    MessagesCommand messages =
        MessagesCommand.builder()
            .setMessages(
                Collections.singletonList(
                    SayMessage.builder()
                        .setText("Hello, your call is now connected.")
                        .setVoiceName("Emma")
                        .build()))
            .setEvents(
                MessageEvents.builder()
                    .setOnFinish(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    service.interactByCallId(
        "01HZXK8FQNPMR8VD3JW9YF2C5A",
        CallPatchRequest.builder()
            .setCommands(Collections.singletonList(messages))
            .setIdempotencyKey("5d8f2a6c-1e4b-4c9d-8a3f-7b6e0c2d9f14")
            .build());
    interactionAccepted = true;
  }

  @When("^I send a request to interact with an ongoing call by call name$")
  public void interactByCallName() {
    MessagesCommand messages =
        MessagesCommand.builder()
            .setMessages(
                Collections.singletonList(
                    SayMessage.builder()
                        .setText("Hello, your call is now connected.")
                        .setVoiceName("Emma")
                        .build()))
            .setEvents(
                MessageEvents.builder()
                    .setOnFinish(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    service.interactByCallName(
        "01HZXK8FQNPMR8VD3JW9YF2C5B",
        "origin",
        CallPatchRequest.builder()
            .setCommands(Collections.singletonList(messages))
            .setIdempotencyKey("7c1e9b4a-3f2d-4e8a-9b6c-0d5f8a2e1c37")
            .build());
    interactionAccepted = true;
  }

  @Then("^the response confirms the interaction request was accepted$")
  public void interactResult() {
    Assertions.assertTrue(interactionAccepted);
  }
}
