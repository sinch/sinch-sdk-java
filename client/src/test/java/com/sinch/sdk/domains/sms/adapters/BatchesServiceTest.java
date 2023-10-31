package com.sinch.sdk.domains.sms.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.adapters.api.v1.BatchesApi;
import com.sinch.sdk.domains.sms.models.*;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjParameterKeyDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
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

  final String id = "01FC66621XXXXX119Z8PMV1QPQ";
  final Collection<String> to = Arrays.asList("+15551231234", "+15551256344");
  final String from = "+15551231234";
  final boolean canceled = false;
  final Instant createdAt = Instant.parse("2019-08-24T14:15:22Z");
  final Instant modifiedAt = Instant.parse("2019-08-24T14:17:22Z");
  final DeliveryReport deliveryReport = DeliveryReport.NONE;
  final Instant sendAt = Instant.parse("2019-08-24T14:19:22Z");
  final Instant expireAt = Instant.parse("2019-08-24T14:21:22Z");
  final String callbackUrl = "callback url";
  final String clientReference = "myReference";
  final boolean flashMessage = true;
  final boolean feedbackEnabled = false;
  final boolean truncateConcat = true;
  final int maxNumberOfMessageParts = 1;
  final int fromTon = 6;
  final int fromNpi = 18;
  final String udh = "foo udh";
  final String body = "Hi ${name}! How are you?";
  public final BatchBinary batchBinary =
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
  final Parameters parameters =
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

  @GivenJsonResource("/domains/sms/v1/BinaryResponseDto.json")
  public SendSMS201ResponseDto binaryResponseDto;

  @GivenJsonResource("/domains/sms/v1/MediaResponseDto.json")
  SendSMS201ResponseDto mediaResponseDto;

  @GivenJsonResource("/domains/sms/v1/TextResponseDto.json")
  SendSMS201ResponseDto textResponseDto;

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
}
