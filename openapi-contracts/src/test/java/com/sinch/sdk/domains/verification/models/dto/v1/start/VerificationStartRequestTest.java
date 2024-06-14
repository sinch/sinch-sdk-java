package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestDataImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartRequestInternalImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationStartRequestTest extends VerificationBaseTest {

  public static VerificationStartRequestInternalImpl startVerificationPhoneCallDto =
      new VerificationStartRequestInternalImpl(
          (VerificationStartRequestPhoneCallImpl)
              VerificationStartRequestPhoneCall.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setSpeech(PhoneCallSpeech.builder().setLocale("fr-FR").build())
                  .build());

  public static VerificationStartRequestInternalImpl startVerificationFlashCallDto =
      new VerificationStartRequestInternalImpl(
          (VerificationStartRequestFlashCallImpl)
              VerificationStartRequestFlashCall.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setDialTimeout(17)
                  .build());
  public static VerificationStartRequestInternalImpl startVerificationDataDto =
      new VerificationStartRequestInternalImpl(
          (VerificationStartRequestDataImpl)
              VerificationStartRequestData.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .build());
  public static VerificationStartRequestInternalImpl startVerificationSmsDto =
      new VerificationStartRequestInternalImpl(
          (VerificationStartRequestSmsImpl)
              VerificationStartRequestSms.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setExpiry("01:02:03")
                  .setCodeType(VerificationStartRequestSms.CodeTypeEnum.ALPHANUMERIC)
                  .setTemplate("My template require to use '{{CODE}}' code")
                  .build());

  public static VerificationStartRequestInternalImpl startVerificationSmsDtoWithAcceptLanguage =
      new VerificationStartRequestInternalImpl(
          (VerificationStartRequestSmsImpl)
              VerificationStartRequestSms.builder()
                  .setCustom("a custom")
                  .setReference("a reference")
                  .setIdentity(NumberIdentity.valueOf("+endpoint"))
                  .setExpiry("01:02:03")
                  .setCodeType(VerificationStartRequestSms.CodeTypeEnum.ALPHANUMERIC)
                  .setTemplate("My template require to use '{{CODE}}' code")
                  .setAcceptLanguage("es-ES")
                  .build());

  @GivenTextResource("/domains/verification/v1/start/VerificationStartRequestPhoneCallDto.json")
  String jsonStartVerificationPhoneCall;

  @GivenTextResource("/domains/verification/v1/start/VerificationStartRequestFlashCallDto.json")
  String jsonStartVerificationFlashCall;

  @GivenTextResource("/domains/verification/v1/start/VerificationStartRequestDataDto.json")
  String jsonStartVerificationData;

  @GivenTextResource("/domains/verification/v1/start/VerificationStartRequestSmsDto.json")
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

  @Test
  void serializeStartSmsCallWithAcceptLanguage() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(startVerificationSmsDtoWithAcceptLanguage);
    // acceptLanguage do not have to be serialized
    JSONAssert.assertEquals(jsonStartVerificationSms, serializedString, true);
  }
}
