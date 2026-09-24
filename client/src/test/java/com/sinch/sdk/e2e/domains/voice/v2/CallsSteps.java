package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.CallsService;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.destination.PhoneDetails;
import com.sinch.sdk.domains.voice.models.v2.svaml.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.Play;
import com.sinch.sdk.domains.voice.models.v2.svaml.PlayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.Say;
import com.sinch.sdk.domains.voice.models.v2.svaml.SayMessage;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class CallsSteps {

  CallsService service;
  StartCallResponse startResponse;

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
                        .setPlay(
                            Play.builder()
                                .setUrl("https://samplelib.com/mp3/sample-12s.mp3")
                                .build())
                        .build(),
                    SayMessage.builder()
                        .setSay(
                            Say.builder()
                                .setText(
                                    "Hello! This is a test notification from Sinch. Your"
                                        + " verification code is 4 8 3 7.")
                                .setVoiceName("Emma")
                                .build())
                        .build()))
            .setEvents(
                MessageEvents.builder()
                    .setOnFinish(Collections.singletonList(HangupCommand.builder().build()))
                    .build())
            .build();

    DialCommand dial =
        DialCommand.builder()
            .setCallName("audio-notification")
            .setFrom(
                Phone.builder()
                    .setPhone(PhoneDetails.builder().setNumber("+12015555555").build())
                    .build())
            .setTo(
                Phone.builder()
                    .setPhone(PhoneDetails.builder().setNumber("+12017777777").build())
                    .build())
            .setDialTimeoutDurationSeconds(30)
            .setMaxCallDurationSeconds(300)
            .setEvents(
                CallEvents.builder().setOnAnswer(Collections.singletonList(notification)).build())
            .build();

    // No Idempotency-Key set: the mock requires one, so this also checks the SDK generates it.
    startResponse =
        service.start(
            StartCallRequest.builder().setCommands(Collections.singletonList(dial)).build());
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
}
