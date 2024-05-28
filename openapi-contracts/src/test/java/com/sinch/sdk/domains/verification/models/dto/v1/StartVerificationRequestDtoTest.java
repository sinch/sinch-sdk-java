package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartVerificationRequestDtoTest extends BaseTest {

  public static InitiateVerificationResourceDto startVerificationCalloutDto =
      new InitiateVerificationResourceDto()
          .method(VerificationMethodDto.CALLOUT)
          .custom("a custom")
          .reference("a reference")
          .identity(new IdentityDto().type("number").endpoint("+endpoint"))
          .calloutOptions(
              new InitiateVerificationResourceCalloutOptionsDto()
                  .speech(
                      new InitiateVerificationResourceCalloutOptionsSpeechDto().locale("fr-FR")));
  public static InitiateVerificationResourceDto startVerificationFlashCallDto =
      new InitiateVerificationResourceDto()
          .method(VerificationMethodDto.FLASHCALL)
          .custom("a custom")
          .reference("a reference")
          .identity(new IdentityDto().type("number").endpoint("+endpoint"))
          .flashCallOptions(new InitiateVerificationResourceFlashCallOptionsDto().dialTimeout(17));
  public static InitiateVerificationResourceDto startVerificationSeamlessDto =
      new InitiateVerificationResourceDto()
          .method(VerificationMethodDto.SEAMLESS)
          .custom("a custom")
          .reference("a reference")
          .identity(new IdentityDto().type("number").endpoint("+endpoint"));
  public static InitiateVerificationResourceDto startVerificationSMSDto =
      new InitiateVerificationResourceDto()
          .method(VerificationMethodDto.SMS)
          .custom("a custom")
          .reference("a reference")
          .identity(new IdentityDto().type("number").endpoint("+endpoint"))
          .smsOptions(
              new InitiateVerificationResourceSmsOptionsDto()
                  .expiry("01:02:03")
                  .codeType(
                      InitiateVerificationResourceSmsOptionsDto.CodeTypeEnum.ALPHANUMERIC
                          .toString())
                  .template("My template require to use '{{CODE}}' code"));

  @GivenTextResource("/domains/verification/v1/StartVerificationCalloutRequestDto.json")
  String jsonStartVerificationCallout;

  @GivenTextResource("/domains/verification/v1/StartVerificationFlashCallRequestDto.json")
  String jsonStartVerificationFlashCall;

  @GivenTextResource("/domains/verification/v1/StartVerificationSeamlessRequestDto.json")
  String jsonStartVerificationSeamless;

  @GivenTextResource("/domains/verification/v1/StartVerificationSMSRequestDto.json")
  String jsonStartVerificationSMS;

  @Test
  void serializeStartCallout() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationCalloutDto);

    JSONAssert.assertEquals(jsonStartVerificationCallout, serializedString, true);
  }

  @Test
  void serializeStartFlashCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationFlashCallDto);

    JSONAssert.assertEquals(jsonStartVerificationFlashCall, serializedString, true);
  }

  @Test
  void serializeSeamlessCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationSeamlessDto);

    JSONAssert.assertEquals(jsonStartVerificationSeamless, serializedString, true);
  }

  @Test
  void serializeSMSCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationSMSDto);

    JSONAssert.assertEquals(jsonStartVerificationSMS, serializedString, true);
  }
}
