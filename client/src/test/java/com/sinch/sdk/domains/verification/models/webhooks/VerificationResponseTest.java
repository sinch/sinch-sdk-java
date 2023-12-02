package com.sinch.sdk.domains.verification.models.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class VerificationResponseTest extends BaseTest {

  @GivenTextResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResponseSMS.json")
  String jsonResponseSMS;

  @GivenTextResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResponseSMSEmptySMS.json")
  String jsonResponseSMSEmptySMS;

  @GivenTextResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResponseFlashCall.json")
  String jsonResponseFlashCall;

  @GivenTextResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResponseFlashCallEmptyFlashCall.json")
  String jsonResponseFlashCallEmptyFlashCall;

  @GivenTextResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResponseCallout.json")
  String jsonResponseCallout;

  @GivenTextResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResponseCalloutEmptyCallout.json")
  String jsonResponseCalloutEmptyCallout;

  @Test
  void serializeSMSResponse() throws JsonProcessingException, JSONException {

    VerificationResponseSMS value =
        VerificationResponseSMS.builder()
            .setAction(VerificationResponseActionType.DENY)
            .setCode(5666)
            .setAcceptLanguage(Collections.singletonList("a language"))
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseSMS, serializedString, true);
  }

  @Test
  void serializeSMSResponseEmptySms() throws JsonProcessingException, JSONException {

    VerificationResponseSMS value =
        VerificationResponseSMS.builder().setAction(VerificationResponseActionType.ALLOW).build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseSMSEmptySMS, serializedString, true);
  }

  @Test
  void serializeSMS() throws JsonProcessingException, JSONException {

    VerificationResponseSMS.SMSResponse value =
        new VerificationResponseSMS.SMSResponse(7890, Collections.singletonList("a language"));

    String expectedJSON = "{\"code\": 7890, \"acceptLanguage\":[\"a language\"]}";
    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(expectedJSON, serializedString, true);
  }

  @Test
  void serializeEmptySMS() throws JsonProcessingException, JSONException {

    VerificationResponseSMS.SMSResponse value = new VerificationResponseSMS.SMSResponse(null, null);

    String expectedJSON = "{}";
    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(expectedJSON, serializedString, true);
  }

  @Test
  void serializeFlashCallResponse() throws JsonProcessingException, JSONException {

    VerificationResponseFlashCall value =
        VerificationResponseFlashCall.builder()
            .setAction(VerificationResponseActionType.DENY)
            .setCli("cli code")
            .setDialTimeout(123)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseFlashCall, serializedString, true);
  }

  @Test
  void serializeFlashCallResponseEmptyFlashCall() throws JsonProcessingException, JSONException {

    VerificationResponseFlashCall value =
        VerificationResponseFlashCall.builder()
            .setAction(VerificationResponseActionType.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseFlashCallEmptyFlashCall, serializedString, true);
  }

  @Test
  void serializeFlashCall() throws JsonProcessingException, JSONException {

    VerificationResponseFlashCall.FlashCallResponse value =
        new VerificationResponseFlashCall.FlashCallResponse("cli code", 123);

    String expectedJSON = "{\"cli\": \"cli code\", \"dialTimeout\":123}";
    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(expectedJSON, serializedString, true);
  }

  @Test
  void serializeEmptyFlashCall() throws JsonProcessingException, JSONException {

    VerificationResponseFlashCall.FlashCallResponse value =
        new VerificationResponseFlashCall.FlashCallResponse(null, null);

    String expectedJSON = "{}";
    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(expectedJSON, serializedString, true);
  }

  @Test
  void serializeCalloutResponse() throws JsonProcessingException, JSONException {

    VerificationResponseCallout value =
        VerificationResponseCallout.builder()
            .setAction(VerificationResponseActionType.DENY)
            .setCode(4567)
            .setLocale("the locale")
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseCallout, serializedString, true);
  }

  @Test
  void serializeCalloutResponseEmptyCallout() throws JsonProcessingException, JSONException {

    VerificationResponseCallout value =
        VerificationResponseCallout.builder()
            .setAction(VerificationResponseActionType.ALLOW)
            .setLocale(null)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseCalloutEmptyCallout, serializedString, true);
  }

  @Test
  void serializeCallout() throws JsonProcessingException, JSONException {

    VerificationResponseCallout.CalloutResponse value =
        new VerificationResponseCallout.CalloutResponse(
            1230, new VerificationResponseCallout.SpeechResponse("the locale"));

    String expectedJSON = "{\"code\": 1230, \"speech\":{\"locale\":  \"the locale\"}}";
    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(expectedJSON, serializedString, true);
  }

  @Test
  void serializeEmptyCallout() throws JsonProcessingException, JSONException {

    VerificationResponseCallout.CalloutResponse value =
        new VerificationResponseCallout.CalloutResponse(null, null);

    String expectedJSON = "{}";
    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(expectedJSON, serializedString, true);
  }
}
