package com.sinch.sdk.domains.numbers.models.v1.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddressDtoTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EmergencyAddressRequestDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/request/emergency-address-request.json")
  String emergencyAddressRequestJson;

  public static EmergencyAddressRequest emergencyAddressRequest =
      EmergencyAddressRequest.builder()
          .setDisplayName("a display")
          .setAddress(EmergencyAddressDtoTest.emergencyAddress)
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(emergencyAddressRequest);

    JSONAssert.assertEquals(emergencyAddressRequestJson, serializedString, true);
  }
}
