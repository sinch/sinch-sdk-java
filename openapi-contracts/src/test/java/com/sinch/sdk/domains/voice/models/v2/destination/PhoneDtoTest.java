package com.sinch.sdk.domains.voice.models.v2.destination;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class PhoneDtoTest extends BaseTest {

  public static final Phone expectedPhone =
      Phone.builder().setPhone(PhoneDetailsDtoTest.expectedPhoneDetails).build();

  @GivenTextResource("/domains/voice/v2/destination/PhoneDto.json")
  String jsonPhone;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedPhone);

    JSONAssert.assertEquals(jsonPhone, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Phone deserialized = objectMapper.readValue(jsonPhone, Phone.class);

    TestHelpers.recursiveEquals(deserialized, expectedPhone);
  }
}
