package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BatchDetailsDtoTest extends BaseTest {

  public static final BatchDetails expectedBatchDetails =
      BatchDetails.builder()
          .setSessions(
              Arrays.asList(
                  BatchSessionSummaryDtoTest.expectedBatchSessionSummary,
                  BatchSessionSummary.builder()
                      .setId("01F8Z5J4X2G9Y3J4X2G9Y3J4X5YJ")
                      .setState(SessionState.IN_PROGRESS)
                      .build(),
                  BatchSessionSummary.builder()
                      .setId("01F8Z5J4X2G9Y3J4X2G9Y3J4X9QK")
                      .setState(SessionState.QUEUED)
                      .build()))
          .build();

  @GivenTextResource("/domains/voice/v2/batches/response/BatchDetailsDto.json")
  String jsonBatchDetails;

  @Test
  void deserialize() throws JsonProcessingException {
    BatchDetails deserialized = objectMapper.readValue(jsonBatchDetails, BatchDetails.class);

    TestHelpers.recursiveEquals(deserialized, expectedBatchDetails);
  }
}
