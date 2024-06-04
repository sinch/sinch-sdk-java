package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal.TypeEnum;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsOptions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartVerificationRequestTest extends BaseTest {

  public static StartVerificationRequestParameters startVerificationPhoneCallDto =
      StartVerificationRequestParameters.builder()
          .setMethod(VerificationMethod.CALLOUT)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(
              IdentityInternal.builder().setType(TypeEnum.NUMBER).setEndpoint("+endpoint").build())
          .setCalloutOptions(
              StartVerificationPhoneCallOptions.builder()
                  .setSpeech(PhoneCallSpeech.builder().setLocale("fr-FR").build())
                  .build())
          .build();

  public static StartVerificationRequestParameters startVerificationFlashCallDto =
      StartVerificationRequestParameters.builder()
          .setMethod(VerificationMethod.FLASHCALL)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(
              IdentityInternal.builder().setType(TypeEnum.NUMBER).setEndpoint("+endpoint").build())
          .setFlashCallOptions(
              StartVerificationFlashCallOptions.builder().setDialTimeout(17).build())
          .build();
  public static StartVerificationRequestParameters startVerificationDataDto =
      StartVerificationRequestParameters.builder()
          .setMethod(VerificationMethod.SEAMLESS)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(
              IdentityInternal.builder().setType(TypeEnum.NUMBER).setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationRequestParameters startVerificationSmsDto =
      StartVerificationRequestParameters.builder()
          .setMethod(VerificationMethod.SMS)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(
              IdentityInternal.builder().setType(TypeEnum.NUMBER).setEndpoint("+endpoint").build())
          .setSmsOptions(
              StartVerificationSmsOptions.builder()
                  .setExpiry("01:02:03")
                  .setCodeType(StartVerificationSmsOptions.CodeTypeEnum.ALPHANUMERIC)
                  .setTemplate("My template require to use '{{CODE}}' code")
                  .build())
          .build();

  @GivenTextResource("/domains/verification/v1/start/StartVerificationPhoneCallRequestDto.json")
  String jsonStartVerificationPhoneCall;

  @GivenTextResource("/domains/verification/v1/start/StartVerificationFlashCallRequestDto.json")
  String jsonStartVerificationFlashCall;

  @GivenTextResource("/domains/verification/v1/start/StartVerificationDataRequestDto.json")
  String jsonStartVerificationData;

  @GivenTextResource("/domains/verification/v1/start/StartVerificationSmsRequestDto.json")
  String jsonStartVerificationSms;

  @Test
  void serializeStartPhoneCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationPhoneCallDto);

    JSONAssert.assertEquals(jsonStartVerificationPhoneCall, serializedString, true);
  }

  @Test
  void serializeStartFlashCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationFlashCallDto);

    JSONAssert.assertEquals(jsonStartVerificationFlashCall, serializedString, true);
  }

  @Test
  void serializeStartDataCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationDataDto);

    JSONAssert.assertEquals(jsonStartVerificationData, serializedString, true);
  }

  @Test
  void serializeStartSmsCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationSmsDto);

    JSONAssert.assertEquals(jsonStartVerificationSms, serializedString, true);
  }
}
