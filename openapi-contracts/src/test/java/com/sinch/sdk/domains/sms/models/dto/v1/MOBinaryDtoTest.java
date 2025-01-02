package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MOBinaryDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundBinaryDto.json")
  MOBinaryDto loadedDto;

  @GivenTextResource("/domains/sms/v1/inbounds/InboundBinaryDto.json")
  String jsonStringDto;

  public static MOBinaryDto dto =
      new MOBinaryDto(MOBinaryDto.TypeEnum.MO_BINARY.getValue())
          .from("+11203494390")
          .id("01FC66621XXXXX119Z8PMV1QPA")
          .receivedAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .to("11203453453")
          .body("a body")
          .clientReference("a client reference")
          .operatorId("35000")
          .sentAt(OffsetDateTime.parse("2019-08-24T14:15:22Z"))
          .udh("foo udh");

  @Test
  void deserialize() {

    MOBinaryDto expected = dto;

    Assertions.assertThat(loadedDto).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(jsonStringDto, serializedString, true);
  }
}
