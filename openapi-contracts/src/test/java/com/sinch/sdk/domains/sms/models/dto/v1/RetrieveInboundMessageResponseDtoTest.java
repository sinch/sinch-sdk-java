package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class RetrieveInboundMessageResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/MOBinaryDto.json")
  RetrieveInboundMessage200ResponseDto loadedBinaryMessage;

  @GivenJsonResource("/domains/sms/v1/MOTextDto.json")
  RetrieveInboundMessage200ResponseDto loadedTextMessage;

  MOBinaryDto binaryDTO =
      new MOBinaryDto("mo_binary")
          .from("+11203494390")
          .id("01FC66621XXXXX119Z8PMV1QPA")
          .receivedAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .to("11203453453")
          .body("a body")
          .clientReference("a client reference")
          .operatorId("35000")
          .sentAt(OffsetDateTime.parse("2019-08-24T14:15:22Z"))
          .udh("foo udh");

  MOTextDto textDTO =
      new MOTextDto("mo_text")
          .from("+11203494390")
          .id("01FC66621XXXXX119Z8PMV1QPA")
          .receivedAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .to("11203453453")
          .body("a body")
          .clientReference("a client reference")
          .operatorId("35000")
          .sentAt(OffsetDateTime.parse("2019-08-24T14:15:22Z"));

  RetrieveInboundMessage200ResponseDto expectedBinaryMessageDto =
      new RetrieveInboundMessage200ResponseDto(binaryDTO);

  RetrieveInboundMessage200ResponseDto expectedTextMessageDto =
      new RetrieveInboundMessage200ResponseDto(textDTO);

  @Test
  void deserializeBinaryMessage() {

    Assertions.assertThat(loadedBinaryMessage)
        .usingRecursiveComparison()
        .isEqualTo(expectedBinaryMessageDto);
  }

  @Test
  void deserializeTextMessage() {

    Assertions.assertThat(loadedTextMessage)
        .usingRecursiveComparison()
        .isEqualTo(expectedTextMessageDto);
  }
}
