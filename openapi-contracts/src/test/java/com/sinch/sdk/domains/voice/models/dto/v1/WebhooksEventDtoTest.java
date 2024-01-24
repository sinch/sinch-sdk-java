package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.NotifyRequestDto.EventEnum;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class WebhooksEventDtoTest extends BaseTest {

  @GivenJsonResource("/domains/voice/webhooks/IceRequestDto.json")
  WebhooksEventDto loadedIceRequestDto;

  @GivenJsonResource("/domains/voice/webhooks/DiceRequestDto.json")
  WebhooksEventDto loadedDiceRequestDto;

  @GivenJsonResource("/domains/voice/webhooks/AceRequestDto.json")
  WebhooksEventDto loadedAceRequestDto;

  @GivenJsonResource("/domains/voice/webhooks/PieRequestDto.json")
  WebhooksEventDto loadedPieRequestDto;

  @GivenJsonResource("/domains/voice/webhooks/NotifyRequestDto.json")
  WebhooksEventDto loadedNotifyRequestDto;

  @GivenTextResource("/domains/voice/webhooks/SVAMLResponseDto.json")
  String jsonSVAMLResponseDto;

  public static WebhooksEventDto expectedIceRequestDto =
      new WebhooksEventDto(
          new IceRequestDto()
              .event(IceRequestDto.EventEnum.ICE.getValue())
              .callid("a call id")
              .callResourceUrl("https://calling-euc1.api.sinch.com/calling/v1/calls/id/a call id")
              .timestamp(OffsetDateTime.parse("2024-01-16T16:46:36Z"))
              .version(1)
              .custom("my custom")
              .userRate(new PriceDto().currencyId("USD").amount(0.0F))
              .cli("cli number")
              .to(new DestinationDto().type(DestinationTypeDto.NUMBER).endpoint("+123456879"))
              .domain(DomainDto.MXP)
              .applicationKey("an app key")
              .originationType(DomainDto.MXP2)
              .rdnis("rdnis value")
              .callHeaders(
                  Collections.singletonList(
                      new CallHeaderDto().key("the key").value("the value"))));

  public static WebhooksEventDto expectedDiceRequestDto =
      new WebhooksEventDto(
          new DiceRequestDto()
              .event(DiceRequestDto.EventEnum.DICE.getValue())
              .callid("a call id")
              .timestamp(OffsetDateTime.parse("2024-01-19T12:49:53Z"))
              .version(1)
              .custom("my custom value")
              .userRate(new PriceDto().currencyId("EUR").amount(0.1758F))
              .to(new DestinationDto().type(DestinationTypeDto.NUMBER).endpoint("123456789"))
              .applicationKey("an app key")
              .result(CallResultDto.ANSWERED)
              .reason(DiceRequestDto.ReasonEnum.MANAGERHANGUP.getValue())
              .from("private")
              .duration(1)
              .debit(new PriceDto().currencyId("EUR").amount(0.1758F))
              .userRate(new PriceDto().currencyId("USD").amount(0.345F)));

  public static WebhooksEventDto expectedAceRequestDto =
      new WebhooksEventDto(
          new AceRequestDto()
              .event(AceRequestDto.EventEnum.ACE.getValue())
              .callid("a call id")
              .timestamp(OffsetDateTime.parse("2024-01-19T12:49:53Z"))
              .version(1)
              .custom("my custom value")
              .applicationKey("my application key")
              .amd(
                  new AceRequestAllOfAmdDto().status("human").reason("longgreeting").duration(15)));

  public static WebhooksEventDto expectedPieRequestDto =
      new WebhooksEventDto(
          new PieRequestDto()
              .event(PieRequestDto.EventEnum.PIE.getValue())
              .callid("a call id")
              .timestamp(OffsetDateTime.parse("2024-01-23T15:04:28Z"))
              .version(1)
              .custom("my custom value")
              .applicationKey("my application key")
              .menuResult(
                  new PieRequestAllOfMenuResultDto()
                      .menuId("confirm")
                      .type("sequence")
                      .value("1452")
                      .inputMethod("dtmf")));

  public static WebhooksEventDto expectedNotifyRequestDto =
      new WebhooksEventDto(
          new NotifyRequestDto()
              .event(EventEnum.NOTIFY.getValue())
              .callid("a call id")
              .version(1)
              .custom("my custom value")
              .type("recording_finished"));

  public static SVAMLRequestBodyDto expectedSVAMLResponseDto =
      new SVAMLRequestBodyDto()
          .action(
              new SvamlActionDto(
                  new SvamlActionConnectConfDto()
                      .name(SvamlActionConnectConfDto.NameEnum.CONNECTCONF.getValue())
                      .conferenceId("My Conference Id")))
          .instructions(
              Arrays.asList(
                  new SvamlInstructionDto(
                      new SvamlInstructionSayDto()
                          .name(SvamlInstructionSayDto.NameEnum.SAY.getValue())
                          .text("Hello from instruction")),
                  new SvamlInstructionDto(
                      new SvamlInstructionStartRecordingDto()
                          .name(
                              SvamlInstructionStartRecordingDto.NameEnum.STARTRECORDING.getValue())
                          .options(
                              new SvamlInstructionStartRecordingOptionsDto()
                                  .destinationUrl("s3://my-bucket/")
                                  .credentials(
                                      "AKIAIOSFODNN7EXAMPLE:wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY:eu-central-1")
                                  .notificationEvents(true)
                                  .transcriptionOptions(
                                      new SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto()
                                          .enabled(true))))));

  @Test
  void deserializeIceRequest() {
    Assertions.assertThat(loadedIceRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedIceRequestDto);
  }

  @Test
  void deserializeDiceRequest() {
    Assertions.assertThat(loadedDiceRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedDiceRequestDto);
  }

  @Test
  void deserializeAceRequest() {
    Assertions.assertThat(loadedAceRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedAceRequestDto);
  }

  @Test
  void deserializePieRequest() {
    Assertions.assertThat(loadedPieRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedPieRequestDto);
  }

  @Test
  void deserializeNotifyRequest() {
    Assertions.assertThat(loadedNotifyRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedNotifyRequestDto);
  }

  @Test
  void serializeSVAMLResponse() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedSVAMLResponseDto);

    JSONAssert.assertEquals(jsonSVAMLResponseDto, serializedString, true);
  }
}
