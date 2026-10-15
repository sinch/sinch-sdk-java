package com.sinch.sdk.domains.voice.models.v2.services.response.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import com.sinch.sdk.domains.voice.models.v2.PaginationMetaDtoTest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceShortResponseDtoTest;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ServicesListResponseInternalDtoTest extends BaseTest {

  static final String BASE_URL =
      "https://voice.api.sinch.com/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/services";

  public static final ServicesListResponseInternal expectedServicesListResponse =
      ServicesListResponseInternal.builder()
          .setServices(
              Arrays.asList(
                  ServiceShortResponseDtoTest.expectedServiceShortResponse,
                  ServiceShortResponseDtoTest.expectedServiceShortResponseMinimal))
          .setLinks(
              PaginationLinks.builder()
                  .setFirst(BASE_URL + "?page=1&pageSize=2")
                  .setLast(BASE_URL + "?page=2&pageSize=2")
                  .setNext(BASE_URL + "?page=2&pageSize=2")
                  .setSelf(BASE_URL + "?page=1&pageSize=2")
                  .build())
          .setMeta(PaginationMetaDtoTest.expectedPaginationMeta)
          .build();

  public static final ServicesListResponseInternal expectedServicesListLastPageResponse =
      ServicesListResponseInternal.builder()
          .setServices(
              Collections.singletonList(
                  ServiceShortResponseDtoTest.expectedServiceShortResponseMinimal))
          .setLinks(
              PaginationLinks.builder()
                  .setFirst(BASE_URL + "?page=1&pageSize=2")
                  .setLast(BASE_URL + "?page=2&pageSize=2")
                  .setPrev(BASE_URL + "?page=1&pageSize=2")
                  .setSelf(BASE_URL + "?page=2&pageSize=2")
                  .build())
          .setMeta(PaginationMetaDtoTest.expectedPaginationMeta)
          .build();

  @GivenTextResource(
      "/domains/voice/v2/services/response/internal/ServicesListResponseInternalDto.json")
  String jsonServicesListResponse;

  @GivenTextResource(
      "/domains/voice/v2/services/response/internal/ServicesListResponseInternalLastPageDto.json")
  String jsonServicesListLastPageResponse;

  @Test
  void deserialize() throws JsonProcessingException {
    ServicesListResponseInternal deserialized =
        objectMapper.readValue(jsonServicesListResponse, ServicesListResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedServicesListResponse);
  }

  @Test
  void deserializeLastPage() throws JsonProcessingException {
    ServicesListResponseInternal deserialized =
        objectMapper.readValue(
            jsonServicesListLastPageResponse, ServicesListResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedServicesListLastPageResponse);
  }
}
