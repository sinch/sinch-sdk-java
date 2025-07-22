package com.sinch.sdk.domains.voice.models.v1.callouts;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.adapters.VoiceBaseTest;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions.ModeEnum;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationMxp;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.ControlUrl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.AnsweringMachineDetectionQuery;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CalloutRequestDtoTest extends VoiceBaseTest {

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestConferenceDto.json")
  String jsonCalloutRequestConference;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestTtsDto.json")
  String jsonCalloutRequestTts;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestCustomDto.json")
  String jsonCalloutRequestCustom;

  public static CalloutRequestConference conferenceRequestCalloutDto =
      CalloutRequestConference.builder()
          .setDestination(DestinationPstn.from("+14045005000"))
          .setCli("+14045001000")
          .setLocale("en-US")
          .setGreeting("Welcome to my conference")
          .setConferenceId("MyConfId")
          .setConferenceDtmfOptions(
              ConferenceDtmfOptions.builder()
                  .setMode(ModeEnum.DETECT)
                  .setMaxDigits(3)
                  .setTimeoutMills(456)
                  .build())
          .setDtmf(DualToneMultiFrequency.valueOf("w123#"))
          .setMaxDuration(32)
          .setEnableAce(true)
          .setEnableDice(true)
          .setEnablePie(true)
          .setMusicOnHold(MusicOnHold.MUSIC2)
          .setCustom("my custom value")
          .setDomain(Domain.PSTN)
          .build();

  public static CalloutRequestTTS ttsRequestDto =
      CalloutRequestTTS.builder()
          .setDestination(DestinationMxp.from("an user name"))
          .setCli("+14045001000")
          .setDtmf(DualToneMultiFrequency.valueOf("w123#"))
          .setCustom("my custom value")
          .setDomain(Domain.PSTN)
          .setLocale("en-US")
          .setText("text value")
          .setPrompts(
              "#ssml[<speak><p>Your PIN code is <say-as"
                  + " interpret-as=\"digits\">1234</say-as></p><p>Please enter it"
                  + " now</p></speak>]")
          .setEnableAce(true)
          .setEnableDice(true)
          .setEnablePie(true)
          .build();

  public static CalloutRequestCustom customRequestDto =
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
                          .setAmd(AnsweringMachineDetectionQuery.builder().setEnabled(true).build())
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

  @Test
  void serializeCalloutConference() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conferenceRequestCalloutDto);

    JSONAssert.assertEquals(jsonCalloutRequestConference, serializedString, true);
  }

  @Test
  void serializeCalloutTts() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(ttsRequestDto);

    JSONAssert.assertEquals(jsonCalloutRequestTts, serializedString, true);
  }

  @Test
  void serializeCalloutCustom() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(customRequestDto);

    JSONAssert.assertEquals(jsonCalloutRequestCustom, serializedString, true);
  }
}
