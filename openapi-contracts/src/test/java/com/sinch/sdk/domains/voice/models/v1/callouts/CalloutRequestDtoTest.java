package com.sinch.sdk.domains.voice.models.v1.callouts;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDto.MethodEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.ConferenceCalloutRequestConferenceDtmfOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.ConferenceCalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CustomCalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationTypeDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DomainDto;
import com.sinch.sdk.domains.voice.models.dto.v1.TtsCalloutRequestDto;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CalloutRequestDtoTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestConferenceDto.json")
  String jsonCalloutRequestConference;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestTtsDto.json")
  String jsonCalloutRequestTts;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestCustomDto.json")
  String jsonCalloutRequestCustom;

  public static CalloutRequestDto conferenceRequestCalloutDto =
      new CalloutRequestDto()
          .method(MethodEnum.CONFERENCECALLOUT.getValue())
          .conferenceCallout(
              new ConferenceCalloutRequestDto()
                  .destination(
                      new DestinationDto().type(DestinationTypeDto.NUMBER).endpoint("+14045005000"))
                  .cli("+14045001000")
                  .locale("en-US")
                  .greeting("Welcome to my conference")
                  .conferenceId("MyConfId")
                  .conferenceDtmfOptions(
                      new ConferenceCalloutRequestConferenceDtmfOptionsDto()
                          .mode("detect")
                          .maxDigits(3)
                          .timeoutMills(456))
                  .dtmf("w123#")
                  .maxDuration(32)
                  .enableAce(true)
                  .enableDice(true)
                  .enablePie(true)
                  .mohClass("music2")
                  .custom("my custom value")
                  .domain("pstn"));

  public static CalloutRequestDto ttsRequestDto =
      new CalloutRequestDto()
          .method(MethodEnum.TTSCALLOUT.getValue())
          .ttsCallout(
              new TtsCalloutRequestDto()
                  .destination(
                      new DestinationDto()
                          .type(DestinationTypeDto.USERNAME)
                          .endpoint("an user name"))
                  .cli("+14045001000")
                  .dtmf("w123#")
                  .custom("my custom value")
                  .domain(DomainDto.PSTN)
                  .locale("en-US")
                  .text("text value")
                  .prompts(
                      "#ssml[<speak><p>Your PIN code is <say-as"
                          + " interpret-as=\"digits\">1234</say-as></p><p>Please enter it"
                          + " now</p></speak>]")
                  .enableAce(true)
                  .enableDice(true)
                  .enablePie(true));

  public static CalloutRequestDto customRequestDto =
      new CalloutRequestDto()
          .method(MethodEnum.CUSTOMCALLOUT.getValue())
          .customCallout(
              new CustomCalloutRequestDto()
                  .destination(
                      new DestinationDto().type(DestinationTypeDto.NUMBER).endpoint("+14045005000"))
                  .cli("+14045001000")
                  .dtmf("w123#")
                  .custom("my custom value")
                  .maxDuration(32)
                  .ice(
                      "{\"action\":{\"name\":\"connectPstn\",\"number\":"
                          + "\"+12233445566\",\"cli\":\"+12234325234\",\"amd\":"
                          + "{\"enabled\":true}}}")
                  .ace(
                      "{\"instructions\":[{\"name\":\"say\",\"text\":\"Hello,"
                          + " this is a call from Sinch!\"}],\"action\":{\"name\":"
                          + "\"hangup\"}}")
                  .pie("https://your-application-server-host/application"));

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
