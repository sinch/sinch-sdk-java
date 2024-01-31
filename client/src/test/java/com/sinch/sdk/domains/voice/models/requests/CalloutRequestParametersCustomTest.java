package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.ActionHangUp;
import com.sinch.sdk.domains.voice.models.svaml.AnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.models.DualToneMultiFrequency;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalloutRequestParametersCustomTest {

  public static final CalloutRequestParametersCustom customRequestParameters =
      CalloutRequestParametersCustom.builder()
          .setDestination(DestinationNumber.valueOf("+14045005000"))
          .setCli(E164PhoneNumber.valueOf("+14045001000"))
          .setCustom("my custom value")
          .setDtfm(DualToneMultiFrequency.valueOf("w123#"))
          .setMaxDuration(32)
          .setIce(
              SVAMLControl.builder()
                  .setAction(
                      ActionConnectPstn.builder()
                          .setCli("+12234325234")
                          .setNumber(E164PhoneNumber.valueOf("+12233445566"))
                          .setAnsweringMachineDetectionEnabled(
                              AnsweringMachineDetection.builder().setEnabled(true).build())
                          .build())
                  .build())
          .setAce(
              SVAMLControl.builder()
                  .setAction(ActionHangUp.builder().build())
                  .setInstructions(
                      Arrays.asList(
                          InstructionSay.builder()
                              .setText("Hello, this is a call from Sinch!")
                              .build()))
                  .build())
          .setPie(ControlUrl.from("https://your-application-server-host/application"))
          .build();

  @Test
  void getDestination() {
    assertEquals(
        DestinationNumber.valueOf("+14045005000"), customRequestParameters.getDestination().get());
  }

  @Test
  void getCli() {
    assertEquals(E164PhoneNumber.valueOf("+14045001000"), customRequestParameters.getCli().get());
  }

  @Test
  void getDtfm() {
    assertEquals("w123#", customRequestParameters.getDtfm().get().stringValue());
  }

  @Test
  void getCustom() {
    assertEquals("my custom value", customRequestParameters.getCustom().get());
  }

  @Test
  void getIce() {
    Assertions.assertThat(
            SVAMLControl.builder()
                .setAction(
                    ActionConnectPstn.builder()
                        .setCli("+12234325234")
                        .setNumber(E164PhoneNumber.valueOf("+12233445566"))
                        .setAnsweringMachineDetectionEnabled(
                            AnsweringMachineDetection.builder().setEnabled(true).build())
                        .build())
                .build())
        .usingRecursiveComparison()
        .isEqualTo(customRequestParameters.getIce().get());
  }

  @Test
  void getAce() {

    Assertions.assertThat(
            SVAMLControl.builder()
                .setAction(ActionHangUp.builder().build())
                .setInstructions(
                    Arrays.asList(
                        InstructionSay.builder()
                            .setText("Hello, this is a call from Sinch!")
                            .build()))
                .build())
        .usingRecursiveComparison()
        .isEqualTo(customRequestParameters.getAce().get());
  }

  @Test
  void getPie() {

    Assertions.assertThat(ControlUrl.from("https://your-application-server-host/application"))
        .usingRecursiveComparison()
        .isEqualTo(customRequestParameters.getPie().get());
  }
}
