package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCallResponseObjDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SVAMLRequestBodyDto;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.response.CallReasonType;
import com.sinch.sdk.domains.voice.models.response.CallResultType;
import com.sinch.sdk.domains.voice.models.response.CallStatusType;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;

public class CallsDtoConverter {

  public static CallInformation convert(GetCallResponseObjDto dto) {
    if (null == dto) {
      return null;
    }
    return CallInformation.builder()
        .setFrom(DestinationDtoConverter.convert(dto.getFrom()))
        .setTo(DestinationDtoConverter.convert(dto.getTo()))
        .setDomain(null != dto.getDomain() ? DomainType.from(dto.getDomain()) : null)
        .setCallId(dto.getCallId())
        .setDuration(dto.getDuration())
        .setStatus(null != dto.getStatus() ? CallStatusType.from(dto.getStatus()) : null)
        .setResult(null != dto.getResult() ? CallResultType.from(dto.getResult()) : null)
        .setReason(null != dto.getReason() ? CallReasonType.from(dto.getReason()) : null)
        .setTimeStamp(null != dto.getTimestamp() ? dto.getTimestamp().toInstant() : null)
        .setCustom(null != dto.getCustom() ? dto.getCustom() : null)
        .setUserRate(PriceDtoConverter.convert(dto.getUserRate()))
        .setDebit(PriceDtoConverter.convert(dto.getDebit()))
        .build();
  }

  public static SVAMLRequestBodyDto convert(SVAMLControl client) {
    if (null == client) {
      return null;
    }
    SVAMLRequestBodyDto dto = new SVAMLRequestBodyDto();

    client
        .getInstructions()
        .ifPresent(f -> dto.instructions(SAVMLInstructionDtoConverter.convert(f)));
    client.getAction().ifPresent(f -> dto.action(SAVMLActionDtoConverter.convert(f)));
    return dto;
  }
}
