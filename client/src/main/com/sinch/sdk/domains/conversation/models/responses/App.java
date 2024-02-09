package com.sinch.sdk.domains.conversation.models.responses;

import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
import com.sinch.sdk.domains.conversation.models.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.ConversationMetadataReportViewType;
import com.sinch.sdk.domains.conversation.models.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.MessageSearch;
import com.sinch.sdk.domains.conversation.models.PersistMessageStatus;
import com.sinch.sdk.domains.conversation.models.ProcessingModeType;
import com.sinch.sdk.domains.conversation.models.QueueStats;
import com.sinch.sdk.domains.conversation.models.RateLimits;
import com.sinch.sdk.domains.conversation.models.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.SmartConversation;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannel;
import java.util.Collection;

public interface App {

  Collection<ConversationChannel> getChannelCredentials();

  ConversationMetadataReportViewType getMetadataReportView();

  String getDisplayName();

  String getId();

  RateLimits getRateLimits();

  RetentionPolicy getRetentionPolicy();

  DispatchRetentionPolicy getDispatchRetentionPolicy();

  ProcessingModeType getProcessingMode();

  SmartConversation getSmartConversation();

  QueueStats getQueueStats();

  PersistMessageStatus getPersistMessageStatus();

  MessageSearch getMessageSearch();

  CallbackSettings getCallbackSettings();

  DeliveryReportBasedFallback getDeliveryReportBasedFallback();

  static Builder builder() {
    return BuildersDelegation.AppBuilder();
  }

  interface Builder {

    Builder setChannelCredentials(Collection<ConversationChannel> channelCredentials);

    Builder setMetadataReportView(ConversationMetadataReportViewType metadataReportView);

    Builder setDisplayName(String displayName);

    Builder setId(String id);

    Builder setRateLimits(RateLimits rateLimits);

    Builder setRetentionPolicy(RetentionPolicy retentionPolicy);

    Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy);

    Builder setProcessingMode(ProcessingModeType processingMode);

    Builder setSmartConversation(SmartConversation smartConversation);

    Builder setQueueStats(QueueStats queueStats);

    Builder setPersistMessageStatus(PersistMessageStatus persistMessageStatus);

    Builder setMessageSearch(MessageSearch messageSearch);

    Builder setCallbackSettings(CallbackSettings callbackSettings);

    Builder setDeliveryReportBasedFallback(DeliveryReportBasedFallback deliveryReportBasedFallback);

    App build();
  }
}
