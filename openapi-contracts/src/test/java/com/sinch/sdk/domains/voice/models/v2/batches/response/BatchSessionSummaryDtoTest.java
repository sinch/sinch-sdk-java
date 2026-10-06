package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BatchSessionSummaryDtoTest extends BaseTest {

  public static final BatchSessionSummary expectedBatchSessionSummary =
      BatchSessionSummary.builder()
          .setId("01F8Z5J4X2G9Y3J4X2G9Y3J4X2G9")
          .setState(SessionState.COMPLETED)
          .build();

  @GivenTextResource("/domains/voice/v2/batches/response/BatchSessionSummaryDto.json")
  String jsonBatchSessionSummary;

  @Test
  void deserialize() throws JsonProcessingException {
    BatchSessionSummary deserialized =
        objectMapper.readValue(jsonBatchSessionSummary, BatchSessionSummary.class);

    TestHelpers.recursiveEquals(deserialized, expectedBatchSessionSummary);
  }
}
