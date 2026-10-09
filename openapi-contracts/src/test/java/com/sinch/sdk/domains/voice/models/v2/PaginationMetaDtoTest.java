package com.sinch.sdk.domains.voice.models.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class PaginationMetaDtoTest extends BaseTest {

  public static final PaginationMeta expectedPaginationMeta =
      PaginationMeta.builder().setTotalCount(3).setPageCount(2).build();

  @GivenTextResource("/domains/voice/v2/PaginationMetaDto.json")
  String jsonPaginationMeta;

  @Test
  void deserialize() throws JsonProcessingException {
    PaginationMeta deserialized = objectMapper.readValue(jsonPaginationMeta, PaginationMeta.class);

    TestHelpers.recursiveEquals(deserialized, expectedPaginationMeta);
  }
}
