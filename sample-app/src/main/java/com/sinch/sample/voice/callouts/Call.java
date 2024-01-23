package com.sinch.sample.voice.callouts;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionAction;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
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

    LOGGER.info("Start call for: " + phoneNumber);

    CalloutRequestParameters parameters = null;

    CalloutMethodType type = CalloutMethodType.CUSTOM_CALLOUT;

    // custom
    if (type == CalloutMethodType.CUSTOM_CALLOUT) {
      parameters =
          CalloutRequestParametersCustom.builder()
              .setIce(
                  SVAMLControl.builder()
                      .setAction(
                          ActionConnectPstn.builder()
                              .setNumber(E164PhoneNumber.valueOf(phoneNumber))
                              .setCli("+123456789")
                              .build())
                      .setInstructions(
                          Arrays.asList(
                              InstructionSay.builder().setText("Hello from Sinch").build()))
                      .build())
              .setAce(
                  SVAMLControl.builder()
                      .setAction(
                          ActionRunMenu.builder()
                              .setLocale("Kimberly")
                              .setEnableVoice(true)
                              .setMenus(
                                  Arrays.asList(
                                      Menu.builder()
                                          .setId("main")
                                          .setMainPrompt(
                                              "#tts[Welcome to the main menu. Press 1 to confirm"
                                                  + " order or 4 to cancel]")
                                          .setRepeatPrompt(
                                              "#tts[Incorrect value, please try again]")
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
                                                      .setDtfm(DualToneMultiFrequency.valueOf("4"))
                                                      .setAction(
                                                          MenuOptionAction.from(
                                                              MenuOptionActionType.RETURN,
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
              .build();
      ;
    }

    if (type == CalloutMethodType.CONFERENCE_CALLOUT) {
      parameters =
          CalloutRequestParametersConference.builder()
              .setDestination(DestinationNumber.valueOf(phoneNumber))
              .setConferenceId(conferenceId)
              .setCustom("my custom value")
              .setEnableAce(true)
              .setEnableDice(true)
              .setEnablePie(true)
              .build();
    }
    var response = client.voice().callouts().call(parameters);

    LOGGER.info("Response: " + response);
  }
}
