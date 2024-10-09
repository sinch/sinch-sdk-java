package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.response.CallStatusType;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;

public class CallsDtoConverter {

  public static CallInformation convert(
      com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation dto) {
    if (null == dto) {
      return null;
    }
    return CallInformation.builder()
        .setFrom(DestinationDtoConverter.convert(dto.getFrom()))
        .setTo(DestinationDtoConverter.convert(dto.getTo()))
        .setDomain(null != dto.getDomain() ? DomainType.from(dto.getDomain().value()) : null)
        .setCallId(dto.getCallId())
        .setDuration(dto.getDuration())
        .setStatus(null != dto.getStatus() ? CallStatusType.from(dto.getStatus().value()) : null)
        .setResult(null != dto.getResult() ? CallResultType.from(dto.getResult().value()) : null)
        .setReason(null != dto.getReason() ? CallReasonType.from(dto.getReason().value()) : null)
        .setTimeStamp(null != dto.getTimestamp() ? dto.getTimestamp() : null)
        .setCustom(null != dto.getCustom() ? dto.getCustom() : null)
        .setUserRate(PriceDtoConverter.convert(dto.getUserRate()))
        .setDebit(PriceDtoConverter.convert(dto.getDebit()))
        .build();
  }

  public static SvamlControl convert(SVAMLControl client) {
    if (null == client) {
      return null;
    }
    SvamlControl.Builder dto = SvamlControl.builder();

    client
        .getInstructions()
        .ifPresent(f -> dto.setInstructions(SVAMLInstructionDtoConverter.convert(f)));
    client.getAction().ifPresent(f -> dto.setAction(SVAMLActionDtoConverter.convert(f)));
    return dto.build();
  }
}
