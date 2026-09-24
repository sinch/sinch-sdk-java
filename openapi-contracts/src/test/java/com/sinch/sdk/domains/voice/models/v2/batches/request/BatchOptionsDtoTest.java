package com.sinch.sdk.domains.voice.models.v2.batches.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class BatchOptionsDtoTest extends BaseTest {

  public static final BatchOptions expectedBatchOptions =
      BatchOptions.builder().setMaxCps(10).setTtlSeconds(3600).build();

  @GivenTextResource("/domains/voice/v2/batches/request/BatchOptionsDto.json")
  String jsonBatchOptions;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedBatchOptions);

    JSONAssert.assertEquals(jsonBatchOptions, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    BatchOptions deserialized = objectMapper.readValue(jsonBatchOptions, BatchOptions.class);

    TestHelpers.recursiveEquals(deserialized, expectedBatchOptions);
  }
}
