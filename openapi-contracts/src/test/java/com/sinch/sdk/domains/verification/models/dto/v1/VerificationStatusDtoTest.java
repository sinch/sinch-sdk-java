package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationStatusDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/VerificationStatusCalloutResponseDto.json")
  VerificationResponseDto loadedVerificationCalloutDto;

  public static VerificationResponseDto expectedVerificationCalloutDto =
      new VerificationResponseDto(
          new CalloutVerificationStatusResponseDto()
              .id("the id")
              .method(VerificationMethodDto.CALLOUT.getValue())
              .status(VerificationStatusDto.FAIL)
              .reason(VerificationStatusReasonDto.FRAUD)
              .callComplete(true)
              .reference("my reference")
              .price(
                  new FlashcallVerificationStatusResponseAllOfPriceDto()
                      .verificationPrice(
                          new PriceDto()
                              .currencyId("verificationPrice currency id")
                              .amount(3.141516F))
                      .terminationPrice(
                          new PriceDto()
                              .currencyId("terminationPrice currency id")
                              .amount(6.626070F))
                      .billableDuration(34)));

  @GivenJsonResource("/domains/verification/v1/VerificationStatusFlashCallResponseDto.json")
  VerificationResponseDto loadedVerificationFlashCallDto;

  public static VerificationResponseDto expectedVerificationFlashCallDto =
      new VerificationResponseDto(
          new FlashcallVerificationStatusResponseDto()
              .id("the id")
              .method(VerificationMethodDto.FLASHCALL.getValue())
              .status(VerificationStatusDto.FAIL)
              .reason(VerificationStatusReasonDto.FRAUD)
              .reference("my reference")
              .source("manual"));

  @GivenJsonResource("/domains/verification/v1/VerificationStatusSMSResponseDto.json")
  VerificationResponseDto loadedVerificationSMSDto;

  public static VerificationResponseDto expectedVerificationSMSDto =
      new VerificationResponseDto(
          new SMSVerificationStatusResponseDto()
              .id("the id")
              .method(VerificationMethodDto.SMS.getValue())
              .status(VerificationStatusDto.FAIL)
              .reason(VerificationStatusReasonDto.FRAUD)
              .reference("my reference")
              .source("intercepted")
              .price(
                  new SMSVerificationStatusResponseAllOfPriceDto()
                      .verificationPrice(
                          new PriceDto()
                              .currencyId("verificationPrice currency id")
                              .amount(3.141516F))));

  @Test
  void deserializeCallout() {
    Assertions.assertThat(loadedVerificationCalloutDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationCalloutDto);
  }

  @Test
  void deserializeFlashCall() {
    Assertions.assertThat(loadedVerificationFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationFlashCallDto);
  }

  @Test
  void deserializeSMS() {
    Assertions.assertThat(loadedVerificationSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationSMSDto);
  }
}
