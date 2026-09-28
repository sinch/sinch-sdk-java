package com.sinch.sdk.domains.voice.models.v2.batches.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommandDtoTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartBatchRequestDtoTest extends BaseTest {

  static final Map<String, String> secondCallParameters = new HashMap<>();

  static {
    secondCallParameters.put("numberB", "+15559876544");
    secondCallParameters.put("name", "Alice");
  }

  public static final StartBatchRequest expectedStartBatchRequest =
      StartBatchRequest.builder()
          .setCommands(Arrays.asList(DialCommandDtoTest.expectedDialCommand))
          .setParameters(
              Arrays.asList(
                  Collections.singletonMap("numberB", "+15559876543"), secondCallParameters))
          .setBatchOptions(BatchOptionsDtoTest.expectedBatchOptions)
          .setIdempotencyKey("3f1c7a52-8d3e-4b9a-9c0e-2f6d1b7a4e21")
          .build();

  @GivenTextResource("/domains/voice/v2/batches/request/StartBatchRequestDto.json")
  String jsonStartBatchRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStartBatchRequest);

    JSONAssert.assertEquals(jsonStartBatchRequest, serializedString, true);
  }

  @Test
  void toStringMasksRecordingCredentials() {
    String string = expectedStartBatchRequest.toString();

    Assertions.assertFalse(string.contains("access-key:secret-key"), string);
    Assertions.assertTrue(string.contains("credentials: ***"), string);
  }
}
