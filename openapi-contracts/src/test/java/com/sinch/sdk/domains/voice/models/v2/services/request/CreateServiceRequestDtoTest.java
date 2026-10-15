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
public class CreateServiceRequestDtoTest extends BaseTest {

  public static final CreateServiceRequest expectedCreateServiceRequest =
      CreateServiceRequest.builder()
          .setName("Example service")
          .setDescription("Service with webhooks")
          .setIsDefault(true)
          .setCallBehavior(EventDestinationCallBehaviorDtoTest.expectedEventDestinationCallBehavior)
          .setIdempotencyKey("3f9c2a7e-8b1d-4e6f-9a2c-5d7e1b4f8c30")
          .build();

  @GivenTextResource("/domains/voice/v2/services/request/CreateServiceRequestDto.json")
  String jsonCreateServiceRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCreateServiceRequest);

    JSONAssert.assertEquals(jsonCreateServiceRequest, serializedString, true);
  }
}
