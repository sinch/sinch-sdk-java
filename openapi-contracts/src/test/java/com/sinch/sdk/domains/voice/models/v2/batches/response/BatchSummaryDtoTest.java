package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BatchSummaryDtoTest extends BaseTest {

  public static final BatchSummary expectedBatchSummary =
      BatchSummary.builder()
          .setBatchId("01BX5ZZKBKACTAV9WEVGEMMVRC")
          .setSessionCount(3)
          .setEndTime(Instant.parse("2026-08-28T12:17:49Z"))
          .setQueued(1)
          .setInProgress(1)
          .setCompleted(1)
          .setExpired(0)
          .setTtlSeconds(3600)
          .setRequestedCps(10)
          .build();

  @GivenTextResource("/domains/voice/v2/batches/response/BatchSummaryDto.json")
  String jsonBatchSummary;

  @Test
  void deserialize() throws JsonProcessingException {
    BatchSummary deserialized = objectMapper.readValue(jsonBatchSummary, BatchSummary.class);

    TestHelpers.recursiveEquals(deserialized, expectedBatchSummary);
  }
}
