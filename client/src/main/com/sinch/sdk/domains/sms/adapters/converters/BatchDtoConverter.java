package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.BatchBinary;
import com.sinch.sdk.domains.sms.models.BatchMedia;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.MediaBody;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiBatchListBatchesInnerDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiBatchListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiDeliveryFeedbackDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiUpdateBinaryMtMessageDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiUpdateMmsMtMessageDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiUpdateTextMtMessageDto;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaBodyDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMSRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateBatchMessageRequestDto;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchBinaryRequest;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchMediaRequest;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import com.sinch.sdk.domains.sms.models.requests.UpdateBaseBatchRequest;
import com.sinch.sdk.domains.sms.models.requests.UpdateSmsBatchBinaryRequest;
import com.sinch.sdk.domains.sms.models.requests.UpdateSmsBatchMediaRequest;
import com.sinch.sdk.domains.sms.models.requests.UpdateSmsBatchTextRequest;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;

public class BatchDtoConverter {

  public static <T extends Batch<?>> T convert(AbstractOpenApiSchema dto) {
    Object obj = dto.getActualInstance();
    if (obj instanceof BinaryResponseDto) {
      @SuppressWarnings("unchecked")
      T t = (T) convertBinary((BinaryResponseDto) obj);
      return t;
    } else if (obj instanceof MediaResponseDto) {
      @SuppressWarnings("unchecked")
      T t = (T) convertMedia((MediaResponseDto) obj);
      return t;
    } else if (obj instanceof TextResponseDto) {
      @SuppressWarnings("unchecked")
      T t = (T) convertText((TextResponseDto) obj);
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
        .setDeliveryReport(DeliveryReportType.from(dto.getDeliveryReport()))
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
        .setDeliveryReport(DeliveryReportType.from(dto.getDeliveryReport()))
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
        .setDeliveryReport(DeliveryReportType.from(dto.getDeliveryReport()))
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

  public static UpdateBatchMessageRequestDto convert(UpdateBaseBatchRequest<?> value) {
    if (value instanceof UpdateSmsBatchBinaryRequest) {
      return convert((UpdateSmsBatchBinaryRequest) value);
    } else if (value instanceof UpdateSmsBatchMediaRequest) {
      return convert((UpdateSmsBatchMediaRequest) value);
    } else if (value instanceof UpdateSmsBatchTextRequest) {
      return convert((UpdateSmsBatchTextRequest) value);
    } else {
      throw new ApiException("Unexpected class:" + value.getClass().getName());
    }
  }

  private static SendSMSRequestDto convert(SendSmsBatchBinaryRequest value) {
    BinaryRequestDto dto =
        new BinaryRequestDto()
            .type(BinaryRequestDto.TypeEnum.MT_BINARY.getValue())
            .to(new ArrayList<>(value.getTo()))
            .body(value.getBody());
    value.getFrom().ifPresent(dto::from);
    value
        .getDeliveryReport()
        .ifPresent(f -> dto.setDeliveryReport(EnumDynamicConverter.convert(f)));
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
    value.getUdh().ifPresent(dto::udh);
    return new SendSMSRequestDto(dto);
  }

  private static SendSMSRequestDto convert(SendSmsBatchMediaRequest value) {
    MediaRequestDto dto =
        new MediaRequestDto(MediaRequestDto.TypeEnum.MT_MEDIA.getValue())
            .to(new ArrayList<>(value.getTo()))
            .body(convert(value.getBody()));
    value.getFrom().ifPresent(dto::from);
    value
        .getDeliveryReport()
        .ifPresent(f -> dto.setDeliveryReport(EnumDynamicConverter.convert(f)));
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
            .type(TextRequestDto.TypeEnum.MT_TEXT.getValue())
            .to(new ArrayList<>(value.getTo()))
            .body(value.getBody());
    value.getFrom().ifPresent(dto::from);
    value
        .getDeliveryReport()
        .ifPresent(f -> dto.setDeliveryReport(EnumDynamicConverter.convert(f)));
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

  private static UpdateBatchMessageRequestDto convert(UpdateSmsBatchTextRequest value) {
    ApiUpdateTextMtMessageDto dto =
        new ApiUpdateTextMtMessageDto().type(ApiUpdateTextMtMessageDto.TypeEnum.MT_TEXT.getValue());

    value.getToAdd().ifPresent(f -> dto.toAdd(new ArrayList<>(f)));
    value.getToRemove().ifPresent(f -> dto.toRemove(new ArrayList<>(f)));
    value.getFrom().ifPresent(dto::from);
    value.getBody().ifPresent(dto::body);
    value
        .getDeliveryReport()
        .ifPresent(f -> dto.setDeliveryReport(EnumDynamicConverter.convert(f)));
    value.getSendAt().ifPresent(f -> dto.setSendAt(f.atOffset(ZoneOffset.UTC)));
    value.getExpireAt().ifPresent(f -> dto.setExpireAt(f.atOffset(ZoneOffset.UTC)));
    value.getCallbackUrl().ifPresent(dto::callbackUrl);
    value.getParameters().ifPresent(f -> dto.setParameters(ParametersDtoConverter.convert(f)));
    return new UpdateBatchMessageRequestDto(dto);
  }

  private static UpdateBatchMessageRequestDto convert(UpdateSmsBatchMediaRequest value) {
    ApiUpdateMmsMtMessageDto dto =
        new ApiUpdateMmsMtMessageDto().type(ApiUpdateMmsMtMessageDto.TypeEnum.MT_MEDIA.getValue());

    value.getToAdd().ifPresent(f -> dto.toAdd(new ArrayList<>(f)));
    value.getToRemove().ifPresent(f -> dto.toRemove(new ArrayList<>(f)));
    value.getFrom().ifPresent(dto::from);
    value.getBody().ifPresent(f -> dto.setBody(convert(f)));
    value
        .getDeliveryReport()
        .ifPresent(f -> dto.setDeliveryReport(EnumDynamicConverter.convert(f)));
    value.getSendAt().ifPresent(f -> dto.setSendAt(f.atOffset(ZoneOffset.UTC)));
    value.getExpireAt().ifPresent(f -> dto.setExpireAt(f.atOffset(ZoneOffset.UTC)));
    value.getCallbackUrl().ifPresent(dto::callbackUrl);
    value.getParameters().ifPresent(f -> dto.setParameters(ParametersDtoConverter.convert(f)));
    value.isStrictValidation().ifPresent(dto::strictValidation);
    return new UpdateBatchMessageRequestDto(dto);
  }

  private static UpdateBatchMessageRequestDto convert(UpdateSmsBatchBinaryRequest value) {
    ApiUpdateBinaryMtMessageDto dto =
        new ApiUpdateBinaryMtMessageDto()
            .type(ApiUpdateBinaryMtMessageDto.TypeEnum.MT_BINARY.getValue());
    value.getToAdd().ifPresent(f -> dto.toAdd(new ArrayList<>(f)));
    value.getToRemove().ifPresent(f -> dto.toRemove(new ArrayList<>(f)));
    value.getFrom().ifPresent(dto::from);
    value.getBody().ifPresent(dto::setBody);
    value
        .getDeliveryReport()
        .ifPresent(f -> dto.setDeliveryReport(EnumDynamicConverter.convert(f)));
    value.getSendAt().ifPresent(f -> dto.setSendAt(f.atOffset(ZoneOffset.UTC)));
    value.getExpireAt().ifPresent(f -> dto.setExpireAt(f.atOffset(ZoneOffset.UTC)));
    value.getCallbackUrl().ifPresent(dto::callbackUrl);
    value.getUdh().ifPresent(dto::udh);
    return new UpdateBatchMessageRequestDto(dto);
  }

  private static MediaBodyDto convert(MediaBody value) {
    return new MediaBodyDto().url(value.getUrl()).message(value.getMessage().orElse(null));
  }

  public static <T extends Batch<?>> Collection<T> convert(ApiBatchListDto dto) {

    Collection<ApiBatchListBatchesInnerDto> collection = dto.getBatches();
    Collection<T> pageContent = new ArrayList<>();
    if (null != collection) {
      for (ApiBatchListBatchesInnerDto apiBatchListBatchesInnerDto : collection) {
        T convert = convert(apiBatchListBatchesInnerDto);
        pageContent.add(convert);
      }
    }
    return pageContent;
  }

  public static ApiDeliveryFeedbackDto convert(Collection<String> recipients) {
    return new ApiDeliveryFeedbackDto().recipients(new ArrayList<>(recipients));
  }
}
