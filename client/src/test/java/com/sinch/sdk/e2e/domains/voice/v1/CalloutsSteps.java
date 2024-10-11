package com.sinch.sdk.e2e.domains.voice.v1;

import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.Menu;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOption;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOptionActionFactory;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionRunMenu;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStartRecording;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class CalloutsSteps {

  CalloutsService service;
  String ttsResponse;
  String conferenceResponse;
  String customResponse;

  @Given("^the Voice service \"Callouts\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v1().callouts();
  }

  @When("^I send a request to make a TTS call$")
  public void createTTS() {

    CalloutRequestTTS request =
        CalloutRequestTTS.builder()
            .setLocale("en-US")
            .setDestination(
                Destination.builder()
                    .setType(DestinationType.NUMBER)
                    .setEndpoint("+12017777777")
                    .build())
            .setCli("+12015555555")
            .setText("Hello, this is a call from Sinch.")
            .build();

    ttsResponse = service.textToSpeech(request);
  }

  @When("^I send a request to make a Conference call with the \"Callout\" service$")
  public void createConference() {
    CalloutRequestConference request =
        CalloutRequestConference.builder()
            .setLocale("en-US")
            .setDestination(
                Destination.builder()
                    .setType(DestinationType.NUMBER)
                    .setEndpoint("+12017777777")
                    .build())
            .setCli("+12015555555")
            .setConferenceId("myConferenceId-E2E")
            .setGreeting("Welcome to this conference call.")
            .setMusicOnHold(MusicOnHold.MUSIC1)
            .build();

    conferenceResponse = service.conference(request);
  }

  @When("^I send a request to make a Custom call$")
  public void createCustom() {
    CalloutRequestCustom request =
        CalloutRequestCustom.builder()
            .setDestination(
                Destination.builder()
                    .setType(DestinationType.NUMBER)
                    .setEndpoint("+12017777777")
                    .build())
            .setCli("+12015555555")
            .setCustom("Custom text")
            .setIce(
                SvamlControl.builder()
                    .setAction(
                        SvamlActionConnectPstn.builder()
                            .setNumber("+12017777777")
                            .setCli("+12015555555")
                            .build())
                    .setInstructions(
                        Arrays.asList(
                            SvamlInstructionSay.builder()
                                .setText("Welcome to Sinch.")
                                .setLocale("en-US/male")
                                .build(),
                            SvamlInstructionStartRecording.builder()
                                .setOptions(
                                    StartRecordingOptions.builder()
                                        .setDestinationUrl("To specify")
                                        .setCredentials("To specify")
                                        .build())
                                .build()))
                    .build())
            .setAce(
                SvamlControl.builder()
                    .setAction(
                        SvamlActionRunMenu.builder()
                            .setLocale("Kimberly")
                            .setEnableVoice(true)
                            .setBarge(true)
                            .setMenus(
                                Arrays.asList(
                                    Menu.builder()
                                        .setId("main")
                                        .setMainPrompt(
                                            "#tts[Welcome to the main menu. Press 1 to confirm"
                                                + " order or 2 to cancel]")
                                        .setRepeatPrompt(
                                            "#tts[We didn't get your input, please try again]")
                                        .setTimeoutMills(5000)
                                        .setOptions(
                                            Arrays.asList(
                                                MenuOption.builder()
                                                    .setDtmf("1")
                                                    .setAction(
                                                        MenuOptionActionFactory.build(
                                                            MenuOptionActionFactory
                                                                .MenuOptionActionType.MENU,
                                                            "confirm"))
                                                    .build(),
                                                MenuOption.builder()
                                                    .setDtmf("2")
                                                    .setAction(
                                                        MenuOptionActionFactory.build(
                                                            MenuOptionActionFactory
                                                                .MenuOptionActionType.RETURN,
                                                            "cancel"))
                                                    .build()))
                                        .build(),
                                    Menu.builder()
                                        .setId("confirm")
                                        .setMainPrompt(
                                            "#tts[Thank you for confirming your order. Enter your"
                                                + " 4-digit PIN.]")
                                        .setMaxDigits(4)
                                        .build()))
                            .build())
                    .build())
            .setPie(ControlUrl.from("https://callback-server.com/voice"))
            .build();

    customResponse = service.custom(request);
  }

  @Then("the callout response contains the TTS call ID")
  public void ttsResult() {
    Assertions.assertEquals(ttsResponse, "1ce0ffee-ca11-ca11-ca11-abcdef000001");
  }

  @Then("the callout response contains the Conference call ID")
  public void conferenceResult() {
    Assertions.assertEquals(conferenceResponse, "1ce0ffee-ca11-ca11-ca11-abcdef000002");
  }

  @Then("the callout response contains the Custom call ID")
  public void customResult() {
    Assertions.assertEquals(customResponse, "1ce0ffee-ca11-ca11-ca11-abcdef000003");
  }
}
