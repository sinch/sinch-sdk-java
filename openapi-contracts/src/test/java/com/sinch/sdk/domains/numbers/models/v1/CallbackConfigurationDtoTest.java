package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CallbackConfigurationDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/callbacks/callback-get-response.json")
  String callbackGetResponseJson;

  @GivenTextResource("/domains/numbers/v1/callbacks/callback-update-request.json")
  String callbackUpdateRequestJson;

  public static CallbackConfigurationUpdateRequest updateRequest =
      CallbackConfigurationUpdateRequest.builder().setHmacSecret("HMAC value").build();

  public static CallbackConfigurationResponse getResponse =
      CallbackConfigurationResponse.builder()
          .setProjectId("Project ID value")
          .setHmacSecret("HMAC value")
          .build();

  @Test
  void serializeUpdateRequest() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(updateRequest);

    JSONAssert.assertEquals(callbackUpdateRequestJson, serializedString, true);
  }

  @Test
  void deserializeGetResponse() throws JsonProcessingException {

    CallbackConfigurationResponse deserializedString =
        objectMapper.readValue(callbackGetResponseJson, CallbackConfigurationResponse.class);

    TestHelpers.recursiveEquals(getResponse, deserializedString);
  }
}
