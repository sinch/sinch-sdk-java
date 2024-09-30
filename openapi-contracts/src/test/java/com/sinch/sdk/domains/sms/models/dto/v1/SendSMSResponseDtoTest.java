package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
class SendSMSResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/BinaryResponseDto.json")
  SendSMS201ResponseDto loadedBinary;

  @GivenJsonResource("/domains/sms/v1/TextResponseDto.json")
  SendSMS201ResponseDto loadedText;

  @GivenJsonResource("/domains/sms/v1/MediaResponseDto.json")
  SendSMS201ResponseDto loadedMedia;

  ParameterObjDto parameterObjDto = new ParameterObjDto();

  BinaryResponseDto binaryDTO =
      new BinaryResponseDto(
              "01FC66621XXXXX119Z8PMV1QPQ",
              false,
              OffsetDateTime.parse("2019-08-24T14:15:22Z"),
              OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .body("Hi ${name} ({an identifier}) ! How are you?")
          .callbackUrl("callback url")
          .clientReference("myReference")
          .deliveryReport("none")
          .expireAt(OffsetDateTime.parse("2019-08-24T14:21:22Z"))
          .feedbackEnabled(false)
          .flashMessage(true)
          .from("+15551231234")
          .fromTon(6)
          .fromNpi(18)
          .maxNumberOfMessageParts(1)
          .sendAt(OffsetDateTime.parse("2019-08-24T14:19:22Z"))
          .to(Arrays.asList("+15551231234", "+15551256344"))
          .truncateConcat(true)
          .type("mt_binary")
          .udh("foo udh");

  TextResponseDto textDTO =
      new TextResponseDto(
              "01FC66621XXXXX119Z8PMV1QPQ",
              false,
              "mt_text",
              OffsetDateTime.parse("2019-08-24T14:15:22Z"),
              OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .body("Hi ${name} ({an identifier}) ! How are you?")
          .callbackUrl("callback url")
          .clientReference("myReference")
          .deliveryReport("none")
          .expireAt(OffsetDateTime.parse("2019-08-24T14:21:22Z"))
          .feedbackEnabled(false)
          .flashMessage(true)
          .from("+15551231234")
          .fromTon(6)
          .fromNpi(18)
          .maxNumberOfMessageParts(1)
          .parameters(parameterObjDto)
          .sendAt(OffsetDateTime.parse("2019-08-24T14:19:22Z"))
          .to(Arrays.asList("+15551231234", "+15551256344"))
          .truncateConcat(true);
  SendSMS201ResponseDto expectedTextDto = new SendSMS201ResponseDto(textDTO);
  MediaResponseDto mediaDTO =
      new MediaResponseDto(
              "01FC66621XXXXX119Z8PMV1QPQ",
              false,
              "mt_media",
              OffsetDateTime.parse("2019-08-24T14:14:22Z"),
              OffsetDateTime.parse("2019-08-24T14:15:22Z"))
          .body(
              new MediaBodyDto()
                  .url(
                      "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                  .message("Hi ${name} ({an identifier}) ! How are you?"))
          .callbackUrl("callback url")
          .clientReference("client reference")
          .deliveryReport("summary")
          .expireAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .feedbackEnabled(false)
          .from("+15551231234")
          .parameters(parameterObjDto)
          .sendAt(OffsetDateTime.parse("2019-08-24T14:16:22Z"))
          .to(Arrays.asList("+15551231234", "+15551256344"))
          .strictValidation(true);
  SendSMS201ResponseDto expectedMediaDto = new SendSMS201ResponseDto(mediaDTO);
  SendSMS201ResponseDto expectedBinaryDto = new SendSMS201ResponseDto(binaryDTO);

  @Test
  void deserializeBinaryMessage() throws JsonProcessingException {

    Assertions.assertThat(loadedBinary).usingRecursiveComparison().isEqualTo(expectedBinaryDto);
  }

  @Test
  void deserializeTextMessage() throws JsonProcessingException {

    Assertions.assertThat(loadedText).usingRecursiveComparison().isEqualTo(expectedTextDto);
  }

  @Test
  void deserializeMediaMessage() throws JsonProcessingException {

    Assertions.assertThat(loadedMedia).usingRecursiveComparison().isEqualTo(expectedMediaDto);
  }

  @BeforeEach
  void setUp() {
    parameterObjDto.put(
        "an identifier",
        Stream.of(
                new AbstractMap.SimpleEntry<>("15551231234", "an identifier value for 15551231234"),
                new AbstractMap.SimpleEntry<>("15551256344", "an identifier value for 15551256344"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    parameterObjDto.put(
        "name",
        Stream.of(
                new AbstractMap.SimpleEntry<>("15551231234", "name value for 15551231234"),
                new AbstractMap.SimpleEntry<>("15551256344", "name value for 15551256344"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "default value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
  }
}
