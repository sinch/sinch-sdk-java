package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.DestinationSip;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.DtfmModeType;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;
import com.sinch.sdk.domains.voice.models.TransportType;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionConnectConfDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionConnectMxpDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionConnectPstnDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionConnectSipDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionContinueDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionHangUpDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionParkDtoTest;
import com.sinch.sdk.domains.voice.models.dto.svaml.ActionRunMenuDtoTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionDto;
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
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Collections;
import org.assertj.core.api.Assertions;
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
          .setDtmf(DualToneMultiFrequency.valueOf("#w123"))
          .setIndications(IndicationType.from("unknown value"))
          .setAnsweringMachineDetectionEnabled(
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
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionConnectConference))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionConnectConfDtoTest.dto));
  }

  @Test
  void convertActionConnectMxp() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionConnectMxp))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionConnectMxpDtoTest.dto));
  }

  @Test
  void convertActionConnectPstn() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionConnectPstn))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionConnectPstnDtoTest.dto));
  }

  @Test
  void convertActionConnectSip() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionConnectSip))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionConnectSipDtoTest.dto));
  }

  @Test
  void convertActionContinue() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionContinue))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionContinueDtoTest.dto));
  }

  @Test
  void convertActionHangup() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionHanghup))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionHangUpDtoTest.dto));
  }

  @Test
  void convertActionPark() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionPark))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionParkDtoTest.dto));
  }

  @Test
  void convertActionRunMenu() {
    Assertions.assertThat(SVAMLActionDtoConverter.convert(actionRunMenu))
        .usingRecursiveComparison()
        .isEqualTo(new SvamlActionDto(ActionRunMenuDtoTest.dto));
  }
}
