package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.CallHeader;
import com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.NotificationEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.VoiceWebhookEvent;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswer;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswerReasonType;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswerStatusType;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.MenuInputType;
import com.sinch.sdk.domains.voice.models.webhooks.MenuResult;
import com.sinch.sdk.domains.voice.models.webhooks.MenuResultInputMethodType;
import com.sinch.sdk.domains.voice.models.webhooks.NotifyEvent;
import com.sinch.sdk.domains.voice.models.webhooks.PromptInputEvent;
import com.sinch.sdk.domains.voice.models.webhooks.WebhooksEvent;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WebhooksEventDtoConverter {

  public static WebhooksEvent convert(VoiceWebhookEvent dto) {

    if (null == dto) {
      return null;
    }

    WebhooksEvent.Builder<?> builder;

    if (dto instanceof com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent) {
      builder = convert((com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent) dto);
    } else if (dto instanceof DisconnectedCallEvent) {
      builder = convert((DisconnectedCallEvent) dto);
    } else if (dto instanceof com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEvent) {
      builder = convert((com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEvent) dto);
    } else if (dto instanceof com.sinch.sdk.domains.voice.models.v1.webhooks.PromptInputEvent) {
      builder = convert((com.sinch.sdk.domains.voice.models.v1.webhooks.PromptInputEvent) dto);
    } else if (dto instanceof NotificationEvent) {
      builder = convert((NotificationEvent) dto);
    } else {
      throw new ApiException("Unexpected event:" + dto);
    }

    return builder.setCallId(dto.getCallid()).setVersion(dto.getVersion()).build();
  }

  private static IncomingCallEvent.Builder<?> convert(
      com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent dto) {

    IncomingCallEvent.Builder<?> builder = IncomingCallEvent.builder();
    if (null == dto) {
      return builder;
    }

    return builder
        .setTimestamp(dto.getTimestamp())
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

  private static DisconnectCallEvent.Builder<?> convert(
      com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent dto) {

    DisconnectCallEvent.Builder<?> builder = DisconnectCallEvent.builder();
    if (null == dto) {
      return builder;
    }
    return builder
        .setTimestamp(dto.getTimestamp())
        .setCustom(dto.getCustom())
        .setReason(null != dto.getReason() ? CallReasonType.from(dto.getReason().value()) : null)
        .setResult(null != dto.getResult() ? CallResultType.from(dto.getResult().value()) : null)
        .setDebit(PriceDtoConverter.convert(dto.getDebit()))
        .setUserRate(PriceDtoConverter.convert(dto.getUserRate()))
        .setTo(DestinationDtoConverter.convert(dto.getTo()))
        .setApplicationKey(dto.getApplicationKey())
        .setDuration(dto.getDuration())
        .setFrom(dto.getFrom());
  }

  private static AnsweredCallEvent.Builder<?> convert(
      com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEvent dto) {

    AnsweredCallEvent.Builder<?> builder = AnsweredCallEvent.builder();
    if (null == dto) {
      return builder;
    }
    return builder
        .setTimestamp(dto.getTimestamp())
        .setCustom(dto.getCustom())
        .setAmd(convert(dto.getAmd()));
  }

  private static PromptInputEvent.Builder<?> convert(
      com.sinch.sdk.domains.voice.models.v1.webhooks.PromptInputEvent dto) {

    PromptInputEvent.Builder<?> builder = PromptInputEvent.builder();
    if (null == dto) {
      return builder;
    }
    return builder
        .setTimestamp(dto.getTimestamp())
        .setCustom(dto.getCustom())
        .setApplicationKey(dto.getApplicationKey())
        .setCallId(dto.getCallid())
        .setVersion(dto.getVersion())
        .setMenuResult(convert(dto.getMenuResult()));
  }

  private static NotifyEvent.Builder<?> convert(
      com.sinch.sdk.domains.voice.models.v1.webhooks.NotificationEvent dto) {

    NotifyEvent.Builder<?> builder = NotifyEvent.builder();
    if (null == dto) {
      return builder;
    }
    return builder
        .setCustom(dto.getCustom())
        .setCallId(dto.getCallid())
        .setVersion(dto.getVersion())
        .setType(dto.getType());
  }

  private static AmdAnswer convert(AnsweringMachineDetection dto) {

    if (null == dto) {
      return null;
    }
    AmdAnswer.Builder builder = AmdAnswer.builder().setDuration(dto.getDuration());

    if (null != dto.getReason()) {
      builder.setReason(convertReason(dto.getReason().value()));
    }
    if (null != dto.getStatus()) {
      builder.setStatus(convertStatus(dto.getStatus().value()));
    }
    return builder.build();
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

  private static Collection<Pair<String, String>> convertHeaderCollection(List<CallHeader> dto) {
    if (null == dto) {
      return null;
    }
    return dto.stream().map(f -> new Pair<>(f.getKey(), f.getValue())).collect(Collectors.toList());
  }

  private static MenuResult convert(com.sinch.sdk.domains.voice.models.v1.webhooks.MenuResult dto) {

    MenuResult.Builder builder =
        MenuResult.builder().setMenuId(dto.getMenuId()).setValue(dto.getValue());

    if (null != dto.getType()) {
      builder.setType(MenuInputType.from(dto.getType().value()));
    }
    if (null != dto.getInputMethod()) {
      builder.setInputMethod(MenuResultInputMethodType.from(dto.getInputMethod().value()));
    }
    return builder.build();
  }
}
