package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseDataImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class StartVerificationResponseTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationPhoneCallResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationPhoneCallDto;

  public static StartVerificationResponseInternalImpl expectedStartVerificationPhoneCallDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponsePhoneCallImpl)
              StartVerificationResponsePhoneCall.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationFlashCallDto;

  public static StartVerificationResponseInternalImpl expectedStartVerificationFlashCallDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponseFlashCallImpl)
              StartVerificationResponseFlashCall.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setCliFilter("(.*)5312(.*)")
                  .setInterceptionTimeout(45)
                  .setReportTimeout(75)
                  .setDenyCallAfter(0)
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationDataResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationDataDto;

  public static StartVerificationResponseInternalImpl expectedStartVerificationDataDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponseDataImpl)
              StartVerificationResponseData.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setTargetUri("target URI")
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSmsResponseDto.json")
  StartVerificationResponseInternal loadedStartVerificationSmsDto;

  public static StartVerificationResponseInternalImpl expectedStartVerificationSmsDto =
      new StartVerificationResponseInternalImpl(
          (StartVerificationResponseSmsImpl)
              StartVerificationResponseSms.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
                  .setInterceptionTimeout(298)
                  .build());

  @Test
  void deserializeStartPhoneCall() {
    TestHelpers.recursiveEquals(
        loadedStartVerificationPhoneCallDto, expectedStartVerificationPhoneCallDto);
  }

  @Test
  void deserializeStartFlashCall() {
    TestHelpers.recursiveEquals(
        loadedStartVerificationFlashCallDto, expectedStartVerificationFlashCallDto);
  }

  @Test
  void deserializeStartData() {
    TestHelpers.recursiveEquals(loadedStartVerificationDataDto, expectedStartVerificationDataDto);
  }

  @Test
  void deserializeStartSms() {
    TestHelpers.recursiveEquals(loadedStartVerificationSmsDto, expectedStartVerificationSmsDto);
  }
}
