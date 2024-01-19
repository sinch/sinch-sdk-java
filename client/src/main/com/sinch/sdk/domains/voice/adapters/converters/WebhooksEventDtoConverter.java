package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.common.adapters.converters.OffsetDateTimeDtoConverter;
import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.dto.v1.AceRequestAllOfAmdDto;
import com.sinch.sdk.domains.voice.models.dto.v1.AceRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CallHeaderDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DiceRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.IceRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.WebhooksEventDto;
import com.sinch.sdk.domains.voice.models.dto.v1.WebhooksEventRequestDto;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswer;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswerReasonType;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswerStatusType;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.CallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WebhooksEventDtoConverter {

  public static CallEvent convert(WebhooksEventDto dto) {

    if (null == dto) {
      return null;
    }

    CallEvent.Builder<?> builder;

    WebhooksEventRequestDto instance = (WebhooksEventRequestDto) dto.getActualInstance();
    if (instance instanceof IceRequestDto) {
      IceRequestDto iceDto = (IceRequestDto) instance;
      builder = convert(iceDto);
    } else if (instance instanceof DiceRequestDto) {
      DiceRequestDto diceDto = (DiceRequestDto) instance;
      builder = convert(diceDto);
    } else if (instance instanceof AceRequestDto) {
      AceRequestDto aceDto = (AceRequestDto) instance;
      builder = convert(aceDto);
    } else {
      throw new ApiException("Unexpected event:" + dto);
    }

    return builder.setCallId(instance.getCallid()).setVersion(instance.getVersion()).build();
  }

  private static IncomingCallEvent.Builder<?> convert(IceRequestDto dto) {

    IncomingCallEvent.Builder<?> builder = IncomingCallEvent.builder();
    if (null == dto) {
      return builder;
    }

    return builder
        .setTimestamp(OffsetDateTimeDtoConverter.convert(dto.getTimestamp()))
        .setCustom(dto.getCustom())
        .setCallResourceUrl(dto.getCallResourceUrl())
        .setUserRate(PriceDtoConverter.convert(dto.getUserRate()))
        .setCli(dto.getCli())
        .setTo(DestinationDtoConverter.convert(dto.getTo()))
        .setDomain(DomainTypeDtoConverter.convert(dto.getDomain()))
        .setApplicationKey(dto.getApplicationKey())
        .setOriginationType(DomainTypeDtoConverter.convert(dto.getOriginationType()))
        .setDuration(dto.getDuration())
        .setRdnis(dto.getRdnis())
        .setCallHeaders(convertHeaderCollection(dto.getCallHeaders()));
  }

  private static DisconnectCallEvent.Builder<?> convert(DiceRequestDto dto) {

    DisconnectCallEvent.Builder<?> builder = DisconnectCallEvent.builder();
    if (null == dto) {
      return builder;
    }
    return builder
        .setTimestamp(OffsetDateTimeDtoConverter.convert(dto.getTimestamp()))
        .setCustom(dto.getCustom())
        .setReason(null != dto.getReason() ? CallReasonType.from(dto.getReason()) : null)
        .setResult(null != dto.getResult() ? CallResultType.from(dto.getResult().getValue()) : null)
        .setDebit(PriceDtoConverter.convert(dto.getDebit()))
        .setUserRate(PriceDtoConverter.convert(dto.getUserRate()))
        .setTo(DestinationDtoConverter.convert(dto.getTo()))
        .setApplicationKey(dto.getApplicationKey())
        .setDuration(dto.getDuration())
        .setFrom(dto.getFrom());
  }

  private static AnsweredCallEvent.Builder<?> convert(AceRequestDto dto) {

    AnsweredCallEvent.Builder<?> builder = AnsweredCallEvent.builder();
    if (null == dto) {
      return builder;
    }
    return builder
        .setTimestamp(OffsetDateTimeDtoConverter.convert(dto.getTimestamp()))
        .setCustom(dto.getCustom())
        .setAmd(convert(dto.getAmd()));
  }

  private static AmdAnswer convert(AceRequestAllOfAmdDto dto) {

    if (null == dto) {
      return null;
    }
    return AmdAnswer.builder()
        .setReason(convertReason(dto.getReason()))
        .setStatus(convertStatus(dto.getStatus()))
        .setDuration(dto.getDuration())
        .build();
  }

  private static AmdAnswerReasonType convertReason(String dto) {
    if (null == dto) {
      return null;
    }
    return AmdAnswerReasonType.from(dto);
  }

  private static AmdAnswerStatusType convertStatus(String dto) {
    if (null == dto) {
      return null;
    }
    return AmdAnswerStatusType.from(dto);
  }

  private static Collection<Pair<String, String>> convertHeaderCollection(List<CallHeaderDto> dto) {
    if (null == dto) {
      return null;
    }
    return dto.stream().map(f -> new Pair<>(f.getKey(), f.getValue())).collect(Collectors.toList());
  }
}
