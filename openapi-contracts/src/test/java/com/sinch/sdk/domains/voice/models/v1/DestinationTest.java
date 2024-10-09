package com.sinch.sdk.domains.voice.models.v1;

import static org.junit.jupiter.api.Assertions.*;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class DestinationTest extends BaseTest {

  public static Destination userName =
      Destination.builder()
          .setType(DestinationType.USERNAME)
          .setEndpoint("user name value")
          .build();

  public static Destination number =
      Destination.builder().setType(DestinationType.NUMBER).setEndpoint("+123456789").build();

  public static Destination sip =
      Destination.builder().setType(DestinationType.SIP).setEndpoint("sip value").build();

  public static Destination did =
      Destination.builder().setType(DestinationType.DID).setEndpoint("did value").build();

  @GivenTextResource("/domains/voice/v1/DestinationUserNameDto.json")
  String jsonUserName;

  @GivenTextResource("/domains/voice/v1/DestinationNumberDto.json")
  String jsonNumber;

  @GivenTextResource("/domains/voice/v1/DestinationSipDto.json")
  String jsonSip;

  @GivenTextResource("/domains/voice/v1/DestinationDidDto.json")
  String jsonDid;

  @Test
  void serializeUserName() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(userName);

    JSONAssert.assertEquals(jsonUserName, serializedString, true);
  }

  @Test
  void deserializeUserName() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonUserName, Destination.class);

    TestHelpers.recursiveEquals(userName, expected);
  }

  @Test
  void serializeNumber() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(number);

    JSONAssert.assertEquals(jsonNumber, serializedString, true);
  }

  @Test
  void deserializeNumber() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonNumber, Destination.class);

    TestHelpers.recursiveEquals(number, expected);
  }

  @Test
  void serializeSIP() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sip);

    JSONAssert.assertEquals(jsonSip, serializedString, true);
  }

  @Test
  void deserializeSIP() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonSip, Destination.class);

    TestHelpers.recursiveEquals(sip, expected);
  }

  @Test
  void serializeDID() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(did);

    JSONAssert.assertEquals(jsonDid, serializedString, true);
  }

  @Test
  void deserializeDID() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonDid, Destination.class);

    TestHelpers.recursiveEquals(did, expected);
  }
}
