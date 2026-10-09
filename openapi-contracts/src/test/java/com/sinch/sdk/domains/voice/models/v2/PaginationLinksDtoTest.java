package com.sinch.sdk.domains.voice.models.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class PaginationLinksDtoTest extends BaseTest {

  static final String BASE_URL =
      "https://voice.api.sinch.com/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/calls";

  public static final PaginationLinks expectedPaginationLinks =
      PaginationLinks.builder()
          .setFirst(BASE_URL + "?page=1&pageSize=2")
          .setLast(BASE_URL + "?page=2&pageSize=2")
          .setNext(BASE_URL + "?page=3&pageSize=2")
          .setPrev(BASE_URL + "?page=1&pageSize=2")
          .setSelf(BASE_URL + "?page=2&pageSize=2")
          .build();

  @GivenTextResource("/domains/voice/v2/PaginationLinksDto.json")
  String jsonPaginationLinks;

  @Test
  void deserialize() throws JsonProcessingException {
    PaginationLinks deserialized =
        objectMapper.readValue(jsonPaginationLinks, PaginationLinks.class);

    TestHelpers.recursiveEquals(deserialized, expectedPaginationLinks);
  }
}
