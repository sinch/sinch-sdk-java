package com.sinch.sdk.domains.sms.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.fail;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.adapters.BatchesServiceTest;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.BatchBinary;
import com.sinch.sdk.domains.sms.models.BatchMedia;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMSRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateBatchMessageRequestDto;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class BatchDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/batches/response/BatchBinaryDto.json")
  public SendSMS201ResponseDto binaryResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/BatchTextDto.json")
  public SendSMS201ResponseDto textResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/BatchMediaDto.json")
  public SendSMS201ResponseDto mediaResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/request/BinaryRequestDto.json")
  public SendSMSRequestDto sendBinaryRequestDto;

  @GivenJsonResource("/domains/sms/v1/batches/request/TextRequestDto.json")
  public SendSMSRequestDto sendTextRequestDto;

  @GivenJsonResource("/domains/sms/v1/batches/request/MediaRequestDto.json")
  public SendSMSRequestDto sendMediaRequestDto;

  @GivenJsonResource("/domains/sms/v1/UpdateSMSTextRequestDto.json")
  public UpdateBatchMessageRequestDto updateTextRequestDto;

  @GivenJsonResource("/domains/sms/v1/UpdateSMSMediaRequestDto.json")
  public UpdateBatchMessageRequestDto updateMediaRequestDto;

  @GivenJsonResource("/domains/sms/v1/UpdateSMSBinaryRequestDto.json")
  public UpdateBatchMessageRequestDto updateBinaryRequestDto;

  public static void compareWithDto(Batch<?> client, SendSMS201ResponseDto dto) {
    Object obj = dto.getActualInstance();
    if (obj instanceof BinaryResponseDto) {
      assertInstanceOf(BatchBinary.class, client);
      compareBinary((BatchBinary) client, dto.getBinaryResponseDto());
    } else if (obj instanceof MediaResponseDto) {
      assertInstanceOf(BatchMedia.class, client);
      compareMedia((BatchMedia) client, dto.getMediaResponseDto());
    } else if (obj instanceof TextResponseDto) {
      assertInstanceOf(BatchText.class, client);
      compareText((BatchText) client, dto.getTextResponseDto());
    } else {
      fail("Unexpected class:" + obj.getClass().getName());
    }
  }

  private static void compareBinary(BatchBinary client, BinaryResponseDto dto) {
    assertEquals(dto.getId(), client.getId());
    assertEquals(dto.getTo(), client.getTo());
    assertEquals(dto.getFrom(), client.getFrom());
    assertEquals(dto.getCanceled(), client.isCanceled());
    assertEquals(dto.getBody(), client.getBody());
    assertEquals(dto.getUdh(), client.getUdh());
    assertEquals(dto.getType(), BinaryResponseDto.TypeEnum.MT_BINARY.getValue());
    assertEquals(dto.getCreatedAt().toInstant(), client.getCreatedAt());
    assertEquals(dto.getModifiedAt().toInstant(), client.getModifiedAt());
    Assertions.assertEquals(dto.getDeliveryReport(), client.getDeliveryReport().value());
    assertEquals(dto.getSendAt().toInstant(), client.getSendAt());
    assertEquals(dto.getExpireAt().toInstant(), client.getExpireAt());
    assertEquals(dto.getCallbackUrl(), client.getCallbackUrl());
    assertEquals(dto.getClientReference(), client.getClientReference());
    assertEquals(dto.getFeedbackEnabled(), client.isFeedbackEnabled());
    assertEquals(dto.getFlashMessage(), client.isFlashMessage());
    assertEquals(dto.getTruncateConcat(), client.isTruncateConcat());
    assertEquals(dto.getMaxNumberOfMessageParts(), client.getMaxNumberOfMessageParts());
    assertEquals(dto.getFromTon(), client.getFromTon());
    assertEquals(dto.getFromNpi(), client.getFromNpi());
  }

  private static void compareMedia(BatchMedia client, MediaResponseDto dto) {
    assertEquals(dto.getId(), client.getId());
    assertEquals(dto.getTo(), client.getTo());
    assertEquals(dto.getFrom(), client.getFrom());
    assertEquals(dto.getCanceled(), client.isCanceled());
    assertEquals(dto.getBody().getUrl(), client.getBody().getUrl());
    assertEquals(dto.getBody().getMessage(), client.getBody().getMessage().get());
    assertEquals(dto.getType(), MediaResponseDto.TypeEnum.MT_MEDIA.getValue());
    assertEquals(dto.getCreatedAt().toInstant(), client.getCreatedAt());
    assertEquals(dto.getModifiedAt().toInstant(), client.getModifiedAt());
    Assertions.assertEquals(dto.getDeliveryReport(), client.getDeliveryReport().value());
    assertEquals(dto.getSendAt().toInstant(), client.getSendAt());
    assertEquals(dto.getExpireAt().toInstant(), client.getExpireAt());
    TestHelpers.recursiveEquals(client.getParameters(), dto.getParameters());
    assertEquals(dto.getCallbackUrl(), client.getCallbackUrl());
    assertEquals(dto.getClientReference(), client.getClientReference());
    assertEquals(dto.getFeedbackEnabled(), client.isFeedbackEnabled());
  }

  private static void compareText(BatchText client, TextResponseDto dto) {
    assertEquals(dto.getId(), client.getId());
    assertEquals(dto.getTo(), client.getTo());
    assertEquals(dto.getFrom(), client.getFrom());
    assertEquals(dto.getCanceled(), client.isCanceled());
    assertEquals(dto.getBody(), client.getBody());
    assertEquals(dto.getType(), TextResponseDto.TypeEnum.MT_TEXT.getValue());
    assertEquals(dto.getCreatedAt().toInstant(), client.getCreatedAt());
    assertEquals(dto.getModifiedAt().toInstant(), client.getModifiedAt());
    Assertions.assertEquals(dto.getDeliveryReport(), client.getDeliveryReport().value());
    assertEquals(dto.getSendAt().toInstant(), client.getSendAt());
    assertEquals(dto.getExpireAt().toInstant(), client.getExpireAt());
    assertEquals(dto.getCallbackUrl(), client.getCallbackUrl());
    assertEquals(dto.getClientReference(), client.getClientReference());
    assertEquals(dto.getFeedbackEnabled(), client.isFeedbackEnabled());
    assertEquals(dto.getFlashMessage(), client.isFlashMessage());
    assertEquals(dto.getTruncateConcat(), client.isTruncateConcat());
    TestHelpers.recursiveEquals(client.getParameters(), dto.getParameters());
    assertEquals(dto.getMaxNumberOfMessageParts(), client.getMaxNumberOfMessageParts());
    assertEquals(dto.getFromTon(), client.getFromTon());
    assertEquals(dto.getFromNpi(), client.getFromNpi());
  }

  @Test
  void convertBinaryResponse() {
    TestHelpers.recursiveEquals(
        BatchDtoConverter.convert(binaryResponseDto), BatchesServiceTest.batchBinary);
  }

  @Test
  void convertMediaResponse() {
    TestHelpers.recursiveEquals(
        BatchDtoConverter.convert(mediaResponseDto), BatchesServiceTest.batchMedia);
  }

  @Test
  void convertTextResponse() {
    TestHelpers.recursiveEquals(
        BatchDtoConverter.convert(textResponseDto), BatchesServiceTest.batchText);
  }

  @Test
  void convertSendBinaryRequest() {
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.sendSmsBatchBinaryRequest))
        .usingRecursiveComparison()
        .isEqualTo(sendBinaryRequestDto);
  }

  @Test
  void convertSendMediaRequest() {
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.sendSmsBatchMediaRequest))
        .usingRecursiveComparison()
        .isEqualTo(sendMediaRequestDto);
  }

  @Test
  void convertSendTextRequest() {
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.sendSmsBatchTextRequest))
        .usingRecursiveComparison()
        .isEqualTo(sendTextRequestDto);
  }

  @Test
  void convertUpdateTextRequest() {
    TestHelpers.recursiveEquals(
        BatchDtoConverter.convert(BatchesServiceTest.updateSmsBatchTextRequest),
        updateTextRequestDto);
  }

  @Test
  void convertUpdateMediaRequest() {
    TestHelpers.recursiveEquals(
        BatchDtoConverter.convert(BatchesServiceTest.updateSmsBatchMediaRequest),
        updateMediaRequestDto);
  }

  @Test
  void convertUpdateBinaryRequest() {
    TestHelpers.recursiveEquals(
        BatchDtoConverter.convert(BatchesServiceTest.updateSmsBatchBinaryRequest),
        updateBinaryRequestDto);
  }

  @Test
  void convertDeliveryFeedbackRecipients() {
    Collection<String> recipients = Arrays.asList("foo1", "foo2");
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(recipients).getRecipients())
        .usingRecursiveComparison()
        .isEqualTo(recipients);
  }
}
