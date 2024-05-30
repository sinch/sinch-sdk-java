package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCallContent;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSeamlessContent;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSeamlessImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSmsContent;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseInternalImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class StartVerificationResponseTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationCalloutResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationCalloutDto;

  public static StartVerificationResponseInternal expectedStartVerificationCalloutDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponsePhoneCallImpl)
              StartVerificationResponsePhoneCall.builder()
                  .setId("the id")
                  .setMethod(VerificationMethod.CALLOUT.value())
                  .setLinks(LinkTest.expectedLinks)
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationFlashCallDto;

  public static StartVerificationResponseInternal expectedStartVerificationFlashCallDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponseFlashCallImpl)
              StartVerificationResponseFlashCall.builder()
                  .setId("the id")
                  .setMethod(VerificationMethod.FLASHCALL.value())
                  .setLinks(LinkTest.expectedLinks)
                  .setFlashCall(
                      StartVerificationResponseFlashCallContent.builder()
                          .setCliFilter("(.*)5312(.*)")
                          .setInterceptionTimeout(45)
                          .setReportTimeout(75)
                          .setDenyCallAfter(0)
                          .build())
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSeamlessResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationSeamlessDto;

  public static StartVerificationResponseInternal expectedStartVerificationSeamlessDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponseSeamlessImpl)
              StartVerificationResponseSeamless.builder()
                  .setId("the id")
                  .setMethod(VerificationMethod.SEAMLESS.value())
                  .setLinks(LinkTest.expectedLinks)
                  .setSeamless(
                      StartVerificationResponseSeamlessContent.builder()
                          .setTargetUri("target URI")
                          .build())
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSMSResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationSMSDto;

  public static StartVerificationResponseInternal expectedStartVerificationSMSDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponseSmsImpl)
              StartVerificationResponseSms.builder()
                  .setId("the id")
                  .setMethod(VerificationMethod.SMS.value())
                  .setLinks(LinkTest.expectedLinks)
                  .setSms(
                      StartVerificationResponseSmsContent.builder()
                          .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
                          .setInterceptionTimeout(298)
                          .build())
                  .build());

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
