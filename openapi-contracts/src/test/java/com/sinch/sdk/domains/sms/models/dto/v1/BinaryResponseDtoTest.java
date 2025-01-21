package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class BinaryResponseDtoTest extends BaseTest {
  @GivenJsonResource("/domains/sms/v1/batches/response/BinaryResponseDto.json")
  BinaryResponseDto loadedDto;

  @GivenTextResource("/domains/sms/v1/batches/response/BinaryResponseDto.json")
  String jsonStringDto;

  BinaryResponseDto dto =
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

  @Test
  void deserialize() {

    BinaryResponseDto expected = dto;

    Assertions.assertThat(loadedDto).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(jsonStringDto, serializedString, true);
  }
}
