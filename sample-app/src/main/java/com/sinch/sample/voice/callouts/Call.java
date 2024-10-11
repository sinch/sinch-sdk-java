package com.sinch.sample.voice.callouts;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequest;
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
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Call extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Call.class.getName());

  public Call() throws IOException {}

  public static void main(String[] args) {
    try {
      new Call().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    CalloutsService service = client.voice().v1().callouts();

    LOGGER.info("Start call for: " + phoneNumber);

    CalloutRequest parameters = getTextToSpeechRequest();
    // getCalloutRequest();
    // getConferenceRequest();

    var response = service.call(parameters);

    LOGGER.info("Response: " + response);
  }

  private CalloutRequestTTS getTextToSpeechRequest() {
    return CalloutRequestTTS.builder()
        .setDestination(
            Destination.builder().setType(DestinationType.NUMBER).setEndpoint(phoneNumber).build())
        .setEnableAce(true)
        .setEnableDice(true)
        .setEnablePie(true)
        .setText("Hello")
        .setDtmf(DualToneMultiFrequency.valueOf("w#1"))
        .build();
  }

  private CalloutRequestCustom getCalloutRequest() {

    CalloutRequestCustom.Builder builder =
        CalloutRequestCustom.builder()
            .setCustom("my custom value")
            .setIce(
                SvamlControl.builder()
                    .setAction(
                        SvamlActionConnectPstn.builder()
                            .setNumber(phoneNumber)
                            .setCli("+123456789")
                            .build())
                    .setInstructions(
                        Arrays.asList(
                            SvamlInstructionSay.builder().setText("Hello from Sinch").build()))
                    .build())
            .setAce(
                SvamlControl.builder()
                    .setAction(
                        SvamlActionRunMenu.builder()
                            .setLocale("Kimberly")
                            .setEnableVoice(true)
                            .setMenus(
                                Arrays.asList(
                                    Menu.builder()
                                        .setId("main")
                                        .setMainPrompt(
                                            "#tts[Welcome to the main menu. Press 1 to confirm"
                                                + " order or 4 to cancel]")
                                        .setRepeatPrompt("#tts[Incorrect value, please try again]")
                                        .setTimeoutMills(5000)
                                        .setOptions(
                                            Arrays.asList(
                                                MenuOption.builder()
                                                    .setDtmf(DualToneMultiFrequency.valueOf("1"))
                                                    .setAction(
                                                        MenuOptionActionFactory.menuAction(
                                                            "confirm"))
                                                    .build(),
                                                MenuOption.builder()
                                                    .setDtmf(DualToneMultiFrequency.valueOf("4"))
                                                    .setAction(
                                                        MenuOptionActionFactory.returnAction(
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
                    .build());

    webhooksVoicePath.ifPresent(c -> builder.setPie(ControlUrl.from(c)));

    return builder.build();
  }

  private CalloutRequestConference getConferenceRequest() {
    return CalloutRequestConference.builder()
        .setDestination(
            Destination.builder().setType(DestinationType.NUMBER).setEndpoint(phoneNumber).build())
        .setConferenceId(conferenceId)
        .setDomain(Domain.PSTN)
        .setCustom("my custom value")
        .setEnableAce(true)
        .setEnableDice(true)
        .setEnablePie(true)
        .build();
  }
}
