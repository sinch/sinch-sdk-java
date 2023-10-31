package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
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
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class TextResponseDtoTest extends BaseTest {
  @GivenJsonResource("/domains/sms/v1/TextResponseDto.json")
  TextResponseDto loadedDto;

  @GivenTextResource("/domains/sms/v1/TextResponseDto.json")
  String jsonStringDto;

  ParameterObjDto parameterObjDto = new ParameterObjDto();

  TextResponseDto dto =
      new TextResponseDto(
              "01FC66621XXXXX119Z8PMV1QPQ",
              false,
              TextResponseDto.TypeEnum.MT_TEXT.getValue(),
              OffsetDateTime.parse("2019-08-24T14:15:22Z"),
              OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .body("Hi ${name}! How are you?")
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

  @Test
  void deserialize() {

    TextResponseDto expected = dto;

    Assertions.assertThat(loadedDto).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(jsonStringDto, serializedString, true);
  }

  @BeforeEach
  void setUp() {
    Map<String, String> entry1 =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto
                        .JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET,
                    "msisdn value"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "default value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    Map<String, String> entry2 =
        Stream.of(new AbstractMap.SimpleEntry<>("a key", "a value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    parameterObjDto.put(
        ParameterObjDto.JSON_PROPERTY_LEFT_CURLY_BRACKET_PARAMETER_KEY_RIGHT_CURLY_BRACKET, entry1);
    parameterObjDto.put("an identifier", entry2);
  }
}
