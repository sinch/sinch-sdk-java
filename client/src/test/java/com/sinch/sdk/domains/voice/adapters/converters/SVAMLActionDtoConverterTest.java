package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.DtfmModeType;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;
import com.sinch.sdk.domains.voice.models.TransportType;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectConference;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectMxp;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectSip;
import com.sinch.sdk.domains.voice.models.svaml.ActionContinue;
import com.sinch.sdk.domains.voice.models.svaml.ActionHangUp;
import com.sinch.sdk.domains.voice.models.svaml.ActionPark;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.AnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.svaml.IndicationType;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionAction;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectConferenceTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectMxpTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstnTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSipTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionContinueTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangupTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionParkTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionRunMenuTest;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class SVAMLActionDtoConverterTest {

  public static final ActionConnectConference actionConnectConference =
      ActionConnectConference.builder()
          .setConferenceId("My Conference Id")
          .setDtfmOptions(
              ConferenceDtfmOptions.builder()
                  .setMode(DtfmModeType.FORWARD)
                  .setMaxDigits(45)
                  .setTimeoutMills(456)
                  .build())
          .setMusicOnHold(MusicOnHoldType.MUSIC3)
          .build();

  ActionConnectMxp actionConnectMxp =
      ActionConnectMxp.builder()
          .setDestination(DestinationUser.valueOf("a user string"))
          .setCallheaders(Collections.singletonList(new Pair<>("left string", "right string")))
          .build();

  ActionConnectPstn actionConnectPstn =
      ActionConnectPstn.builder()
          .setNumber(E164PhoneNumber.valueOf("+123456789"))
          .setLocale("fr")
          .setMaxDuration(123)
          .setDialTimeout(456)
          .setCli("cli value")
          .setSuppressCallbacks(true)
          .setDualToneMultiFrequency(DualToneMultiFrequency.valueOf("#w123"))
          .setIndications(IndicationType.from("unknown value"))
          .setAnsweringMachineDetection(
              AnsweringMachineDetection.builder().setEnabled(true).build())
          .build();

  ActionConnectSip actionConnectSip =
      ActionConnectSip.builder()
          .setDestination(DestinationSip.valueOf("a sip string"))
          .setMaxDuration(456)
          .setCli("a cli value")
          .setTransport(TransportType.TLS)
          .setSuppressCallbacks(true)
          .setCallHeaders(Collections.singletonList(new Pair<>("left string", "right string")))
          .setMusicOnHold(MusicOnHoldType.MUSIC2)
          .build();

  ActionContinue actionContinue = ActionContinue.builder().build();

  ActionHangUp actionHanghup = ActionHangUp.builder().build();

  ActionPark actionPark =
      ActionPark.builder()
          .setLocale("en")
          .setIntroPrompt("intro prompt")
          .setHoldPrompt("hold prompt")
          .setMaxDuration(456)
          .build();

  ActionRunMenu actionRunMenu =
      ActionRunMenu.builder()
          .setBarge(true)
          .setEnableVoice(false)
          .setLocale("fr")
          .setMainMenu(" the main menu")
          .setMenus(
              Collections.singletonList(
                  Menu.builder()
                      .setId("the id")
                      .setMainPrompt("main prompt")
                      .setRepeatPrompt("repeat prompt")
                      .setRepeats(5)
                      .setMaxDigits(18)
                      .setTimeoutMills(500)
                      .setMaxTimeoutMills(123456)
                      .setOptions(
                          Collections.singletonList(
                              MenuOption.builder()
                                  .setAction(
                                      MenuOptionAction.from(MenuOptionActionType.MENU, "foo"))
                                  .setDtfm(DualToneMultiFrequency.valueOf("#w"))
                                  .build()))
                      .build()))
          .build();

  @Test
  void convertActionConnectConf() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionConnectConference),
        SvamlActionConnectConferenceTest.dto);
  }

  @Test
  void convertActionConnectMxp() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionConnectMxp), SvamlActionConnectMxpTest.dto);
  }

  @Test
  void convertActionConnectPstn() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionConnectPstn), SvamlActionConnectPstnTest.dto);
  }

  @Test
  void convertActionConnectSip() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionConnectSip), SvamlActionConnectSipTest.dto);
  }

  @Test
  void convertActionContinue() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionContinue), SvamlActionContinueTest.dto);
  }

  @Test
  void convertActionHangup() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionHanghup), SvamlActionHangupTest.dto);
  }

  @Test
  void convertActionPark() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionPark), SvamlActionParkTest.dto);
  }

  @Test
  void convertActionRunMenu() {
    TestHelpers.recursiveEquals(
        SVAMLActionDtoConverter.convert(actionRunMenu), SvamlActionRunMenuTest.dto);
  }
}
