package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BatchStopResponseDtoTest extends BaseTest {

  public static final BatchStopResponse expectedBatchStopResponse =
      BatchStopResponse.builder().setResult(BatchStopResponse.ResultEnum.STOP_REQUESTED).build();

  @GivenTextResource("/domains/voice/v2/batches/response/BatchStopResponseDto.json")
  String jsonBatchStopResponse;

  @Test
  void deserialize() throws JsonProcessingException {
    BatchStopResponse deserialized =
        objectMapper.readValue(jsonBatchStopResponse, BatchStopResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedBatchStopResponse);
  }
}
