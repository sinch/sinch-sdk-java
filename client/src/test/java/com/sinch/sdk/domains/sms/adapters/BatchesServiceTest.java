package com.sinch.sdk.domains.sms.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.adapters.api.v1.BatchesApi;
import com.sinch.sdk.domains.sms.adapters.converters.BatchDtoConverter;
import com.sinch.sdk.domains.sms.adapters.converters.DryRunDtoConverterTest;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.BatchBinary;
import com.sinch.sdk.domains.sms.models.BatchMedia;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.DeliveryReport;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.MediaBody;
import com.sinch.sdk.domains.sms.models.Parameters;
import com.sinch.sdk.domains.sms.models.dto.v1.DryRun200ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjParameterKeyDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchBinaryRequest;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchMediaRequest;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import com.sinch.sdk.models.Configuration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
public class BatchesServiceTest extends BaseTest {

  static final String id = "01FC66621XXXXX119Z8PMV1QPQ";
  static final Collection<String> to = Arrays.asList("+15551231234", "+15551256344");
  static final String from = "+15551231234";
  static final boolean canceled = false;
  static final Instant createdAt = Instant.parse("2019-08-24T14:15:22Z");
  static final Instant modifiedAt = Instant.parse("2019-08-24T14:17:22Z");
  static final DeliveryReport deliveryReport = DeliveryReport.NONE;
  static final Instant sendAt = Instant.parse("2019-08-24T14:19:22Z");
  static final Instant expireAt = Instant.parse("2019-08-24T14:21:22Z");
  static final String callbackUrl = "callback url";
  static final String clientReference = "myReference";
  static final boolean flashMessage = true;
  static final boolean feedbackEnabled = false;
  static final boolean truncateConcat = true;
  static final int maxNumberOfMessageParts = 1;
  static final int fromTon = 6;
  static final int fromNpi = 18;
  static final String udh = "foo udh";
  static final String body = "Hi ${name}! How are you?";
  public static final BatchBinary batchBinary =
      BatchBinary.builder()
          .setId(id)
          .setTo(to)
          .setFrom(from)
          .setCanceled(canceled)
          .setBody(body)
          .setCreatedAt(createdAt)
          .setModifiedAt(modifiedAt)
          .setDeliveryReport(deliveryReport)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setClientReference(clientReference)
          .setFlashMessage(flashMessage)
          .setFeedbackEnabled(feedbackEnabled)
          .setTruncateConcat(truncateConcat)
          .setMaxNumberOfMessageParts(maxNumberOfMessageParts)
          .setFromTon(fromTon)
          .setFromNpi(fromNpi)
          .setUdh(udh)
          .build();
  static final Parameters parameters =
      new Parameters(
          Arrays.asList(
              new Parameters.Entry("an identifier", new Pair<>("a key", "a value")),
              new Parameters.Entry(
                  ParameterObjDto
                      .JSON_PROPERTY_LEFT_CURLY_BRACKET_PARAMETER_KEY_RIGHT_CURLY_BRACKET,
                  new Pair<>(
                      ParameterObjParameterKeyDto
                          .JSON_PROPERTY_LEFT_CURLY_BRACKET_MSISDN_RIGHT_CURLY_BRACKET,
                      "msisdn value"),
                  "default value")));
  public final BatchMedia batchMedia =
      BatchMedia.builder()
          .setId(id)
          .setTo(to)
          .setFrom(from)
          .setCanceled(canceled)
          .setBody(
              new MediaBody(
                  "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png",
                  "Media message from Sinch!"))
          .setCreatedAt(Instant.parse("2019-08-24T14:14:22Z"))
          .setModifiedAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setDeliveryReport(DeliveryReport.SUMMARY)
          .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
          .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setCallbackUrl(callbackUrl)
          .setClientReference("client reference")
          .setFeedbackEnabled(feedbackEnabled)
          .setParameters(parameters)
          .build();
  public final BatchText batchText =
      BatchText.builder()
          .setId(id)
          .setTo(to)
          .setFrom(from)
          .setCanceled(canceled)
          .setBody(body)
          .setCreatedAt(createdAt)
          .setModifiedAt(modifiedAt)
          .setDeliveryReport(deliveryReport)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setClientReference(clientReference)
          .setFlashMessage(flashMessage)
          .setFeedbackEnabled(feedbackEnabled)
          .setTruncateConcat(truncateConcat)
          .setMaxNumberOfMessageParts(maxNumberOfMessageParts)
          .setFromTon(fromTon)
          .setFromNpi(fromNpi)
          .setParameters(parameters)
          .build();

