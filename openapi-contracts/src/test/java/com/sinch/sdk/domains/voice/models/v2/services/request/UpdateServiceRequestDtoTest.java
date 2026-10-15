package com.sinch.sdk.domains.voice.models.v2.services.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.services.EventDestinationCallBehaviorDtoTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class UpdateServiceRequestDtoTest extends BaseTest {

  public static final UpdateServiceRequest expectedUpdateServiceRequest =
      UpdateServiceRequest.builder()
          .setDescription("Service with webhooks")
          .setCallBehavior(EventDestinationCallBehaviorDtoTest.expectedEventDestinationCallBehavior)
          .setIdempotencyKey("7b2e9f4a-3c8d-4a1e-b6f5-0d9c2a7e4b13")
          .build();

  @GivenTextResource("/domains/voice/v2/services/request/UpdateServiceRequestDto.json")
  String jsonUpdateServiceRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedUpdateServiceRequest);

    JSONAssert.assertEquals(jsonUpdateServiceRequest, serializedString, true);
  }
}
