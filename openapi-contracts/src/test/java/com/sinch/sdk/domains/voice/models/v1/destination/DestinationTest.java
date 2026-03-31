package com.sinch.sdk.domains.voice.models.v1.destination;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.adapters.VoiceBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class DestinationTest extends VoiceBaseTest {

  public static DestinationMxp userName =
      DestinationMxp.builder().setEndpoint("user name value").build();

  public static DestinationPstn number =
      DestinationPstn.builder().setEndpoint("+123456789").build();

  public static DestinationSip sip = DestinationSip.builder().setEndpoint("sip value").build();

  public static DestinationDid did = DestinationDid.builder().setEndpoint("did value").build();

  public static DestinationWebSocket webSocket =
      DestinationWebSocket.builder().setEndpoint("wss://yourcompany.com/websocket-server").build();

  @GivenTextResource("/domains/voice/v1/destination/DestinationMxpDto.json")
  String jsonUserName;

  @GivenTextResource("/domains/voice/v1/destination/DestinationMxpAliasDto.json")
  String jsonUserNameAlias;

  @GivenTextResource("/domains/voice/v1/destination/DestinationPstnDto.json")
  String jsonNumber;

  @GivenTextResource("/domains/voice/v1/destination/DestinationPstnAliasDto.json")
  String jsonNumberAlias;

  @GivenTextResource("/domains/voice/v1/destination/DestinationSipDto.json")
  String jsonSip;

  @GivenTextResource("/domains/voice/v1/destination/DestinationDidDto.json")
  String jsonDid;

  @GivenTextResource("/domains/voice/v1/destination/DestinationWebSocketDto.json")
  String jsonWebSocket;

  @Test
  void serializeMxp() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(userName);

    JSONAssert.assertEquals(jsonUserName, serializedString, true);
  }

  @Test
  void deserializeMxp() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonUserName, Destination.class);

    TestHelpers.recursiveEquals(userName, expected);
  }

  @Test
  void deserializeMxpAlias() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonUserNameAlias, Destination.class);

    TestHelpers.recursiveEquals(userName, expected);
  }

  @Test
  void serializePstn() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(number);

    JSONAssert.assertEquals(jsonNumber, serializedString, true);
  }

  @Test
  void deserializePstn() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonNumber, Destination.class);

    TestHelpers.recursiveEquals(number, expected);
  }

  @Test
  void deserializePstnAlias() throws JsonProcessingException {
    Destination expected = objectMapper.readValue(jsonNumberAlias, Destination.class);

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

  @Test
  void serializeWebSocket() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(webSocket);

    JSONAssert.assertEquals(jsonWebSocket, serializedString, true);
  }

  @Test
  void deserializeWebSocket() throws JsonProcessingException {
    DestinationWebSocket expected =
        objectMapper.readValue(jsonWebSocket, DestinationWebSocket.class);

    TestHelpers.recursiveEquals(webSocket, expected);
  }
}