  public static final SendSmsBatchBinaryRequest sendSmsBatchBinaryRequest =
      SendSmsBatchBinaryRequest.builder()
          .setTo(to)
          .setFrom(from)
          .setBody(body)
          .setDeliveryReport(deliveryReport)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setClientReference(clientReference)
          .setFlashMessage(flashMessage)
          .setFeedbackEnabled(feedbackEnabled)
          .setTruncateConcat(truncateConcat)
          .setMaxNumberOfMessageParts(maxNumberOfMessageParts)
          .setFromTon(fromTon)
          .setFromNpi(fromNpi)
          .setUdh(udh)
          .build();

  public static final SendSmsBatchMediaRequest sendSmsBatchMediaRequest =
      SendSmsBatchMediaRequest.builder()
          .setTo(to)
          .setFrom(from)
          .setBody(
              new MediaBody(
                  "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png",
                  "Media message from Sinch!"))
          .setDeliveryReport(DeliveryReport.SUMMARY)
          .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
          .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setCallbackUrl(callbackUrl)
          .setClientReference("client reference")
          .setFeedbackEnabled(feedbackEnabled)
          .setStrictValidation(true)
          .setParameters(parameters)
          .build();
  public static final SendSmsBatchTextRequest sendSmsBatchTextRequest =
      SendSmsBatchTextRequest.builder()
          .setTo(to)
          .setFrom(from)
          .setBody(body)
          .setDeliveryReport(deliveryReport)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setClientReference(clientReference)
          .setFlashMessage(flashMessage)
          .setFeedbackEnabled(feedbackEnabled)
          .setTruncateConcat(truncateConcat)
          .setMaxNumberOfMessageParts(maxNumberOfMessageParts)
          .setFromTon(fromTon)
          .setFromNpi(fromNpi)
          .setParameters(parameters)
          .build();

  @GivenJsonResource("/domains/sms/v1/BinaryResponseDto.json")
  public SendSMS201ResponseDto binaryResponseDto;

  @GivenJsonResource("/domains/sms/v1/MediaResponseDto.json")
  SendSMS201ResponseDto mediaResponseDto;

  @GivenJsonResource("/domains/sms/v1/TextResponseDto.json")
  SendSMS201ResponseDto textResponseDto;

  @GivenJsonResource("/domains/sms/v1/DryRunResponseDto.json")
  DryRun200ResponseDto dryRunResponseDto;

  @Mock Configuration configuration;
  @Mock BatchesApi api;
  @InjectMocks BatchesService service;

  @Test
  void getBinary() throws ApiException {

    when(api.getBatchMessage(eq(configuration.getProjectId()), eq("foo binary batch id")))
        .thenReturn(binaryResponseDto);

    Batch<?> response = service.get("foo binary batch id");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(batchBinary);
  }

  @Test
  void getMedia() throws ApiException {

    when(api.getBatchMessage(eq(configuration.getProjectId()), eq("foo media batch id")))
        .thenReturn(mediaResponseDto);

    Batch<?> response = service.get("foo media batch id");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(batchMedia);
  }

  @Test
  void getText() throws ApiException {

    when(api.getBatchMessage(eq(configuration.getProjectId()), eq("foo text batch id")))
        .thenReturn(textResponseDto);

    Batch<?> response = service.get("foo text batch id");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(batchText);
  }

  @Test
  void sendBinary() throws ApiException {

    when(api.sendSMS(
            eq(configuration.getProjectId()),
            eq(BatchDtoConverter.convert(sendSmsBatchBinaryRequest))))
        .thenReturn(binaryResponseDto);

    Batch<?> response = service.send(sendSmsBatchBinaryRequest);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(batchBinary);
  }

  @Test
  void sendMedia() throws ApiException {

    when(api.sendSMS(
            eq(configuration.getProjectId()),
            eq(BatchDtoConverter.convert(sendSmsBatchMediaRequest))))
        .thenReturn(mediaResponseDto);

    Batch<?> response = service.send(sendSmsBatchMediaRequest);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(batchMedia);
  }

  @Test
  void sendText() throws ApiException {

    when(api.sendSMS(
            eq(configuration.getProjectId()),
            eq(BatchDtoConverter.convert(sendSmsBatchTextRequest))))
        .thenReturn(textResponseDto);

    Batch<?> response = service.send(sendSmsBatchTextRequest);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(batchText);
  }

  @Test
  void dryRun() throws ApiException {

    when(api.dryRun(
            eq(configuration.getProjectId()),
            eq(true),
            eq(456),
            eq(BatchDtoConverter.convert(sendSmsBatchTextRequest))))
        .thenReturn(dryRunResponseDto);

    DryRun response = service.dryRun(true, 456, sendSmsBatchTextRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DryRunDtoConverterTest.dryRunClient);
  }
}
