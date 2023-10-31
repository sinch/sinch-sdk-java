package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class SendSMSRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/SendSMSBinaryRequestDto.json")
  String jsonRequestBinaryDto;

  @GivenTextResource("/domains/sms/v1/SendSMSTextRequestDto.json")
  String jsonRequestTextDto;

  @GivenTextResource("/domains/sms/v1/SendSMSMediaRequestDto.json")
  String jsonRequestMediaDto;

  @Test
  void serializeBinaryRequestDto() throws JsonProcessingException, JSONException {

    BinaryRequestDto binaryRequestDTO =
        new BinaryRequestDto()
            .to(Arrays.asList("+15551231234", "+15551256344"))
            .body("Hi ${name}! How are you?")
            .udh("foo udh")
            .from("+15551231234")
            .type("mt_binary")
            .deliveryReport("none")
            .sendAt(OffsetDateTime.parse("2019-08-24T14:19:22Z"))
            .expireAt(OffsetDateTime.parse("2019-08-24T14:21:22Z"))
            .callbackUrl("callback url")
            .clientReference("myReference")
            .feedbackEnabled(false)
            .flashMessage(true)
            .truncateConcat(true)
            .maxNumberOfMessageParts(1)
            .fromTon(6)
            .fromNpi(18);
    SendSMSRequestDto sendSMSRequestDto = new SendSMSRequestDto(binaryRequestDTO);

    String serializedString = objectMapper.writeValueAsString(sendSMSRequestDto);

    JSONAssert.assertEquals(jsonRequestBinaryDto, serializedString, true);
  }

  @Test
  void serializeTextRequestDto() throws JsonProcessingException, JSONException {

    Map<String, String> map =
        Stream.of(
                new AbstractMap.SimpleEntry<>("12345678910", "Joe"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "there"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    ParameterObjDto parameterObjDto = new ParameterObjDto();

    parameterObjDto.put("name", map);
    TextRequestDto textRequestDTO =
        new TextRequestDto()
            .to(Arrays.asList("+15551231234", "+15551256344"))
            .body("Hi ${name}! How are you?")
            .from("+15551231234")
            .type("mt_text")
            .deliveryReport("none")
            .sendAt(OffsetDateTime.parse("2019-08-24T14:19:22Z"))
            .expireAt(OffsetDateTime.parse("2019-08-24T14:21:22Z"))
            .callbackUrl("callback url")
            .clientReference("myReference")
            .feedbackEnabled(false)
            .flashMessage(true)
            .truncateConcat(true)
            .maxNumberOfMessageParts(1)
            .fromTon(6)
            .fromNpi(18)
            .parameters(parameterObjDto);

    SendSMSRequestDto sendSMSRequestDto = new SendSMSRequestDto(textRequestDTO);

    String serializedString = objectMapper.writeValueAsString(sendSMSRequestDto);

    JSONAssert.assertEquals(jsonRequestTextDto, serializedString, true);
  }

  @Test
  void serializeMediaRequestDto() throws JsonProcessingException, JSONException {

    Map<String, String> map =
        Stream.of(
                new AbstractMap.SimpleEntry<>("12345678910", "Joe"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "there"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    ParameterObjDto parameterObjDto = new ParameterObjDto();

    parameterObjDto.put("name", map);
    MediaRequestDto mediaRequestDTO =
        new MediaRequestDto("mt_media")
            .to(Arrays.asList("+15551231234", "+15551256344"))
            .body(
                new MediaBodyDto()
                    .url(
                        "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                    .message("Media message from Sinch!"))
            .from("+15551231234")
            .deliveryReport("none")
            .sendAt(OffsetDateTime.parse("2019-08-24T14:16:22Z"))
            .expireAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
            .callbackUrl("callback url")
            .clientReference("client reference")
            .feedbackEnabled(false)
            .strictValidation(true)
            .parameters(parameterObjDto);

    SendSMSRequestDto sendSMSRequestDto = new SendSMSRequestDto(mediaRequestDTO);

    String serializedString = objectMapper.writeValueAsString(sendSMSRequestDto);

    JSONAssert.assertEquals(jsonRequestMediaDto, serializedString, true);
  }
}
