package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationDataRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationDataRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationFlashCallRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationPhoneCallRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternal;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternalImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartVerificationRequestTest extends VerificationBaseTest {

  public static StartVerificationRequestInternal startVerificationPhoneCallDto =
      new StartVerificationRequestInternalImpl(
          (StartVerificationPhoneCallRequestImpl)
              StartVerificationPhoneCallRequest.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setCalloutOptions(
                      StartVerificationPhoneCallOptions.builder()
                          .setSpeech(PhoneCallSpeech.builder().setLocale("fr-FR").build())
                          .build())
                  .build());

  public static StartVerificationRequestInternalImpl startVerificationFlashCallDto =
      new StartVerificationRequestInternalImpl(
          (StartVerificationFlashCallRequestImpl)
              StartVerificationFlashCallRequest.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setFlashCallOptions(
                      StartVerificationFlashCallOptions.builder().setDialTimeout(17).build())
                  .build());
  public static StartVerificationRequestInternalImpl startVerificationDataDto =
      new StartVerificationRequestInternalImpl(
          (StartVerificationDataRequestImpl)
              StartVerificationDataRequest.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .build());
  public static StartVerificationRequestInternalImpl startVerificationSmsDto =
      new StartVerificationRequestInternalImpl(
          (StartVerificationSmsRequestImpl)
              StartVerificationSmsRequest.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setExpiry("01:02:03")
                  .setCodeType(StartVerificationSmsRequest.CodeTypeEnum.ALPHANUMERIC)
                  .setTemplate("My template require to use '{{CODE}}' code")
                  .build());

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
