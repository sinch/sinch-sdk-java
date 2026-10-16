package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.destination.Sip;
import com.sinch.sdk.domains.voice.models.v2.destination.SipFrom;
import com.sinch.sdk.domains.voice.models.v2.destination.Stream;
import com.sinch.sdk.domains.voice.models.v2.destination.VoiceRelay;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class DestinationTest extends BaseTest {

  static final String PHONE_JSON = "{\"type\":\"PHONE\",\"phone\":{\"number\":\"+15551234567\"}}";
  static final String SIP_JSON =
      "{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:user@example.com\"}}";
  static final String SIPS_JSON =
      "{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sips:user@example.com\"}}";
  static final String STREAM_JSON =
      "{\"type\":\"STREAM\",\"stream\":{\"endpoint\":\"wss://example.com/audio\"}}";

  void assertJson(Object value, String expected) throws JsonProcessingException, JSONException {
    JSONAssert.assertEquals(expected, objectMapper.writeValueAsString(value), true);
  }

  @Test
  void phone() throws JsonProcessingException, JSONException {
    Phone destination = Destination.phone("+15551234567");

    assertJson(destination, PHONE_JSON);
  }

  @Test
  void sip() throws JsonProcessingException, JSONException {
    Sip destination = Destination.sip("sip:user@example.com");

    assertJson(destination, SIP_JSON);
  }

  @Test
  void sipKeepsEndpointWithoutScheme() throws JsonProcessingException, JSONException {
    Sip destination = Destination.sip("user@example.com");

    assertJson(destination, "{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"user@example.com\"}}");
  }

  @Test
  void sipFrom() throws JsonProcessingException, JSONException {
    SipFrom origin = Destination.sipFrom("sip:user@example.com");

    assertJson(origin, SIP_JSON);
  }

  @Test
  void stream() throws JsonProcessingException, JSONException {
    Stream destination = Destination.stream("wss://example.com/audio");

    assertJson(destination, STREAM_JSON);
  }

  @Test
  void voiceRelay() throws JsonProcessingException, JSONException {
    VoiceRelay destination = Destination.voiceRelay("wss://example.com/agent", "Emma", "en-US");

    assertJson(
        destination,
        "{\"type\":\"VOICE_RELAY\",\"voiceRelay\":{\"endpoint\":\"wss://example.com/agent\","
            + "\"ttsVoice\":\"Emma\",\"sttLanguage\":\"en-US\"}}");
  }

  @Test
  void voiceRelayAcceptsVoiceOutsideCatalog() {
    VoiceRelay destination =
        Destination.voiceRelay("wss://example.com/agent", "FutureVoice", "en-US");

    Assertions.assertThat(destination.getTtsVoice()).isEqualTo("FutureVoice");
  }

  @Test
  void ofUntaggedIsPhone() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("+15551234567");

    Assertions.assertThat(destination).isInstanceOf(Phone.class);
    assertJson(destination, PHONE_JSON);
  }

  @Test
  void ofStripsPhoneTag() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("phone:+15551234567");

    Assertions.assertThat(destination).isInstanceOf(Phone.class);
    assertJson(destination, PHONE_JSON);
  }

  @Test
  void ofKeepsSipEndpoint() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("sip:user@example.com");

    Assertions.assertThat(destination).isInstanceOf(Sip.class);
    assertJson(destination, SIP_JSON);
  }

  @Test
  void ofKeepsSipsEndpoint() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("sips:user@example.com");

    Assertions.assertThat(destination).isInstanceOf(Sip.class);
    assertJson(destination, SIPS_JSON);
  }

  @Test
  void ofStripsStreamTag() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("stream:wss://example.com/audio");

    Assertions.assertThat(destination).isInstanceOf(Stream.class);
    assertJson(destination, STREAM_JSON);
  }

  @Test
  void ofKeepsUnknownPrefixAsPhoneNumber() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("tel:+15551234567");

    Assertions.assertThat(destination).isInstanceOf(Phone.class);
    assertJson(destination, "{\"type\":\"PHONE\",\"phone\":{\"number\":\"tel:+15551234567\"}}");
  }

  @Test
  void ofKeepsBatchPlaceholderAsPhoneNumber() throws JsonProcessingException, JSONException {
    CallDestination destination = Destination.of("@toNumber");

    assertJson(destination, "{\"type\":\"PHONE\",\"phone\":{\"number\":\"@toNumber\"}}");
  }

  @Test
  void originOfUntaggedIsPhone() throws JsonProcessingException, JSONException {
    CallOrigin origin = Destination.originOf("+15551234567");

    Assertions.assertThat(origin).isInstanceOf(Phone.class);
    assertJson(origin, PHONE_JSON);
  }

  @Test
  void originOfStripsPhoneTag() throws JsonProcessingException, JSONException {
    CallOrigin origin = Destination.originOf("phone:+15551234567");

    Assertions.assertThat(origin).isInstanceOf(Phone.class);
    assertJson(origin, PHONE_JSON);
  }

  @Test
  void originOfKeepsSipEndpoint() throws JsonProcessingException, JSONException {
    CallOrigin origin = Destination.originOf("sip:user@example.com");

    Assertions.assertThat(origin).isInstanceOf(SipFrom.class);
    assertJson(origin, SIP_JSON);
  }

  @Test
  void originOfKeepsSipsEndpoint() throws JsonProcessingException, JSONException {
    CallOrigin origin = Destination.originOf("sips:user@example.com");

    Assertions.assertThat(origin).isInstanceOf(SipFrom.class);
    assertJson(origin, SIPS_JSON);
  }

  @Test
  void originOfRejectsStream() {
    Assertions.assertThatThrownBy(() -> Destination.originOf("stream:wss://example.com/audio"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("stream:wss://example.com/audio");
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> Destination.of(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.originOf(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.phone(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.sip(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.sipFrom(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.stream(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.voiceRelay("wss://example.com", "Emma", null))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void parsedValuesAreAcceptedAsDialFromAndTo() throws JsonProcessingException, JSONException {
    DialCommand dial =
        DialCommand.builder()
            .setFrom(Destination.originOf("sip:15550001111@sip.sinch.com"))
            .setTo(Destination.of("sip:15550002222@sip.sinch.com"))
            .build();

    assertJson(
        dial,
        "{\"command\":\"dial\","
            + "\"from\":{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:15550001111@sip.sinch.com\"}},"
            + "\"to\":{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:15550002222@sip.sinch.com\"}}}");
  }
}
