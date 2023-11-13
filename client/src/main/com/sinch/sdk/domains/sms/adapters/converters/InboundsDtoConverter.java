package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.AbstractOpenApiSchema;
import com.sinch.sdk.core.models.pagination.PageToken;
import com.sinch.sdk.core.utils.Pair;
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

  public static Pair<Collection<Inbound<?>>, PageToken<Integer>> convert(ApiInboundListDto dto) {
    // check end of pagination limit reached: (current page number * page size ) cannot be greater
    // than "count" to be able to call next page
    Integer nextPageToken =
        ((dto.getPage() + 1) * Long.valueOf(dto.getPageSize())) >= dto.getCount()
            ? null
            : dto.getPage() + 1;
    Collection<InboundDto> collection = dto.getInbounds();
    Collection<Inbound<?>> pageContent = new ArrayList<>();
    if (null != collection) {
      for (InboundDto innerDto : collection) {
        Inbound<?> convert = convert(innerDto);
        pageContent.add(convert);
      }
    }
    return new Pair<>(pageContent, new PageToken<>(nextPageToken));
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
