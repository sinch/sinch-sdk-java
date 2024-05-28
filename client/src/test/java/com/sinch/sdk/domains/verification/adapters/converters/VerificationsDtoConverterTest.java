package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportRequestDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationRequestTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationResponseTest;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseInternalTest;
import com.sinch.sdk.domains.verification.models.requests.SMSCodeType;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutSpeechOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import java.time.Instant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificationsDtoConverterTest extends BaseTest {

  public static StartVerificationCalloutRequestParameters startVerificationCalloutRequest =
      StartVerificationCalloutRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setOptions(
              StartVerificationCalloutOptions.builder()
                  .setSpeech(
                      StartVerificationCalloutSpeechOptions.builder().setLocale("fr-FR").build())
                  .build())
          .build();

  public static StartVerificationResponseCallout expectedStartVerificationCalloutResponse =
      StartVerificationResponseCallout.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .build();

  public static StartVerificationFlashCallRequestParameters startVerificationFlashCallRequest =
      StartVerificationFlashCallRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setDialTimeOut(17)
          .build();
  public static StartVerificationResponseFlashCall expectedStartVerificationFlashCallResponse =
      StartVerificationResponseFlashCall.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .setCliFilter("(.*)5312(.*)")
          .setInterceptionTimeOut(45)
          .setReportTimeout(75)
          .setDenyCallAfter(0)
          .build();
  public static StartVerificationSeamlessRequestParameters startVerificationSeamlessRequest =
      StartVerificationSeamlessRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationResponseSeamless expectedStartVerificationSeamlessResponse =
      StartVerificationResponseSeamless.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTargetUri("target URI")
          .build();
  public static StartVerificationSMSRequestParameters startVerificationSMSRequest =
      StartVerificationSMSRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setOptions(
              StartVerificationSMSOptions.builder()
                  .setExpiry("01:02:03")
                  .setCodeType(SMSCodeType.ALPHANUMERIC)
                  .setTemplate("My template require to use '{{CODE}}' code")
                  .build())
          .build();
  public static StartVerificationResponseSMS expectedStartVerificationSMSResponse =
      StartVerificationResponseSMS.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
          .setInterceptionTimeOut(298)
          .build();

  @Test
  void convertStartCalloutRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationCalloutRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationCalloutDto);
  }

  @Test
  void convertStartFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationFlashCallDto);
  }

  @Test
  void convertStartSeamlessRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSeamlessRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationSeamlessDto);
  }

  @Test
  void convertStartSMSRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSMSRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationSMSDto);
  }

  @Test
  void convertStartCalloutResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationCalloutDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationCalloutResponse);
  }

  @Test
  void convertStartFlashCallResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationFlashCallResponse);
  }

  @Test
  void convertStartSeamlessResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationSeamlessDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSeamlessResponse);
  }

  @Test
  void convertStartSMSResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationSMSDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSMSResponse);
  }

  public static VerificationReportCalloutRequestParameters verificationReportCalloutRequest =
      VerificationReportCalloutRequestParameters.builder().setCode("foo code").build();

  public static VerificationStatusCallout expectedVerificationReportCalloutResponse =
      VerificationStatusCallout.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .setReason(VerificationStatusReasonType.FRAUD)
          .setIdentity(NumberIdentity.valueOf("endpoint value"))
          .setCountryId("es-ES")
          .setVerificationTimeStamp(Instant.parse("2024-05-22T09:38:59.559043700Z"))
          .setCallComplete(true)
          .setReference(VerificationReference.valueOf("my reference"))
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
            StatusDtoConverter.convert(
                VerificationStatusResponseInternalTest.expectedVerificationCalloutDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportCalloutResponse);
  }

  public static VerificationReportFlashCallRequestParameters verificationReportFlashCallRequest =
      VerificationReportFlashCallRequestParameters.builder().setCli("foo cli").build();

  public static VerificationStatusFlashCall expectedVerificationReportFlashCallResponse =
      VerificationStatusFlashCall.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .setReason(VerificationStatusReasonType.FRAUD)
          .setIdentity(NumberIdentity.valueOf("endpoint value"))
          .setCountryId("es-ES")
          .setVerificationTimeStamp(Instant.parse("2024-05-22T09:38:59.559043700Z"))
          .setReference(VerificationReference.valueOf("my reference"))
          .setSource(VerificationSourceType.MANUAL)
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
  void convertReportFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportFlashCallDto);
  }

  @Test
  void convertReportFlashCallResponse() {

    Assertions.assertThat(
            StatusDtoConverter.convert(
                VerificationStatusResponseInternalTest.expectedVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportFlashCallResponse);
  }

  public static VerificationReportSMSRequestParameters verificationReportSMSRequest =
      VerificationReportSMSRequestParameters.builder()
          .setCode("foo code")
          .setCli("foo cli")
          .build();

  public static VerificationStatusSMS expectedVerificationStatusSMSResponse =
      VerificationStatusSMS.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .setReason(VerificationStatusReasonType.FRAUD)
          .setReference(VerificationReference.valueOf("my reference"))
          .setIdentity(NumberIdentity.valueOf("endpoint value"))
          .setCountryId("es-ES")
          .setVerificationTimeStamp(Instant.parse("2024-05-22T09:38:59.559043700Z"))
          .setSource(VerificationSourceType.INTERCEPTED)
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
            StatusDtoConverter.convert(
                VerificationStatusResponseInternalTest.expectedVerificationSMSDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationStatusSMSResponse);
  }
}
