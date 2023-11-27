package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.domains.sms.models.Inbound;
import com.sinch.sdk.domains.sms.models.InboundBinary;
import com.sinch.sdk.domains.sms.models.InboundText;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiInboundListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.InboundDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MOBinaryDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MOTextDto;
import java.util.ArrayList;
import java.util.Collection;

public class InboundsDtoConverter {

  public static Inbound<?> convert(AbstractOpenApiSchema dto) {
    Object obj = dto.getActualInstance();
    if (obj instanceof MOBinaryDto) {
      return convert((MOBinaryDto) obj);
    } else if (obj instanceof MOTextDto) {
      return convert((MOTextDto) obj);
    } else {
      throw new ApiException("Unexpected class:" + obj.getClass().getName());
    }
  }

  public static Collection<Inbound<?>> convert(ApiInboundListDto dto) {

    Collection<InboundDto> collection = dto.getInbounds();
    Collection<Inbound<?>> pageContent = new ArrayList<>();
    if (null != collection) {
      for (InboundDto innerDto : collection) {
        Inbound<?> convert = convert(innerDto);
        pageContent.add(convert);
      }
    }
    return pageContent;
  }

  public static InboundBinary convert(MOBinaryDto dto) {
    return InboundBinary.builder()
        .setBody(dto.getBody())
        .setFrom(dto.getFrom())
        .setId(dto.getId())
        .setReceivedAt(null != dto.getReceivedAt() ? dto.getReceivedAt().toInstant() : null)
        .setTo(dto.getTo())
        .setClientReference(dto.getClientReference())
        .setOperatorId(dto.getOperatorId())
        .setSentAt(null != dto.getSentAt() ? dto.getSentAt().toInstant() : null)
        .setUdh(dto.getUdh())
        .build();
  }

  public static InboundText convert(MOTextDto dto) {
    return InboundText.builder()
        .setBody(dto.getBody())
        .setFrom(dto.getFrom())
        .setId(dto.getId())
        .setReceivedAt(null != dto.getReceivedAt() ? dto.getReceivedAt().toInstant() : null)
        .setTo(dto.getTo())
        .setClientReference(dto.getClientReference())
        .setOperatorId(dto.getOperatorId())
        .setSentAt(null != dto.getSentAt() ? dto.getSentAt().toInstant() : null)
        .build();
  }
}
