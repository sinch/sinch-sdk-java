package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.voice.api.v2.SinchEventsService;
import com.sinch.sdk.domains.voice.models.v2.CallDtoTest;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.SinchEventType;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventDtoTest;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponseDtoTest;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class SinchEventsServiceTest extends BaseTest {

  // Signature example from the Voice V2 OAS "callWebhook" description
  static final String SERVICE_ID = "a74b1566-0f18-4f8e-9c23-8e6b5df8fd3e";
  static final String SERVICE_SECRET = "F5wrP9SKYU6w8sbZXkp7GA==";
  static final String PATH = "/voice-webhooks";
  static final String PAYLOAD =
      "{\"event\":\"call.incoming\",\"call\":{\"callId\":\"01AN4Z07BY79KA1307SR9X4MV3\"}}";
  static final String SIGNATURE = "EWFtVTrykdhMTdyYSbn40GBJpf5UBeggO9T99sdwLyY=";

  @GivenTextResource("/domains/voice/v2/sinchevents/VoiceSinchEventDto.json")
  String jsonVoiceSinchEvent;

  @GivenTextResource("/domains/voice/v2/sinchevents/VoiceSinchEventCustomEventDto.json")
  String jsonVoiceSinchEventCustomEvent;

  @GivenTextResource("/domains/voice/v2/sinchevents/VoiceSinchEventResponseDto.json")
  String jsonVoiceSinchEventResponse;

  SinchEventsService service;

  @BeforeEach
  public void initMocks() {
    // no credentials at all: Sinch Events do not depend on the client configuration
    service = new VoiceService(null, null, null, null).sinchEvents();
  }

  Map<String, String> signedHeaders() {
    Map<String, String> headers = new HashMap<>();
    headers.put("Authorization", "service " + SERVICE_ID + ":" + SIGNATURE);
    headers.put("Content-Type", "application/json; charset=utf-8");
    headers.put("x-timestamp", "2026-04-01T12:00:00.0000000Z");
    headers.put("ce-type", "com.sinch.voice.call.control.v1");
    return headers;
  }

  boolean validate(Map<String, String> headers, String payload) {
    return service.validateAuthenticationHeader(
        SERVICE_ID, SERVICE_SECRET, "POST", PATH, headers, payload);
  }

  @Test
  void validateAuthenticationHeader() {
    Assertions.assertThat(validate(signedHeaders(), PAYLOAD)).isTrue();
  }

  @Test
  void validateAuthenticationHeaderCaseInsensitive() {
    Map<String, String> headers = new HashMap<>();
    headers.put("authorization", "Service " + SERVICE_ID + ":" + SIGNATURE);
    headers.put("content-type", "application/json; charset=utf-8");
    headers.put("X-Timestamp", "2026-04-01T12:00:00.0000000Z");

    Assertions.assertThat(validate(headers, PAYLOAD)).isTrue();
  }

  @Test
  void validateAuthenticationHeaderIgnoresQueryString() {
    Assertions.assertThat(
            service.validateAuthenticationHeader(
                SERVICE_ID, SERVICE_SECRET, "POST", PATH + "?foo=bar", signedHeaders(), PAYLOAD))
        .isTrue();
  }

  @Test
  void rejectOtherServiceIdInHeader() {
    // the signature is valid for SERVICE_ID, but the header claims another service
    Map<String, String> headers = signedHeaders();
    headers.put("Authorization", "service other-service:" + SIGNATURE);

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectOtherServiceIdParameter() {
    Assertions.assertThat(
            service.validateAuthenticationHeader(
                "other-service", SERVICE_SECRET, "POST", PATH, signedHeaders(), PAYLOAD))
        .isFalse();
  }

  @Test
  void rejectOtherSecret() {
    Assertions.assertThat(
            service.validateAuthenticationHeader(
                SERVICE_ID, "YXBwU2VjcmV0", "POST", PATH, signedHeaders(), PAYLOAD))
        .isFalse();
  }

  @Test
  void rejectTamperedPayload() {
    Assertions.assertThat(validate(signedHeaders(), PAYLOAD.replace("incoming", "answered")))
        .isFalse();
  }

  @Test
  void rejectTamperedTimestamp() {
    Map<String, String> headers = signedHeaders();
    headers.put("x-timestamp", "2026-04-01T12:00:01.0000000Z");

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectOtherPath() {
    Assertions.assertThat(
            service.validateAuthenticationHeader(
                SERVICE_ID, SERVICE_SECRET, "POST", "/other", signedHeaders(), PAYLOAD))
        .isFalse();
  }

  @Test
  void validateAuthenticationHeaderLowerCaseMethod() {
    Assertions.assertThat(
            service.validateAuthenticationHeader(
                SERVICE_ID, SERVICE_SECRET, "post", PATH, signedHeaders(), PAYLOAD))
        .isTrue();
  }

  @Test
  void rejectOtherMethod() {
    Assertions.assertThat(
            service.validateAuthenticationHeader(
                SERVICE_ID, SERVICE_SECRET, "PUT", PATH, signedHeaders(), PAYLOAD))
        .isFalse();
  }

  @Test
  void rejectApplicationScheme() {
    Map<String, String> headers = signedHeaders();
    headers.put("Authorization", "Application " + SERVICE_ID + ":" + SIGNATURE);

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectMalformedAuthorization() {
    Map<String, String> headers = signedHeaders();
    headers.put("Authorization", "service " + SIGNATURE);

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();

    headers.put("Authorization", "service");
    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectEmptyAuthorization() {
    Map<String, String> headers = signedHeaders();
    headers.put("Authorization", "");

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectMissingAuthorization() {
    Map<String, String> headers = signedHeaders();
    headers.remove("Authorization");

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectMissingTimestamp() {
    Map<String, String> headers = signedHeaders();
    headers.remove("x-timestamp");

    Assertions.assertThat(validate(headers, PAYLOAD)).isFalse();
  }

  @Test
  void rejectNullHeaders() {
    Assertions.assertThat(validate(null, PAYLOAD)).isFalse();
  }

  @Test
  void requireServiceCredentials() {
    Assertions.assertThatThrownBy(
            () ->
                service.validateAuthenticationHeader(
                    "", SERVICE_SECRET, "POST", PATH, signedHeaders(), PAYLOAD))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("serviceId");

    Assertions.assertThatThrownBy(
            () ->
                service.validateAuthenticationHeader(
                    SERVICE_ID, null, "POST", PATH, signedHeaders(), PAYLOAD))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("serviceSecret");

    Assertions.assertThatThrownBy(
            () ->
                service.validateAuthenticationHeader(
                    SERVICE_ID, "not base64 !", "POST", PATH, signedHeaders(), PAYLOAD))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void parseEvent() throws ApiMappingException {
    VoiceSinchEvent event = service.parseEvent(jsonVoiceSinchEvent);

    TestHelpers.recursiveEquals(event, VoiceSinchEventDtoTest.expectedVoiceSinchEvent);
  }

  @Test
  void parseCustomEvent() throws ApiMappingException {
    VoiceSinchEvent event = service.parseEvent(jsonVoiceSinchEventCustomEvent);

    // sent as "call.webhook.on-answer", returned with the customEvent naming
    TestHelpers.recursiveEquals(
        event,
        VoiceSinchEvent.builder()
            .setEvent(SinchEventType.from("call.customEvent.on-answer"))
            .setCall(CallDtoTest.expectedCall)
            .build());
  }

  @Test
  void parseEventInvalidPayload() {
    Assertions.assertThatThrownBy(() -> service.parseEvent("{not json"))
        .isInstanceOf(ApiMappingException.class);
  }

  @Test
  void serializeResponse() throws ApiMappingException, JSONException {
    String serialized =
        service.serializeResponse(VoiceSinchEventResponseDtoTest.expectedVoiceSinchEventResponse);

    JSONAssert.assertEquals(jsonVoiceSinchEventResponse, serialized, true);
  }
}
