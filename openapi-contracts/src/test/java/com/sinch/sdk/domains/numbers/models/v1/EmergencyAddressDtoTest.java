package com.sinch.sdk.domains.numbers.models.v1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EmergencyAddressDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/emergency-address.json")
  String emergencyAddressJson;

  public static EmergencyAddress emergencyAddress =
      EmergencyAddress.builder()
          .setStreetNumber("3500")
          .setStreetInfo("Lenox Rd NE")
          .setLocation("a location")
          .setCity("Atlanta")
          .setState("GA")
          .setPostalCode("30326")
          .setPostalCodePlusFour("4228")
          .build();

  @Test
  // none of the fields are required when used from a response
  void deserializeEmpty() throws JsonProcessingException {

    EmergencyAddress deserializedString = objectMapper.readValue("{}", EmergencyAddress.class);

    TestHelpers.recursiveEquals(EmergencyAddress.builder().build(), deserializedString);
  }

  @Test
  // but some are required when used for a request
  void serializeEmpty() {

    Exception exception =
        assertThrows(
            JsonMappingException.class,
            () -> objectMapper.writeValueAsString(EmergencyAddress.builder().build()));
    assertTrue(exception.getMessage().contains("Required property"));
  }

  @Test
  void deserialize() throws JsonProcessingException {

    EmergencyAddress deserializedString =
        objectMapper.readValue(emergencyAddressJson, EmergencyAddress.class);

    TestHelpers.recursiveEquals(emergencyAddress, deserializedString);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(emergencyAddress);

    JSONAssert.assertEquals(emergencyAddressJson, serializedString, true);
  }
}
