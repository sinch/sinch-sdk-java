package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.api.v1.internal.BatchesApi;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.MediaBody;
import com.sinch.sdk.domains.sms.models.v1.batches.MediaBodyDtoTest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BinaryRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.MediaRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateBinaryRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateMediaRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateTextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BinaryResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.MediaResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.TextResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.ApiBatchList;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class BatchesServiceTest extends BaseTest {

  static final String id = "01FC66621XXXXX119Z8PMV1QPQ";
  static final List<String> to = Arrays.asList("+15551231234", "+15551256344");
  static final String from = "+15551231234";
  static final boolean canceled = false;
  static final Instant createdAt = Instant.parse("2019-08-24T14:15:22Z");
  static final Instant modifiedAt = Instant.parse("2019-08-24T14:17:22Z");
  static final DeliveryReportType deliveryReport = DeliveryReportType.NONE;
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
  static final String body = "Hi ${name} ({an identifier}) ! How are you?";
  public static final BinaryResponse batchBinary =
      BinaryResponse.builder()
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
          .setFeedbackEnabled(feedbackEnabled)
          .setFromTon(fromTon)
          .setFromNpi(fromNpi)
          .setUdh(udh)
          .build();

  static final Map<String, String> anIdentifierParameters =
      Stream.of(
              new AbstractMap.SimpleEntry<>("15551231234", "an identifier value for 15551231234"),
              new AbstractMap.SimpleEntry<>("15551256344", "an identifier value for 15551256344"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  static final Map<String, String> nameParameters =
      Stream.of(
              new AbstractMap.SimpleEntry<>("15551231234", "name value for 15551231234"),
              new AbstractMap.SimpleEntry<>("15551256344", "name value for 15551256344"),
              new AbstractMap.SimpleEntry<>("default", "default value"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  static final Map<String, Map<String, String>> parameters =
      Stream.of(
              new AbstractMap.SimpleEntry<>("name", nameParameters),
              new AbstractMap.SimpleEntry<>("an identifier", anIdentifierParameters))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  public static final MediaResponse batchMedia =
      MediaResponse.builder()
          .setId(id)
          .setTo(to)
          .setFrom(from)
          .setCanceled(canceled)
          .setBody(
              MediaBody.builder()
                  .setSubject("subject field")
                  .setUrl(
                      "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                  .setMessage("Hi ${name} ({an identifier}) ! How are you?")
                  .build())
          .setCreatedAt(Instant.parse("2019-08-24T14:14:22Z"))
          .setModifiedAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setDeliveryReport(DeliveryReportType.SUMMARY)
          .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
          .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setCallbackUrl(callbackUrl)
          .setClientReference("client reference")
          .setFeedbackEnabled(feedbackEnabled)
          .setStrictValidation(true)
          .setParameters(parameters)
          .build();
  public static final TextResponse batchText =
      TextResponse.builder()
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

  public static final BinaryRequest sendSmsBatchBinaryRequest =
      BinaryRequest.builder()
          .setTo(to)
          .setFrom(from)
          .setBody(body)
          .setDeliveryReport(deliveryReport)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setClientReference(clientReference)
          .setFeedbackEnabled(feedbackEnabled)
          .setFromTon(fromTon)
          .setFromNpi(fromNpi)
          .setUdh(udh)
          .build();

  public static final MediaRequest sendSmsBatchMediaRequest =
      MediaRequest.builder()
          .setTo(to)
          .setFrom(from)
          .setBody(
              MediaBody.builder()
                  .setUrl(
                      "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                  .setMessage("Hi ${name} ({an identifier}) ! How are you?")
                  .build())
          .setDeliveryReport(DeliveryReportType.SUMMARY)
          .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
          .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setCallbackUrl(callbackUrl)
          .setClientReference("client reference")
          .setFeedbackEnabled(feedbackEnabled)
          .setStrictValidation(true)
          .setParameters(parameters)
          .build();
  public static final TextRequest sendSmsBatchTextRequest =
      TextRequest.builder()
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

  public static final UpdateTextRequest updateSmsBatchTextRequest =
      UpdateTextRequest.builder()
          .setToAdd(to)
          .setFrom(from)
          .setBody(body)
          .setDeliveryReport(deliveryReport)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setParameters(parameters)
          .build();

  public static final UpdateMediaRequest updateSmsBatchMediaRequest =
      UpdateMediaRequest.builder()
          .setToRemove(to)
          .setFrom(from)
          .setBody(MediaBodyDtoTest.mediaBodyDto)
          .setDeliveryReport(DeliveryReportType.SUMMARY)
          .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
          .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setCallbackUrl(callbackUrl)
          .setStrictValidation(true)
          .setParameters(parameters)
          .build();

  public static final UpdateBinaryRequest updateSmsBatchBinaryRequest =
      UpdateBinaryRequest.builder()
          .setToAdd(Arrays.asList("+15551231234", "+15987365412"))
          .setToRemove(Arrays.asList("+0123456789", "+9876543210"))
          .setFrom(from)
          .setBody(body)
          .setDeliveryReport(DeliveryReportType.FULL)
          .setSendAt(sendAt)
          .setExpireAt(expireAt)
          .setCallbackUrl(callbackUrl)
          .setUdh(udh)
          .build();

  @GivenJsonResource("/domains/sms/v1/batches/response/BinaryResponseDto.json")
  public BatchResponse binaryResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/MediaResponseDto.json")
  BatchResponse mediaResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/TextResponseDto.json")
  BatchResponse textResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/DryRunResponseDto.json")
  DryRunResponse dryRunResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage0.json")
  ApiBatchList listBatchesResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage1.json")
  ApiBatchList listBatchesResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage2.json")
  ApiBatchList listBatchesResponseDtoPage2;

  @Mock SmsContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock BatchesApi api;
  BatchesService service;
  String uriPartID = "foovalue";

  @Captor ArgumentCaptor<SendDeliveryFeedbackRequest> recipientsCaptor;

  @BeforeEach
  public void initMocks() {
    service = spy(new BatchesService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getBinary() throws ApiException {

    when(api.get(eq("foo binary batch id"))).thenReturn(binaryResponseDto);

    BatchResponse response = service.get("foo binary batch id");

    TestHelpers.recursiveEquals(response, batchBinary);
  }

  @Test
  void getMedia() throws ApiException {

    when(api.get(eq("foo media batch id"))).thenReturn(mediaResponseDto);

    BatchResponse response = service.get("foo media batch id");

    TestHelpers.recursiveEquals(response, batchMedia);
  }

  @Test
  void getText() throws ApiException {

    when(api.get(eq("foo text batch id"))).thenReturn(textResponseDto);

    BatchResponse response = service.get("foo text batch id");

    TestHelpers.recursiveEquals(response, batchText);
  }

  @Test
  void sendBinary() throws ApiException {

    when(api.send(sendSmsBatchBinaryRequest)).thenReturn(binaryResponseDto);

    BatchResponse response = service.send(sendSmsBatchBinaryRequest);

    TestHelpers.recursiveEquals(response, batchBinary);
  }

  @Test
  void sendMedia() throws ApiException {

    when(api.send(sendSmsBatchMediaRequest)).thenReturn(mediaResponseDto);

    BatchResponse response = service.send(sendSmsBatchMediaRequest);

    TestHelpers.recursiveEquals(response, batchMedia);
  }

  @Test
  void sendText() throws ApiException {

    when(api.send(sendSmsBatchTextRequest)).thenReturn(textResponseDto);

    BatchResponse response = service.send(sendSmsBatchTextRequest);

    TestHelpers.recursiveEquals(response, batchText);
  }

  @Test
  void dryRun() throws ApiException {

    when(api.dryRun(eq(true), eq(456), eq(sendSmsBatchTextRequest))).thenReturn(dryRunResponseDto);

    DryRunResponse response = service.dryRun(true, 456, sendSmsBatchTextRequest);

    TestHelpers.recursiveEquals(response, dryRunResponseDto);
  }

  @Test
  void list() throws ApiException {

    when(api.list(eq(null), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(listBatchesResponseDtoPage0);
    when(api.list(eq(1), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(listBatchesResponseDtoPage1);
    when(api.list(eq(2), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(listBatchesResponseDtoPage2);
    ListBatchesResponse response = service.list(null);

    Iterator<BatchResponse> iterator = response.iterator();
    BatchResponse batch = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TestHelpers.recursiveEquals(
        batch,
        BinaryResponse.builder()
            .setId("01HEAWCHESCXG8SDG5R10VF8E1")
            .setTo(Collections.singletonList("339876543213"))
            .setFrom("33123456789")
            .setCanceled(false)
            .setBody("the body")
            .setCreatedAt(Instant.parse("2023-11-03T15:21:21.113Z"))
            .setModifiedAt(Instant.parse("2023-11-03T15:21:21.568Z"))
            .setDeliveryReport(DeliveryReportType.NONE)
            .setExpireAt(Instant.parse("2023-11-06T15:21:21.973Z"))
            .setClientReference("a client reference")
            .setFeedbackEnabled(false)
            .build());

    batch = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TestHelpers.recursiveEquals(
        batch,
        TextResponse.builder()
            .setId("01HEAC0AG69SVYYQ675VPYT28Q")
            .setTo(Collections.singletonList("3300000000"))
            .setCanceled(false)
            .setBody("the body")
            .setCreatedAt(Instant.parse("2023-11-03T10:35:03.558Z"))
            .setModifiedAt(Instant.parse("2023-11-03T10:35:03.666Z"))
            .setDeliveryReport(DeliveryReportType.NONE)
            .setExpireAt(Instant.parse("2023-11-03T10:35:03.558Z"))
            .setFeedbackEnabled(true)
            .setFlashMessage(false)
            .build());

    batch = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
    TestHelpers.recursiveEquals(
        batch,
        MediaResponse.builder()
            .setId("01HEABZ9S80D4ENE3X6CPMATZR")
            .setTo(Collections.singletonList("331111111"))
            .setCanceled(false)
            .setBody(MediaBody.builder().setUrl("an URL").build())
            .setCreatedAt(Instant.parse("2023-11-03T10:34:30.056Z"))
            .setModifiedAt(Instant.parse("2023-11-03T10:34:30.156Z"))
            .setDeliveryReport(DeliveryReportType.SUMMARY)
            .setExpireAt(Instant.parse("2023-11-06T10:34:30.256Z"))
            .setFeedbackEnabled(false)
            .build());
  }

  @Test
  void updateText() throws ApiException {

    when(api.update(eq("foo text batch id"), eq(updateSmsBatchTextRequest)))
        .thenReturn(textResponseDto);

    BatchResponse response = service.update("foo text batch id", updateSmsBatchTextRequest);

    TestHelpers.recursiveEquals(response, batchText);
  }

  @Test
  void updateMedia() throws ApiException {

    when(api.update(eq("foo text batch id"), eq(updateSmsBatchMediaRequest)))
        .thenReturn(mediaResponseDto);

    BatchResponse response = service.update("foo text batch id", updateSmsBatchMediaRequest);

    TestHelpers.recursiveEquals(response, batchMedia);
  }

  @Test
  void updateBinary() throws ApiException {

    when(api.update(eq("foo text batch id"), eq(updateSmsBatchBinaryRequest)))
        .thenReturn(binaryResponseDto);

    BatchResponse response = service.update("foo text batch id", updateSmsBatchBinaryRequest);

    TestHelpers.recursiveEquals(response, batchBinary);
  }

  @Test
  void replaceBinary() throws ApiException {

    when(api.replace(eq("foo text batch id"), eq(sendSmsBatchBinaryRequest)))
        .thenReturn(binaryResponseDto);

    BatchResponse response = service.replace("foo text batch id", sendSmsBatchBinaryRequest);

    TestHelpers.recursiveEquals(response, batchBinary);
  }

  @Test
  void replaceMedia() throws ApiException {

    when(api.replace(eq("foo text batch id"), eq(sendSmsBatchMediaRequest)))
        .thenReturn(mediaResponseDto);

    BatchResponse response = service.replace("foo text batch id", sendSmsBatchMediaRequest);

    TestHelpers.recursiveEquals(response, batchMedia);
  }

  @Test
  void replaceText() throws ApiException {

    when(api.replace(eq("foo text batch id"), eq(sendSmsBatchTextRequest)))
        .thenReturn(textResponseDto);

    BatchResponse response = service.replace("foo text batch id", sendSmsBatchTextRequest);

    TestHelpers.recursiveEquals(response, batchText);
  }

  @Test
  void cancelBatch() throws ApiException {

    when(api.cancel(eq("foo text batch id"))).thenReturn(textResponseDto);

    BatchResponse response = service.cancel("foo text batch id");

    TestHelpers.recursiveEquals(response, batchText);
  }

  @Test
  void sendDeliveryFeedback() throws ApiException {
    SendDeliveryFeedbackRequest request =
        SendDeliveryFeedbackRequest.builder().setRecipients(Arrays.asList("foo", "foo2")).build();

    service.sendDeliveryFeedback("foo text batch id", request);

    verify(api).sendDeliveryFeedback(eq("foo text batch id"), recipientsCaptor.capture());

    SendDeliveryFeedbackRequest dto = recipientsCaptor.getValue();
    TestHelpers.recursiveEquals(dto, request);
  }
}
