package com.sinch.sdk.domains.sms.adapters.converters;

import static com.sinch.sdk.domains.sms.models.dto.v1.BinaryRequestDto.TypeEnum.MT_BINARY;
import static com.sinch.sdk.domains.sms.models.dto.v1.MediaRequestDto.TypeEnum.MT_MEDIA;
import static com.sinch.sdk.domains.sms.models.dto.v1.TextRequestDto.TypeEnum.MT_TEXT;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.*;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaBodyDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMSRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextResponseDto;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchBinaryRequest;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchMediaRequest;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class BatchDtoConverter {

  public static <T extends Batch<?>> T convert(SendSMS201ResponseDto dto) {
    Object obj = dto.getActualInstance();
    if (obj instanceof BinaryResponseDto) {
      @SuppressWarnings("unchecked")
      T t = (T) convertBinary(dto.getBinaryResponseDto());
      return t;
    } else if (obj instanceof MediaResponseDto) {
      @SuppressWarnings("unchecked")
      T t = (T) convertMedia(dto.getMediaResponseDto());
      return t;
    } else if (obj instanceof TextResponseDto) {
      @SuppressWarnings("unchecked")
      T t = (T) convertText(dto.getTextResponseDto());
      return t;
    } else {
      throw new ApiException("Unexpected class:" + obj.getClass().getName());
    }
  }

  private static BatchBinary convertBinary(BinaryResponseDto dto) {
    return BatchBinary.builder()
        .setId(dto.getId())
        .setTo(dto.getTo())
        .setFrom(dto.getFrom())
        .setCanceled(dto.getCanceled())
        .setBody(dto.getBody())
        .setUdh(dto.getUdh())
        .setCreatedAt(null != dto.getCreatedAt() ? dto.getCreatedAt().toInstant() : null)
        .setModifiedAt(null != dto.getModifiedAt() ? dto.getModifiedAt().toInstant() : null)
        .setDeliveryReport(DeliveryReport.from(dto.getDeliveryReport()))
        .setSendAt(null != dto.getSendAt() ? dto.getSendAt().toInstant() : null)
        .setExpireAt(null != dto.getExpireAt() ? dto.getExpireAt().toInstant() : null)
        .setCallbackUrl(dto.getCallbackUrl())
        .setClientReference(dto.getClientReference())
        .setFeedbackEnabled(dto.getFeedbackEnabled())
        .setFlashMessage(dto.getFlashMessage())
        .setTruncateConcat(dto.getTruncateConcat())
        .setMaxNumberOfMessageParts(dto.getMaxNumberOfMessageParts())
        .setFromTon(dto.getFromTon())
        .setFromNpi(dto.getFromNpi())
        .build();
  }

  private static BatchMedia convertMedia(MediaResponseDto dto) {
    return BatchMedia.builder()
        .setId(dto.getId())
        .setTo(dto.getTo())
        .setFrom(dto.getFrom())
        .setCanceled(dto.getCanceled())
        .setBody(
            null != dto.getBody()
                ? MediaBody.builder()
                    .setMessage(dto.getBody().getMessage())
                    .setUrl(dto.getBody().getUrl())
                    .build()
                : null)
        .setCreatedAt(null != dto.getCreatedAt() ? dto.getCreatedAt().toInstant() : null)
        .setModifiedAt(null != dto.getModifiedAt() ? dto.getModifiedAt().toInstant() : null)
        .setDeliveryReport(DeliveryReport.from(dto.getDeliveryReport()))
        .setSendAt(null != dto.getSendAt() ? dto.getSendAt().toInstant() : null)
        .setExpireAt(null != dto.getExpireAt() ? dto.getExpireAt().toInstant() : null)
        .setCallbackUrl(dto.getCallbackUrl())
        .setClientReference(dto.getClientReference())
        .setFeedbackEnabled(dto.getFeedbackEnabled())
        .setParameters(ParametersDtoConverter.convert(dto.getParameters()))
        .build();
  }

  private static BatchText convertText(TextResponseDto dto) {
    return BatchText.builder()
        .setId(dto.getId())
        .setTo(dto.getTo())
        .setFrom(dto.getFrom())
        .setCanceled(dto.getCanceled())
        .setBody(dto.getBody())
        .setCreatedAt(null != dto.getCreatedAt() ? dto.getCreatedAt().toInstant() : null)
        .setModifiedAt(null != dto.getModifiedAt() ? dto.getModifiedAt().toInstant() : null)
        .setDeliveryReport(DeliveryReport.from(dto.getDeliveryReport()))
        .setSendAt(null != dto.getSendAt() ? dto.getSendAt().toInstant() : null)
        .setExpireAt(null != dto.getExpireAt() ? dto.getExpireAt().toInstant() : null)
        .setCallbackUrl(dto.getCallbackUrl())
        .setClientReference(dto.getClientReference())
        .setFeedbackEnabled(dto.getFeedbackEnabled())
        .setFlashMessage(dto.getFlashMessage())
        .setTruncateConcat(dto.getTruncateConcat())
        .setMaxNumberOfMessageParts(dto.getMaxNumberOfMessageParts())
        .setFromTon(dto.getFromTon())
        .setFromNpi(dto.getFromNpi())
        .setParameters(ParametersDtoConverter.convert(dto.getParameters()))
        .build();
  }

  public static SendSMSRequestDto convert(BaseBatch<?> value) {
    if (value instanceof SendSmsBatchBinaryRequest) {
      return convert((SendSmsBatchBinaryRequest) value);
    } else if (value instanceof SendSmsBatchMediaRequest) {
      return convert((SendSmsBatchMediaRequest) value);
    } else if (value instanceof SendSmsBatchTextRequest) {
      return convert((SendSmsBatchTextRequest) value);
    } else {
      throw new ApiException("Unexpected class:" + value.getClass().getName());
    }
  }

  private static SendSMSRequestDto convert(SendSmsBatchBinaryRequest value) {
    BinaryRequestDto dto =
        new BinaryRequestDto()
            .type(MT_BINARY.getValue())
            .to(new ArrayList<>(value.getTo()))
            .body(value.getBody());
    value.getFrom().ifPresent(dto::from);
    value.getDeliveryReport().ifPresent(f -> dto.setDeliveryReport(f.value()));
    value.getSendAt().ifPresent(f -> dto.setSendAt(f.atOffset(ZoneOffset.UTC)));
    value.getExpireAt().ifPresent(f -> dto.setExpireAt(f.atOffset(ZoneOffset.UTC)));
    value.getCallbackUrl().ifPresent(dto::callbackUrl);
    value.getClientReference().ifPresent(dto::clientReference);
    value.isFeedbackEnabled().ifPresent(dto::feedbackEnabled);
    value.isFlashMessage().ifPresent(dto::flashMessage);
    value.isTruncateConcat().ifPresent(dto::truncateConcat);
    value.getMaxNumberOfMessageParts().ifPresent(dto::maxNumberOfMessageParts);
    value.getFromTon().ifPresent(dto::fromTon);
    value.getFromNpi().ifPresent(dto::fromNpi);
    dto.udh(value.getUdh());
    return new SendSMSRequestDto(dto);
  }

  private static SendSMSRequestDto convert(SendSmsBatchMediaRequest value) {
    MediaRequestDto dto =
        new MediaRequestDto(MT_MEDIA.getValue())
            .to(new ArrayList<>(value.getTo()))
            .body(convert(value.getBody()));
    value.getFrom().ifPresent(dto::from);
    value.getDeliveryReport().ifPresent(f -> dto.setDeliveryReport(f.value()));
    value.getSendAt().ifPresent(f -> dto.setSendAt(f.atOffset(ZoneOffset.UTC)));
    value.getExpireAt().ifPresent(f -> dto.setExpireAt(f.atOffset(ZoneOffset.UTC)));
    value.getCallbackUrl().ifPresent(dto::callbackUrl);
    value.getClientReference().ifPresent(dto::clientReference);
    value.isFeedbackEnabled().ifPresent(dto::feedbackEnabled);
    value.isStrictValidation().ifPresent(dto::strictValidation);
    value.getParameters().ifPresent(f -> dto.setParameters(ParametersDtoConverter.convert(f)));
    return new SendSMSRequestDto(dto);
  }

  private static SendSMSRequestDto convert(SendSmsBatchTextRequest value) {
    TextRequestDto dto =
        new TextRequestDto()
            .type(MT_TEXT.getValue())
            .to(new ArrayList<>(value.getTo()))
            .body(value.getBody());
    value.getFrom().ifPresent(dto::from);
    value.getDeliveryReport().ifPresent(f -> dto.setDeliveryReport(f.value()));
    value.getSendAt().ifPresent(f -> dto.setSendAt(f.atOffset(ZoneOffset.UTC)));
    value.getExpireAt().ifPresent(f -> dto.setExpireAt(f.atOffset(ZoneOffset.UTC)));
    value.getCallbackUrl().ifPresent(dto::callbackUrl);
    value.getClientReference().ifPresent(dto::clientReference);
    value.isFeedbackEnabled().ifPresent(dto::feedbackEnabled);
    value.isFlashMessage().ifPresent(dto::flashMessage);
    value.isTruncateConcat().ifPresent(dto::truncateConcat);
    value.getMaxNumberOfMessageParts().ifPresent(dto::maxNumberOfMessageParts);
    value.getFromTon().ifPresent(dto::fromTon);
    value.getFromNpi().ifPresent(dto::fromNpi);
    value.getParameters().ifPresent(f -> dto.setParameters(ParametersDtoConverter.convert(f)));
    return new SendSMSRequestDto(dto);
  }

  private static MediaBodyDto convert(MediaBody value) {
    return new MediaBodyDto().url(value.getUrl()).message(value.getMessage().orElse(null));
  }
}
