package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.*;
import com.sinch.sdk.domains.sms.models.dto.v1.BinaryResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MediaResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.TextResponseDto;

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
        .setCreatedAt(dto.getCreatedAt().toInstant())
        .setModifiedAt(dto.getModifiedAt().toInstant())
        .setDeliveryReport(DeliveryReport.from(dto.getDeliveryReport()))
        .setSendAt(dto.getSendAt().toInstant())
        .setExpireAt(dto.getExpireAt().toInstant())
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
            MediaBody.builder()
                .setMessage(dto.getBody().getMessage())
                .setUrl(dto.getBody().getUrl())
                .build())
        .setCreatedAt(dto.getCreatedAt().toInstant())
        .setModifiedAt(dto.getModifiedAt().toInstant())
        .setDeliveryReport(DeliveryReport.from(dto.getDeliveryReport()))
        .setSendAt(dto.getSendAt().toInstant())
        .setExpireAt(dto.getExpireAt().toInstant())
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
        .setCreatedAt(dto.getCreatedAt().toInstant())
        .setModifiedAt(dto.getModifiedAt().toInstant())
        .setDeliveryReport(DeliveryReport.from(dto.getDeliveryReport()))
        .setSendAt(dto.getSendAt().toInstant())
        .setExpireAt(dto.getExpireAt().toInstant())
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
}
