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
class UpdateSMSRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/UpdateSMSBinaryRequestDto.json")
  String jsonRequestBinaryDto;

  @GivenTextResource("/domains/sms/v1/UpdateSMSTextRequestDto.json")
  String jsonRequestTextDto;

  @GivenTextResource("/domains/sms/v1/UpdateSMSMediaRequestDto.json")
  String jsonRequestMediaDto;

  @Test
  void serializeBinaryRequestDto() throws JsonProcessingException, JSONException {

    ApiUpdateBinaryMtMessageDto binaryRequestDTO =
        new ApiUpdateBinaryMtMessageDto()
            .toAdd(Arrays.asList("+15551231234", "+15987365412"))
            .toRemove(Arrays.asList("+0123456789", "+9876543210"))
            .body("Hi ${name}! How are you?")
            .udh("foo udh")
            .from("+15551231234")
            .type("mt_binary")
            .deliveryReport("full")
            .sendAt(OffsetDateTime.parse("2019-08-24T14:19:22Z"))
            .expireAt(OffsetDateTime.parse("2019-08-24T14:21:22Z"))
            .callbackUrl("callback url");
    UpdateBatchMessageRequestDto sendSMSRequestDto =
        new UpdateBatchMessageRequestDto(binaryRequestDTO);

    String serializedString = objectMapper.writeValueAsString(sendSMSRequestDto);

    JSONAssert.assertEquals(jsonRequestBinaryDto, serializedString, true);
  }

  @Test
  void serializeTextRequestDto() throws JsonProcessingException, JSONException {

    ParameterObjDto parameterObjDto = new ParameterObjDto();
    parameterObjDto.put(
        "an identifier",
        Stream.of(new AbstractMap.SimpleEntry<>("a key", "a value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    parameterObjDto.put(
        ParameterObjDto.JSON_PROPERTY_LEFT_CURLY_BRACKET_PARAMETER_KEY_RIGHT_CURLY_BRACKET,
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto
                        .JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET,
                    "msisdn value"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "default value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    ApiUpdateTextMtMessageDto textRequestDTO =
        new ApiUpdateTextMtMessageDto()
            .toAdd(Arrays.asList("+15551231234", "+15551256344"))
            .body("Hi ${name}! How are you?")
            .from("+15551231234")
            .type("mt_text")
            .deliveryReport("none")
            .sendAt(OffsetDateTime.parse("2019-08-24T14:19:22Z"))
            .expireAt(OffsetDateTime.parse("2019-08-24T14:21:22Z"))
            .callbackUrl("callback url")
            .parameters(parameterObjDto);

    UpdateBatchMessageRequestDto sendSMSRequestDto =
        new UpdateBatchMessageRequestDto(textRequestDTO);

    String serializedString = objectMapper.writeValueAsString(sendSMSRequestDto);

    JSONAssert.assertEquals(jsonRequestTextDto, serializedString, true);
  }

  @Test
  void serializeMediaRequestDto() throws JsonProcessingException, JSONException {

    ParameterObjDto parameterObjDto = new ParameterObjDto();
    parameterObjDto.put(
        "an identifier",
        Stream.of(new AbstractMap.SimpleEntry<>("a key", "a value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    parameterObjDto.put(
        ParameterObjDto.JSON_PROPERTY_LEFT_CURLY_BRACKET_PARAMETER_KEY_RIGHT_CURLY_BRACKET,
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto
                        .JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET,
                    "msisdn value"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "default value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    ApiUpdateMmsMtMessageDto mediaRequestDTO =
        new ApiUpdateMmsMtMessageDto()
            .type("mt_media")
            .toRemove(Arrays.asList("+15551231234", "+15551256344"))
            .body(
                new MediaBodyDto()
                    .url(
                        "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                    .message("Media message from Sinch!"))
            .from("+15551231234")
            .deliveryReport("summary")
            .sendAt(OffsetDateTime.parse("2019-08-24T14:16:22Z"))
            .expireAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
            .callbackUrl("callback url")
            .strictValidation(true)
            .parameters(parameterObjDto);

    UpdateBatchMessageRequestDto sendSMSRequestDto =
        new UpdateBatchMessageRequestDto(mediaRequestDTO);

    String serializedString = objectMapper.writeValueAsString(sendSMSRequestDto);

    JSONAssert.assertEquals(jsonRequestMediaDto, serializedString, true);
  }
}
