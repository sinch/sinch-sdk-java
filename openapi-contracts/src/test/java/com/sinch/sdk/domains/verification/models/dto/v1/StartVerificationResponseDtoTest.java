package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class StartVerificationResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/StartVerificationCalloutResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationCalloutDto;

  public static InitiateVerificationResponseDto expectedStartVerificationCalloutDto =
      new InitiateVerificationResponseDto(
          new CalloutInitiateVerificationResponseDto()
              .id("the id")
              .method(VerificationMethodDto.CALLOUT.getValue())
              .links(LinksDtoTest.expectedLinks));

  @GivenJsonResource("/domains/verification/v1/StartVerificationFlashCallResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationFlashCallDto;

  public static InitiateVerificationResponseDto expectedStartVerificationFlashCallDto =
      new InitiateVerificationResponseDto(
          new FlashCallInitiateVerificationResponseDto()
              .id("the id")
              .method(VerificationMethodDto.FLASHCALL.getValue())
              .links(LinksDtoTest.expectedLinks)
              .flashCall(
                  new FlashCallInitiateVerificationResponseFlashCallDto()
                      .cliFilter("(.*)5312(.*)")
                      .interceptionTimeout(45)
                      .reportTimeout(75)
                      .denyCallAfter(0)));

  @GivenJsonResource("/domains/verification/v1/StartVerificationSeamlessResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationSeamlessDto;

  public static InitiateVerificationResponseDto expectedStartVerificationSeamlessDto =
      new InitiateVerificationResponseDto(
          new DataInitiateVerificationResponseDto()
              .id("the id")
              .method(VerificationMethodDto.SEAMLESS.getValue())
              .links(LinksDtoTest.expectedLinks)
              .seamless(new DataInitiateVerificationResponseSeamlessDto().targetUri("target URI")));

  @GivenJsonResource("/domains/verification/v1/StartVerificationSMSResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationSMSDto;

  public static InitiateVerificationResponseDto expectedStartVerificationSMSDto =
      new InitiateVerificationResponseDto(
          new SMSInitiateVerificationResponseDto()
              .id("the id")
              .method(VerificationMethodDto.SMS.getValue())
              .links(LinksDtoTest.expectedLinks)
              .sms(
                  new SMSInitiateVerificationResponseSmsDto()
                      .template("Your verification code is {{CODE}}. Verified by Sinch")
                      .interceptionTimeout(String.valueOf(298))));

  @Test
  void deserializeStartCallout() {
    Assertions.assertThat(loadedStartVerificationCalloutDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationCalloutDto);
  }

  @Test
  void deserializeStartFlashCall() {
    Assertions.assertThat(loadedStartVerificationFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationFlashCallDto);
  }

  @Test
  void deserializeStartSeamless() {
    Assertions.assertThat(loadedStartVerificationSeamlessDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSeamlessDto);
  }

  @Test
  void deserializeSMS() {
    Assertions.assertThat(loadedStartVerificationSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSMSDto);
  }
}
