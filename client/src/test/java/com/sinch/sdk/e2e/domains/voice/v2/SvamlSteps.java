package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.SvamlService;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessageEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.PlayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.SayMessage;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.DescribeSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class SvamlSteps {

  SvamlService service;
  SvamlDescriptionResponse describeResponse;

  @Given("^the Voice-V2 service \"Svaml\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v2().svaml();
    Assertions.assertNotNull(service, "Voice V2 Svaml service is not available");
  }

  @When("^I send a request to describe a SVAML payload$")
  public void describe() {
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

    describeResponse =
        service.describe(
            DescribeSvamlRequest.builder()
                .setSvaml(SvamlInput.builder().setCommands(Collections.singletonList(dial)).build())
                .build());
  }

  @Then("^the response contains the description of the SVAML payload$")
  public void describeResult() {
    SvamlDescriptionResponse expected =
        SvamlDescriptionResponse.builder()
            .setDescription(
                "1. A new call with name 'audio-notification' will be initiated to number"
                    + " +12017777777 with max duration set to 5 minutes.\n"
                    + " * on answer:\n"
                    + "     1. An audio file will be played from"
                    + " https://samplelib.com/mp3/sample-12s.mp3.\n"
                    + "     1. A TTS message will be played using the voice Emma.\n"
                    + "      * on finish:\n"
                    + "          1. The call will be disconnected")
            .build();

    TestHelpers.recursiveEquals(describeResponse, expected);
  }
}
