package com.sinch.sdk.domains.sms.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.adapters.BatchesServiceTest;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.BatchBinary;
import com.sinch.sdk.domains.sms.models.BatchMedia;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.Parameters;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjParameterKeyDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMSRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateBatchMessageRequestDto;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class BatchDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/BinaryResponseDto.json")
  public SendSMS201ResponseDto binaryResponseDto;

  @GivenJsonResource("/domains/sms/v1/TextResponseDto.json")
  public SendSMS201ResponseDto textResponseDto;

  @GivenJsonResource("/domains/sms/v1/MediaResponseDto.json")
  public SendSMS201ResponseDto mediaResponseDto;

  @GivenJsonResource("/domains/sms/v1/SendSMSBinaryRequestDto.json")
  public SendSMSRequestDto sendBinaryRequestDto;

  @GivenJsonResource("/domains/sms/v1/SendSMSTextRequestDto.json")
  public SendSMSRequestDto sendTextRequestDto;

  @GivenJsonResource("/domains/sms/v1/SendSMSMediaRequestDto.json")
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
    compareParameters(client.getParameters(), dto.getParameters());
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
    compareParameters(client.getParameters(), dto.getParameters());
    assertEquals(dto.getMaxNumberOfMessageParts(), client.getMaxNumberOfMessageParts());
    assertEquals(dto.getFromTon(), client.getFromTon());
    assertEquals(dto.getFromNpi(), client.getFromNpi());
  }

  private static void compareParameters(Parameters client, ParameterObjDto dto) {
    assertEquals(dto.size(), client.size());
    Collection<Parameters.Entry> values = client.values();
    values.forEach(
        e -> {
          Pair<String, String> clientItem = e.getValue();
          assertTrue(dto.containsKey(e.getKey()));
          @SuppressWarnings("unchecked")
          Map<String, String> dtoItem = (Map<String, String>) dto.get(e.getKey());
          assertTrue(dtoItem.containsKey(clientItem.getLeft()));
          assertEquals(dtoItem.get(clientItem.getLeft()), clientItem.getRight());
          Optional<String> defaultValue = e.getDefaultValue();
          if (defaultValue.isPresent()) {
            assertEquals(
                dtoItem.get(ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT), defaultValue.get());
          } else {
            assertNull(dtoItem.get(ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT));
          }
        });
  }

  @Test
  void convertBinaryResponse() {
    compareWithDto(BatchDtoConverter.convert(binaryResponseDto), binaryResponseDto);
  }

  @Test
  void convertMediaResponse() {
    compareWithDto(BatchDtoConverter.convert(mediaResponseDto), mediaResponseDto);
  }

  @Test
  void convertTextResponse() {
    compareWithDto(BatchDtoConverter.convert(textResponseDto), textResponseDto);
  }

  @Test
  void convertSendBinaryRequest() {
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.sendSmsBatchBinaryRequest))
        .usingRecursiveComparison()
        .isEqualTo(sendBinaryRequestDto);
  }

  @Test
  void convertSendtediaRequest() {
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
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.updateSmsBatchTextRequest))
        .usingRecursiveComparison()
        .isEqualTo(updateTextRequestDto);
  }

  @Test
  void convertUpdateMediaRequest() {
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.updateSmsBatchMediaRequest))
        .usingRecursiveComparison()
        .isEqualTo(updateMediaRequestDto);
  }

  @Test
  void convertUpdateBinaryRequest() {
    org.assertj.core.api.Assertions.assertThat(
            BatchDtoConverter.convert(BatchesServiceTest.updateSmsBatchBinaryRequest))
        .usingRecursiveComparison()
        .isEqualTo(updateBinaryRequestDto);
  }
}
