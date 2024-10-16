package com.sinch.sdk.e2e.domains.voice.v0;

import com.sinch.sdk.domains.voice.CalloutsService;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTS;
import com.sinch.sdk.domains.voice.models.requests.ControlUrl;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStartRecording;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionAction;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.svaml.StartRecordingOptions;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
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
    service = Config.getSinchClient().voice().callouts();
  }

  @When("^I send a request to make a TTS call$")
  public void createTTS() {

    CalloutRequestParametersTTS request =
        CalloutRequestParametersTTS.builder()
            .setLocale("en-US")
            .setDestination(DestinationNumber.valueOf("+12017777777"))
            .setCli(E164PhoneNumber.valueOf("+12015555555"))
            .setText("Hello, this is a call from Sinch.")
            .build();

    ttsResponse = service.textToSpeech(request);
  }

  @When("^I send a request to make a Conference call with the \"Callout\" service$")
  public void createConference() {
    CalloutRequestParametersConference request =
        CalloutRequestParametersConference.builder()
            .setLocale("en-US")
            .setDestination(DestinationNumber.valueOf("+12017777777"))
            .setCli(E164PhoneNumber.valueOf("+12015555555"))
            .setConferenceId("myConferenceId-E2E")
            .setGreeting("Welcome to this conference call.")
            .setMusicOnHold(MusicOnHoldType.MUSIC1)
            .build();

    conferenceResponse = service.conference(request);
  }

  @When("^I send a request to make a Custom call$")
  public void createCustom() {
    CalloutRequestParametersCustom request =
        CalloutRequestParametersCustom.builder()
            .setDestination(DestinationNumber.valueOf("+12017777777"))
            .setCli(E164PhoneNumber.valueOf("+12015555555"))
            .setCustom("Custom text")
            .setIce(
                SVAMLControl.builder()
                    .setAction(
                        ActionConnectPstn.builder()
                            .setNumber(E164PhoneNumber.valueOf("+12017777777"))
                            .setCli("+12015555555")
                            .build())
                    .setInstructions(
                        Arrays.asList(
                            InstructionSay.builder()
                                .setText("Welcome to Sinch.")
                                .setLocale("en-US/male")
                                .build(),
                            InstructionStartRecording.builder()
                                .setOptions(
                                    StartRecordingOptions.builder()
                                        .setDestinationUrl("To specify")
                                        .setCredentials("To specify")
                                        .build())
                                .build()))
                    .build())
            .setAce(
                SVAMLControl.builder()
                    .setAction(
                        ActionRunMenu.builder()
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
                                                    .setDtfm(DualToneMultiFrequency.valueOf("1"))
                                                    .setAction(
                                                        MenuOptionAction.from(
                                                            MenuOptionActionType.MENU, "confirm"))
                                                    .build(),
                                                MenuOption.builder()
                                                    .setDtfm(DualToneMultiFrequency.valueOf("2"))
                                                    .setAction(
                                                        MenuOptionAction.from(
                                                            MenuOptionActionType.RETURN, "cancel"))
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
