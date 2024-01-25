package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.domains.conversation.adapters.models.CallbackSettingsImpl;
import com.sinch.sdk.domains.conversation.adapters.models.DispatchRetentionPolicyImpl;
import com.sinch.sdk.domains.conversation.adapters.models.RetentionPolicyImpl;
import com.sinch.sdk.domains.conversation.adapters.models.SmartConversationImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.AppRequestParametersImpl;
import com.sinch.sdk.domains.conversation.models.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.ConversationMetadataReportViewType;
import com.sinch.sdk.domains.conversation.models.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.MessageSearch;
import com.sinch.sdk.domains.conversation.models.PersistMessageStatus;
import com.sinch.sdk.domains.conversation.models.ProcessingModeType;
import com.sinch.sdk.domains.conversation.models.QueueStats;
import com.sinch.sdk.domains.conversation.models.RateLimits;
import com.sinch.sdk.domains.conversation.models.RetentionPolicyType;
import com.sinch.sdk.domains.conversation.models.SmartConversation;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppCreateRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppResponseDeliveryReportBasedFallbackDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppResponseDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppResponsePersistMessageStatusDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.AppUpdateRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.CallbackSettingsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelCredentialDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationMetadataReportViewDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.DispatchRetentionPolicyDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.DispatchRetentionPolicyTypeDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ListAppsResponseDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ProcessingModeDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.QueueStatsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.RateLimitsDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.RetentionPolicyDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.RetentionPolicyTypeDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.SmartConversationDto;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.App;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class AppConverter {

  public static Collection<App> convert(ListAppsResponseDto dto) {
    if (null == dto) {
      return null;
    }
    return dto.getApps().stream().map(AppConverter::convert).collect(Collectors.toList());
  }

  public static App convert(AppResponseDto dto) {
    if (null == dto) {
      return null;
    }
    return App.builder()
        .setChannelCredentials(CredentialsDtoConverter.convert(dto.getChannelCredentials()))
        .setMetadataReportView(convert(dto.getConversationMetadataReportView()))
        .setDisplayName(dto.getDisplayName())
        .setId(dto.getId())
        .setRateLimits(convert(dto.getRateLimits()))
        .setRetentionPolicy(convert(dto.getRetentionPolicy()))
        .setDispatchRetentionPolicy(convert(dto.getDispatchRetentionPolicy()))
        .setProcessingMode(convert(dto.getProcessingMode()))
        .setSmartConversation(convert(dto.getSmartConversation()))
        .setQueueStats(convert(dto.getQueueStats()))
        .setPersistMessageStatus(convert(dto.getPersistMessageStatus()))
        .setMessageSearch(convertAsMessageSearch(dto.getMessageSearch()))
        .setCallbackSettings(convert(dto.getCallbackSettings()))
        .setDeliveryReportBasedFallback(convert(dto.getDeliveryReportBasedFallback()))
        // dto.getMessageRetrySettings()
        .build();
  }

  // due to OAS file description AppCreateRequestDto and AppUpdateRequestDto are duplicated,
  // so we have to duplicate function with both variation 'convertForCreate' and 'convertForUpdate'
  public static AppCreateRequestDto convertForCreate(AppRequestParameters parameters) {
    if (null == parameters) {
      return null;
    }
    AppRequestParametersImpl client = (AppRequestParametersImpl) parameters;

    AppCreateRequestDto dto = new AppCreateRequestDto();

    client.getDisplayName().ifPresent(dto::displayName);

    client
        .getChannelCredentials()
        .ifPresent(
            f -> {
              Collection<ConversationChannelCredentialDto> collection =
                  CredentialsDtoConverter.convertToDto(f);
              dto.setChannelCredentials(
                  null == collection ? Collections.emptyList() : new ArrayList<>(collection));
            });
    client
        .getMetadataReportView()
        .ifPresent(
            f ->
                dto.conversationMetadataReportView(
                    ConversationMetadataReportViewDto.fromValue(f.value())));
    client.getRetentionPolicy().ifPresent(f -> dto.setRetentionPolicy(convert(f)));
    client.getDispatchRetentionPolicy().ifPresent(f -> dto.dispatchRetentionPolicy(convert(f)));
    client
        .getProcessingMode()
        .ifPresent(f -> dto.processingMode(ProcessingModeDto.fromValue(f.value())));
    client.getSmartConversation().ifPresent(f -> dto.smartConversation(convert(f)));
    client.getCallbackSettings().ifPresent(f -> dto.callbackSettings(convert(f)));
    return dto;
  }

  // due to OAS file description AppCreateRequestDto and AppUpdateRequestDto are duplicated,
  // so we have to duplicate function with both variation 'convertForCreate' and 'convertForUpdate'
  public static AppUpdateRequestDto convertForUpdate(AppRequestParameters parameters) {
    if (null == parameters) {
      return null;
    }
    AppRequestParametersImpl client = (AppRequestParametersImpl) parameters;

    AppUpdateRequestDto dto = new AppUpdateRequestDto();

    client.getDisplayName().ifPresent(dto::displayName);

    client
        .getChannelCredentials()
        .ifPresent(
            f -> {
              Collection<ConversationChannelCredentialDto> collection =
                  CredentialsDtoConverter.convertToDto(f);
              dto.setChannelCredentials(
                  null == collection ? Collections.emptyList() : new ArrayList<>(collection));
            });
    client
        .getMetadataReportView()
        .ifPresent(
            f ->
                dto.conversationMetadataReportView(
                    ConversationMetadataReportViewDto.fromValue(f.value())));
    client.getRetentionPolicy().ifPresent(f -> dto.setRetentionPolicy(convert(f)));
    client.getDispatchRetentionPolicy().ifPresent(f -> dto.dispatchRetentionPolicy(convert(f)));
    client
        .getProcessingMode()
        .ifPresent(f -> dto.processingMode(ProcessingModeDto.fromValue(f.value())));
    client.getSmartConversation().ifPresent(f -> dto.smartConversation(convert(f)));
    client.getCallbackSettings().ifPresent(f -> dto.callbackSettings(convert(f)));
    return dto;
  }

  private static ConversationMetadataReportViewType convert(ConversationMetadataReportViewDto dto) {
    if (null == dto) {
      return null;
    }
    return ConversationMetadataReportViewType.from(dto.getValue());
  }

  private static RateLimits convert(RateLimitsDto dto) {
    if (null == dto) {
      return null;
    }
    return RateLimits.builder()
        .setInBound(dto.getInbound())
        .setOutBound(dto.getOutbound())
        .setWebhooks(dto.getWebhooks())
        .build();
  }

  private static RetentionPolicyImpl convert(RetentionPolicyDto dto) {
    if (null == dto) {
      return null;
    }
    return RetentionPolicyImpl.builder()
        .setRetentionType(convert(dto.getRetentionType()))
        .setTtlDays(null != dto.getTtlDays() ? dto.getTtlDays().intValue() : null)
        .build();
  }

  private static RetentionPolicyDto convert(RetentionPolicyImpl client) {
    if (null == client) {
      return null;
    }

    RetentionPolicyDto dto = new RetentionPolicyDto();
    client
        .retentionType()
        .ifPresent(f -> dto.setRetentionType(RetentionPolicyTypeDto.fromValue(f.value())));
    client.ttlDays().ifPresent(f -> dto.setTtlDays(null != f ? f.longValue() : null));
    return dto;
  }

  private static DispatchRetentionPolicyDto convert(DispatchRetentionPolicyImpl client) {
    if (null == client) {
      return null;
    }

    DispatchRetentionPolicyDto dto = new DispatchRetentionPolicyDto();
    dto.setRetentionType(DispatchRetentionPolicyTypeDto.MESSAGE_EXPIRE_POLICY);
    client.ttlDays().ifPresent(f -> dto.setTtlDays(null != f ? f.longValue() : null));
    return dto;
  }

  private static RetentionPolicyType convert(RetentionPolicyTypeDto dto) {
    if (null == dto) {
      return null;
    }
    return RetentionPolicyType.from(dto.getValue());
  }

  private static DispatchRetentionPolicy convert(DispatchRetentionPolicyDto dto) {
    if (null == dto) {
      return null;
    }
    return DispatchRetentionPolicyImpl.builder()
        .setTtlDays(null != dto.getTtlDays() ? dto.getTtlDays().intValue() : null)
        .build();
  }

  private static ProcessingModeType convert(ProcessingModeDto dto) {
    if (null == dto) {
      return null;
    }
    return ProcessingModeType.from(dto.getValue());
  }

  private static SmartConversation convert(SmartConversationDto dto) {
    if (null == dto) {
      return null;
    }
    return SmartConversation.builder().setEnabled(dto.getEnabled()).build();
  }

  private static SmartConversationDto convert(SmartConversationImpl client) {
    if (null == client) {
      return null;
    }
    SmartConversationDto dto = new SmartConversationDto();
    client.enabled().ifPresent(dto::setEnabled);
    return dto;
  }

  private static QueueStats convert(QueueStatsDto dto) {
    if (null == dto) {
      return null;
    }
    return QueueStats.builder()
        .setOutboundSize(dto.getOutboundSize())
        .setOutboundLimit(dto.getOutboundLimit())
        .build();
  }

  private static PersistMessageStatus convert(AppResponsePersistMessageStatusDto dto) {
    if (null == dto) {
      return null;
    }
    return PersistMessageStatus.builder().setEnabled(dto.getEnabled()).build();
  }

  private static MessageSearch convertAsMessageSearch(AppResponsePersistMessageStatusDto dto) {
    if (null == dto) {
      return null;
    }
    return MessageSearch.builder().setEnabled(dto.getEnabled()).build();
  }

  private static CallbackSettings convert(CallbackSettingsDto dto) {
    if (null == dto) {
      return null;
    }
    return CallbackSettings.builder()
        .setSecretForOverriddenCallbackUrls(dto.getSecretForOverriddenCallbackUrls())
        .build();
  }

  private static CallbackSettingsDto convert(CallbackSettingsImpl client) {
    if (null == client) {
      return null;
    }
    CallbackSettingsDto dto = new CallbackSettingsDto();

    client.secretForOverriddenCallbackUrls().ifPresent(dto::setSecretForOverriddenCallbackUrls);
    return dto;
  }

  private static DeliveryReportBasedFallback convert(
      AppResponseDeliveryReportBasedFallbackDto dto) {
    if (null == dto) {
      return null;
    }
    return DeliveryReportBasedFallback.builder()
        .setEnabled(dto.getEnabled())
        .setDeliveryReportWaitingTime(dto.getDeliveryReportWaitingTime())
        .build();
  }
}
