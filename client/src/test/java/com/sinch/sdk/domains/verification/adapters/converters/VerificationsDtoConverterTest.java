package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportReasonType;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.VerificationReportStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.StartVerificationRequestDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.StartVerificationResponseDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestDtoTest;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificationsDtoConverterTest extends BaseTest {

  public static StartVerificationRequestParameters startVerificationCalloutRequest =
      StartVerificationRequestParameters.builder(VerificationMethodType.CALLOUT)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();

  public static StartVerificationResponseCallout expectedStartVerificationCalloutResponse =
      StartVerificationResponseCallout.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .build();

  public static StartVerificationRequestParameters startVerificationFlashCallRequest =
      StartVerificationFlashCallRequestParameters.builder()
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setDialTimeOut(17)
          .build();
  public static StartVerificationResponseFlashCall expectedStartVerificationFlashCallResponse =
      StartVerificationResponseFlashCall.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .setCliFilter("(.*)5312(.*)")
          .setInterceptionTimeOut(45)
          .setReportTimeout(75)
          .setDenyCallAfter(0)
          .build();
  public static StartVerificationRequestParameters startVerificationSeamlessRequest =
      StartVerificationRequestParameters.builder(VerificationMethodType.SEAMLESS)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationResponseSeamless expectedStartVerificationSeamlessResponse =
      StartVerificationResponseSeamless.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTargetUri("target URI")
          .build();
  public static StartVerificationRequestParameters startVerificationSMSRequest =
      StartVerificationRequestParameters.builder(VerificationMethodType.SMS)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationResponseSMS expectedStartVerificationSMSResponse =
      StartVerificationResponseSMS.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
          .setInterceptionTimeOut(298)
          .build();

  @Test
  void convertStartCalloutRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationCalloutRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationCalloutDto);
  }

  @Test
  void convertStartFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationFlashCallDto);
  }

  @Test
  void convertStartSeamlessRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSeamlessRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationSeamlessDto);
  }

  @Test
  void convertStartSMSRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSMSRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationSMSDto);
  }

  @Test
  void convertStartCalloutResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseDtoTest.expectedStartVerificationCalloutDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationCalloutResponse);
  }

  @Test
  void convertStartFlashCallResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseDtoTest.expectedStartVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationFlashCallResponse);
  }

  @Test
  void convertStartSeamlessResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseDtoTest.expectedStartVerificationSeamlessDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSeamlessResponse);
  }

  @Test
  void convertStartSMSResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseDtoTest.expectedStartVerificationSMSDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSMSResponse);
  }

  public static VerificationReportCalloutRequestParameters verificationReportCalloutRequest =
      VerificationReportCalloutRequestParameters.builder().setCode("foo code").build();

  public static VerificationReportCallout expectedVerificationReportCalloutResponse =
      VerificationReportCallout.builder()
          .setId("the id")
          .setStatus(VerificationReportStatusType.FAIL)
          .setReason(VerificationReportReasonType.FRAUD)
          .setCallComplete(true)
          .setReference("my reference")
          .setVerificationPrice(
              Price.builder()
                  .setCurrencyId("verificationPrice currency id")
                  .setAmount(3.141516F)
                  .build())
          .setTerminationPrice(
              Price.builder()
                  .setCurrencyId("terminationPrice currency id")
                  .setAmount(6.626070F)
                  .build())
          .setBillableDuration(34)
          .build();

  @Test
  void convertReportCalloutRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportCalloutRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportCalloutDto);
  }

  @Test
  void convertReportCalloutResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                VerificationReportDtoTest.expectedVerificationCalloutDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportCalloutResponse);
  }

  public static VerificationReportFlashCallRequestParameters verificationReportFlashCallRequest =
      VerificationReportFlashCallRequestParameters.builder().setCli("foo cli").build();

  public static VerificationReportFlashCall expectedVerificationReportFlashCallResponse =
      VerificationReportFlashCall.builder()
          .setId("the id")
          .setStatus(VerificationReportStatusType.FAIL)
          .setReason(VerificationReportReasonType.FRAUD)
          .setReference("my reference")
          .setSource("my source")
          .build();

  @Test
  void convertReportFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportFlashCallDto);
  }

  @Test
  void convertReportFlashCallResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                VerificationReportDtoTest.expectedVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportFlashCallResponse);
  }

  public static VerificationReportSMSRequestParameters verificationReportSMSRequest =
      VerificationReportSMSRequestParameters.builder()
          .setCode("foo code")
          .setCli("foo cli")
          .build();

  public static VerificationReportSMS expectedVerificationReportSMSResponse =
      VerificationReportSMS.builder()
          .setId("the id")
          .setStatus(VerificationReportStatusType.FAIL)
          .setReason(VerificationReportReasonType.FRAUD)
          .setReference("my reference")
          .setSource("my source")
          .setVerificationPrice(
              Price.builder()
                  .setCurrencyId("verificationPrice currency id")
                  .setAmount(3.141516F)
                  .build())
          .build();

  @Test
  void convertReportSMSRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportSMSRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportSMSDto);
  }

  @Test
  void convertReportSMSResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(VerificationReportDtoTest.expectedVerificationSMSDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportSMSResponse);
  }
}
