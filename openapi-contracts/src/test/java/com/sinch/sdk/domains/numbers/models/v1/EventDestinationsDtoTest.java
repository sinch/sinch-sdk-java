package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.eventdestinations.request.EventDestinationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.eventdestinations.response.EventDestinationResponse;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EventDestinationsDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/eventdestinations/event-destination-response.json")
  String callbackGetResponseJson;

  @GivenTextResource("/domains/numbers/v1/eventdestinations/event-destination-update-request.json")
  String callbackUpdateRequestJson;

  public static EventDestinationUpdateRequest updateRequest =
      EventDestinationUpdateRequest.builder().setHmacSecret("HMAC value").build();

  public static EventDestinationResponse getResponse =
      EventDestinationResponse.builder()
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

    EventDestinationResponse deserializedString =
        objectMapper.readValue(callbackGetResponseJson, EventDestinationResponse.class);

    TestHelpers.recursiveEquals(getResponse, deserializedString);
  }
}
