package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConferenceTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustomTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTSTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.ConnectPstnAnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CalloutsDtoConverterTest extends BaseTest {

  @Test
  void convertConferenceCallRequest() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(
                CalloutRequestParametersConferenceTest.conferenceRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto);
  }

  @Test
  void convertTTSCallRequest() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(CalloutRequestParametersTTSTest.ttsRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.ttsRequestDto);
  }

  @Test
  void convertCustomCallRequest() {

    CalloutRequestCustom customRequestDtoDeprecated =
        CalloutRequestCustom.builder()
            .setDestination(DestinationPstn.from("+14045005000"))
            .setCli("+14045001000")
            .setDtmf(DualToneMultiFrequency.valueOf("w123#"))
            .setCustom("my custom value")
            .setMaxDuration(32)
            .setIce(
                SvamlControl.builder()
                    .setAction(
                        SvamlActionConnectPstn.builder()
                            .setNumber("+12233445566")
                            .setCli("+12234325234")
                            .setAmd(
                                ConnectPstnAnsweringMachineDetection.builder()
                                    .setEnabled(true)
                                    .build())
                            .build())
                    .build())
            .setAce(
                SvamlControl.builder()
                    .setInstructions(
                        Arrays.asList(
                            SvamlInstructionSay.builder()
                                .setText("Hello, this is a call from Sinch!")
                                .build()))
                    .setAction(SvamlActionHangup.DEFAULT)
                    .build())
            .setPie(ControlUrl.from("https://your-application-server-host/application"))
            .build();

    Assertions.assertThat(
            CalloutsDtoConverter.convert(
                CalloutRequestParametersCustomTest.customRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(customRequestDtoDeprecated);
  }

  @Test
  void convertCallResponse() {

    Assertions.assertThat(
            CalloutsDtoConverter.convert(
                CalloutRequestParametersConferenceTest.conferenceRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto);
  }
}
