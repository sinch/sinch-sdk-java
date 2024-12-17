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
  @GivenTextResource("/domains/sms/v1/BinaryRequestDto.json")
  String jsonRequestBinaryDto;

  @GivenTextResource("/domains/sms/v1/batches/request/TextRequestDto.json")
  String jsonRequestTextDto;

  @GivenTextResource("/domains/sms/v1/MediaRequestDto.json")
  String jsonRequestMediaDto;

  @Test
  void serializeBinaryRequestDto() throws JsonProcessingException, JSONException {

    BinaryRequestDto binaryRequestDTO =
        new BinaryRequestDto()
            .to(Arrays.asList("+15551231234", "+15551256344"))
            .body("Hi ${name} ({an identifier}) ! How are you?")
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

    ParameterObjDto parameterObjDto = new ParameterObjDto();
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

    TextRequestDto textRequestDTO =
        new TextRequestDto()
            .to(Arrays.asList("+15551231234", "+15551256344"))
            .body("Hi ${name} ({an identifier}) ! How are you?")
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

    ParameterObjDto parameterObjDto = new ParameterObjDto();
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

    MediaRequestDto mediaRequestDTO =
        new MediaRequestDto("mt_media")
            .to(Arrays.asList("+15551231234", "+15551256344"))
            .body(
                new MediaBodyDto()
                    .url(
                        "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                    .message("Hi ${name} ({an identifier}) ! How are you?"))
            .from("+15551231234")
            .deliveryReport("summary")
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
