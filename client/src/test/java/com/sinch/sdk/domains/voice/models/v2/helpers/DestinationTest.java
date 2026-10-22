package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.VoiceName;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallHeader;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import com.sinch.sdk.domains.voice.models.v2.destination.Phone;
import com.sinch.sdk.domains.voice.models.v2.destination.Sip;
import com.sinch.sdk.domains.voice.models.v2.destination.SipCallHeader;
import com.sinch.sdk.domains.voice.models.v2.destination.SipFrom;
import com.sinch.sdk.domains.voice.models.v2.destination.Stream;
import com.sinch.sdk.domains.voice.models.v2.destination.StreamOptions;
import com.sinch.sdk.domains.voice.models.v2.destination.VoiceRelay;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import java.util.Collections;
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
    assertJson(Destination.of("+15551234567"), PHONE_JSON);
  }

  @Test
  void ofStripsPhoneTag() throws JsonProcessingException, JSONException {
    assertJson(Destination.of("phone:+15551234567"), PHONE_JSON);
  }

  @Test
  void ofKeepsSipEndpoint() throws JsonProcessingException, JSONException {
    assertJson(Destination.of("sip:user@example.com"), SIP_JSON);
  }

  @Test
  void ofKeepsSipsEndpoint() throws JsonProcessingException, JSONException {
    assertJson(Destination.of("sips:user@example.com"), SIPS_JSON);
  }

  @Test
  void ofStripsStreamTag() throws JsonProcessingException, JSONException {
    assertJson(Destination.of("stream:wss://example.com/audio"), STREAM_JSON);
  }

  @Test
  void ofKeepsUnknownPrefixAsPhoneNumber() throws JsonProcessingException, JSONException {
    assertJson(
        Destination.of("tel:+15551234567"),
        "{\"type\":\"PHONE\",\"phone\":{\"number\":\"tel:+15551234567\"}}");
  }

  @Test
  void ofKeepsBatchPlaceholderAsPhoneNumber() throws JsonProcessingException, JSONException {
    assertJson(
        Destination.of("@toNumber"), "{\"type\":\"PHONE\",\"phone\":{\"number\":\"@toNumber\"}}");
  }

  @Test
  void ofIsBothCallOriginAndCallDestination() {
    BaseDestination endpoint = Destination.of("sip:user@example.com");

    Assertions.assertThat(endpoint).isInstanceOf(CallOrigin.class);
    Assertions.assertThat(endpoint).isInstanceOf(CallDestination.class);
  }

  @Test
  void ofComparesByValue() {
    Assertions.assertThat(Destination.of("phone:+15551234567"))
        .isEqualTo(Destination.of("+15551234567"))
        .hasSameHashCodeAs(Destination.of("+15551234567"))
        .isNotEqualTo(Destination.of("sip:user@example.com"));
  }

  @Test
  void ofToStringIsTheWrappedModel() {
    Assertions.assertThat(Destination.of("+15551234567"))
        .hasToString(Destination.phone("+15551234567").toString());
  }

  @Test
  void ofValuesAreAcceptedAsDialFromAndTo() throws JsonProcessingException, JSONException {
    DialCommand dial =
        DialCommand.builder()
            .setFrom(Destination.of("sip:15550001111@sip.sinch.com"))
            .setTo(Destination.of("sip:15550002222@sip.sinch.com"))
            .build();

    assertJson(
        dial,
        "{\"command\":\"dial\","
            + "\"from\":{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:15550001111@sip.sinch.com\"}},"
            + "\"to\":{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:15550002222@sip.sinch.com\"}}}");
  }

  @Test
  void ofValuesAreSerializedInStartCallRequest() throws JsonProcessingException, JSONException {
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                Collections.singletonList(
                    DialCommand.builder()
                        .setFrom(Destination.of("+15550001111"))
                        .setTo(Destination.of("stream:wss://example.com/audio"))
                        .build()))
            .build();

    assertJson(
        request,
        "{\"commands\":[{\"command\":\"dial\","
            + "\"from\":{\"type\":\"PHONE\",\"phone\":{\"number\":\"+15550001111\"}},"
            + "\"to\":{\"type\":\"STREAM\",\"stream\":{\"endpoint\":\"wss://example.com/audio\"}}}]}");
  }

  @Test
  void sipWithOptionalFields() throws JsonProcessingException, JSONException {
    Sip destination =
        Destination.sip(
            "sip:user@example.com",
            sip ->
                sip.setTransport(Sip.TransportEnum.TCP)
                    .setCallHeaders(
                        Collections.singletonList(
                            SipCallHeader.builder().setKey("X-Id").setValue("1").build())));

    assertJson(
        destination,
        "{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:user@example.com\",\"transport\":\"TCP\","
            + "\"callHeaders\":[{\"key\":\"X-Id\",\"value\":\"1\"}]}}");
  }

  @Test
  void sipFromWithOptionalFields() throws JsonProcessingException, JSONException {
    SipFrom origin =
        Destination.sipFrom("sip:user@example.com", sip -> sip.setDisplayName("Alice"));

    assertJson(
        origin,
        "{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:user@example.com\","
            + "\"displayName\":\"Alice\"}}");
  }

  @Test
  void streamWithOptionalFields() throws JsonProcessingException, JSONException {
    Stream destination =
        Destination.stream(
            "wss://example.com/audio",
            stream ->
                stream
                    .setStreamOptions(
                        StreamOptions.builder()
                            .setSampleRate(StreamOptions.SampleRateEnum.HZ_16000)
                            .build())
                    .setCallHeaders(
                        Collections.singletonList(
                            CallHeader.builder().setKey("X-Id").setValue("1").build())));

    assertJson(
        destination,
        "{\"type\":\"STREAM\",\"stream\":{\"endpoint\":\"wss://example.com/audio\","
            + "\"streamOptions\":{\"sampleRate\":16000},"
            + "\"callHeaders\":[{\"key\":\"X-Id\",\"value\":\"1\"}]}}");
  }

  @Test
  void voiceRelayWithOptionalFields() throws JsonProcessingException, JSONException {
    VoiceRelay destination =
        Destination.voiceRelay(
            "wss://example.com/agent",
            "Emma",
            "en-US",
            relay -> relay.setEnableInterruptions(false));

    assertJson(
        destination,
        "{\"type\":\"VOICE_RELAY\",\"voiceRelay\":{\"endpoint\":\"wss://example.com/agent\","
            + "\"ttsVoice\":\"Emma\",\"sttLanguage\":\"en-US\",\"enableInterruptions\":false}}");
  }

  @Test
  void emptyLambdaIsTheSameAsTheSimpleFactory() {
    Assertions.assertThat(Destination.sip("sip:user@example.com", sip -> {}))
        .isEqualTo(Destination.sip("sip:user@example.com"));
    Assertions.assertThat(Destination.stream("wss://example.com/audio", stream -> {}))
        .isEqualTo(Destination.stream("wss://example.com/audio"));
  }

  @Test
  void rejectsNullLambda() {
    Assertions.assertThatThrownBy(() -> Destination.sip("sip:user@example.com", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.sipFrom("sip:user@example.com", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Destination.stream("wss://example.com/audio", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> Destination.voiceRelay("wss://example.com", "Emma", "en-US", null))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void voiceRelayAcceptsAVoiceNameFromTheCatalog() {
    Assertions.assertThat(
            Destination.voiceRelay("wss://example.com/agent", VoiceName.EMMA, "en-US"))
        .isEqualTo(Destination.voiceRelay("wss://example.com/agent", "Emma", "en-US"));
    Assertions.assertThat(
            Destination.voiceRelay(
                "wss://example.com/agent",
                VoiceName.EMMA,
                "en-US",
                relay -> relay.setEnableInterruptions(false)))
        .isEqualTo(
            Destination.voiceRelay(
                "wss://example.com/agent",
                "Emma",
                "en-US",
                relay -> relay.setEnableInterruptions(false)));
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> Destination.of(null))
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
}
