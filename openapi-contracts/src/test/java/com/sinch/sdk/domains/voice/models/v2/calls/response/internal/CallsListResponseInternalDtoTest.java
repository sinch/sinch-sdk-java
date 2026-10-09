package com.sinch.sdk.domains.voice.models.v2.calls.response.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.CallDtoTest;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import com.sinch.sdk.domains.voice.models.v2.PaginationMetaDtoTest;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallsListResponseInternalDtoTest extends BaseTest {

  static final String BASE_URL =
      "https://voice.api.sinch.com/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/calls";

  public static final CallsListResponseInternal expectedCallsListResponse =
      CallsListResponseInternal.builder()
          .setCalls(Arrays.asList(CallDtoTest.expectedCall, CallDtoTest.expectedCallMinimal))
          .setLinks(
              PaginationLinks.builder()
                  .setFirst(BASE_URL + "?page=1&pageSize=2")
                  .setLast(BASE_URL + "?page=2&pageSize=2")
                  .setNext(BASE_URL + "?page=2&pageSize=2")
                  .setSelf(BASE_URL + "?page=1&pageSize=2")
                  .build())
          .setMeta(PaginationMetaDtoTest.expectedPaginationMeta)
          .build();

  public static final CallsListResponseInternal expectedCallsListLastPageResponse =
      CallsListResponseInternal.builder()
          .setCalls(Collections.singletonList(CallDtoTest.expectedCallMinimal))
          .setLinks(
              PaginationLinks.builder()
                  .setFirst(BASE_URL + "?page=1&pageSize=2")
                  .setLast(BASE_URL + "?page=2&pageSize=2")
                  .setPrev(BASE_URL + "?page=1&pageSize=2")
                  .setSelf(BASE_URL + "?page=2&pageSize=2")
                  .build())
          .setMeta(PaginationMetaDtoTest.expectedPaginationMeta)
          .build();

  @GivenTextResource("/domains/voice/v2/calls/response/internal/CallsListResponseInternalDto.json")
  String jsonCallsListResponse;

  @GivenTextResource(
      "/domains/voice/v2/calls/response/internal/CallsListResponseInternalLastPageDto.json")
  String jsonCallsListLastPageResponse;

  @Test
  void deserialize() throws JsonProcessingException {
    CallsListResponseInternal deserialized =
        objectMapper.readValue(jsonCallsListResponse, CallsListResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedCallsListResponse);
  }

  @Test
  void deserializeLastPage() throws JsonProcessingException {
    CallsListResponseInternal deserialized =
        objectMapper.readValue(jsonCallsListLastPageResponse, CallsListResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedCallsListLastPageResponse);
  }
}
