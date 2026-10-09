package com.sinch.sdk.domains.voice.models.v2.services.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ServiceShortResponseDtoTest extends BaseTest {

  public static final ServiceShortResponse expectedServiceShortResponse =
      ServiceShortResponse.builder()
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setCreateTime(Instant.parse("2025-01-01T00:00:00Z"))
          .setUpdateTime(Instant.parse("2025-02-15T10:30:00Z"))
          .setName("Primary Service")
          .setDescription("Main service with webhook call behavior")
          .setIsDefault(true)
          .build();

  public static final ServiceShortResponse expectedServiceShortResponseMinimal =
      ServiceShortResponse.builder()
          .setServiceId("7f235289-d3ae-57b6-a54d-6d3bf655bbdf")
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setCreateTime(Instant.parse("2025-02-15T10:30:00Z"))
          .setName("Secondary Service")
          .setIsDefault(false)
          .build();

  @GivenTextResource("/domains/voice/v2/services/response/ServiceShortResponseDto.json")
  String jsonServiceShortResponse;

  @GivenTextResource("/domains/voice/v2/services/response/ServiceShortResponseMinimalDto.json")
  String jsonServiceShortResponseMinimal;

  @Test
  void deserialize() throws JsonProcessingException {
    ServiceShortResponse deserialized =
        objectMapper.readValue(jsonServiceShortResponse, ServiceShortResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedServiceShortResponse);
  }

  @Test
  void deserializeMinimalDto() throws JsonProcessingException {
    ServiceShortResponse deserialized =
        objectMapper.readValue(jsonServiceShortResponseMinimal, ServiceShortResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedServiceShortResponseMinimal);
  }
}
