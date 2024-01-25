package com.sinch.sdk.domains.conversation.models.responses;

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

public class App {

  private final Collection<ConversationChannel> channelCredentials;
  private final ConversationMetadataReportViewType metadataReportView;
  private final String displayName;
  private final String id;
  private final RateLimits rateLimits;
  private final RetentionPolicy retentionPolicy;
  private final DispatchRetentionPolicy dispatchRetentionPolicy;
  private final ProcessingModeType processingMode;
  private final SmartConversation smartConversation;
  private final QueueStats queueStats;
  private final PersistMessageStatus persistMessageStatus;
  private final MessageSearch messageSearch;
  private final CallbackSettings callbackSettings;
  private final DeliveryReportBasedFallback deliveryReportBasedFallback;

  // TODO private final MessageRetrySettings messageRetrySettings;

  private App(
      Collection<ConversationChannel> channelCredentials,
      ConversationMetadataReportViewType metadataReportView,
      String displayName,
      String id,
      RateLimits rateLimits,
      RetentionPolicy retentionPolicy,
      DispatchRetentionPolicy dispatchRetentionPolicy,
      ProcessingModeType processingMode,
      SmartConversation smartConversation,
      QueueStats queueStats,
      PersistMessageStatus persistMessageStatus,
      MessageSearch messageSearch,
      CallbackSettings callbackSettings,
      DeliveryReportBasedFallback deliveryReportBasedFallback) {
    this.channelCredentials = channelCredentials;
    this.metadataReportView = metadataReportView;
    this.displayName = displayName;
    this.id = id;
    this.rateLimits = rateLimits;
    this.retentionPolicy = retentionPolicy;
    this.dispatchRetentionPolicy = dispatchRetentionPolicy;
    this.processingMode = processingMode;
    this.smartConversation = smartConversation;
    this.queueStats = queueStats;
    this.persistMessageStatus = persistMessageStatus;
    this.messageSearch = messageSearch;
    this.callbackSettings = callbackSettings;
    this.deliveryReportBasedFallback = deliveryReportBasedFallback;
  }

  public Collection<ConversationChannel> getChannelCredentials() {
    return channelCredentials;
  }

  public ConversationMetadataReportViewType getMetadataReportView() {
    return metadataReportView;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getId() {
    return id;
  }

  public RateLimits getRateLimits() {
    return rateLimits;
  }

  public RetentionPolicy getRetentionPolicy() {
    return retentionPolicy;
  }

  public DispatchRetentionPolicy getDispatchRetentionPolicy() {
    return dispatchRetentionPolicy;
  }

  public ProcessingModeType getProcessingMode() {
    return processingMode;
  }

  public SmartConversation getSmartConversation() {
    return smartConversation;
  }

  public QueueStats getQueueStats() {
    return queueStats;
  }

  public PersistMessageStatus getPersistMessageStatus() {
    return persistMessageStatus;
  }

  public MessageSearch getMessageSearch() {
    return messageSearch;
  }

  public CallbackSettings getCallbackSettings() {
    return callbackSettings;
  }

  public DeliveryReportBasedFallback getDeliveryReportBasedFallback() {
    return deliveryReportBasedFallback;
  }

  @Override
  public String toString() {
    return "App{"
        + "channelCredentials="
        + channelCredentials
        + ", metadataReportView="
        + metadataReportView
        + ", displayName='"
        + displayName
        + '\''
        + ", id='"
        + id
        + '\''
        + ", rateLimits="
        + rateLimits
        + ", retentionPolicy="
        + retentionPolicy
        + ", dispatchRetentionPolicy="
        + dispatchRetentionPolicy
        + ", processingMode="
        + processingMode
        + ", smartConversation="
        + smartConversation
        + ", queueStats="
        + queueStats
        + ", persistMessageStatus="
        + persistMessageStatus
        + ", messageSearch="
        + messageSearch
        + ", callbackSettings="
        + callbackSettings
        + ", deliveryReportBasedFallback="
        + deliveryReportBasedFallback
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    Collection<ConversationChannel> channelCredentials;
    ConversationMetadataReportViewType metadataReportView;
    String displayName;
    String id;
    RateLimits rateLimits;
    RetentionPolicy retentionPolicy;
    DispatchRetentionPolicy dispatchRetentionPolicy;
    ProcessingModeType processingMode;
    SmartConversation smartConversation;
    QueueStats queueStats;
    PersistMessageStatus persistMessageStatus;
    MessageSearch messageSearch;
    CallbackSettings callbackSettings;
    DeliveryReportBasedFallback deliveryReportBasedFallback;

    public Builder setChannelCredentials(Collection<ConversationChannel> channelCredentials) {
      this.channelCredentials = channelCredentials;
      return this;
    }

    public Builder setMetadataReportView(ConversationMetadataReportViewType metadataReportView) {
      this.metadataReportView = metadataReportView;
      return this;
    }

    public Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setRateLimits(RateLimits rateLimits) {
      this.rateLimits = rateLimits;
      return this;
    }

    public Builder setRetentionPolicy(RetentionPolicy retentionPolicy) {
      this.retentionPolicy = retentionPolicy;
      return this;
    }

    public Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy) {
      this.dispatchRetentionPolicy = dispatchRetentionPolicy;
      return this;
    }

    public Builder setProcessingMode(ProcessingModeType processingMode) {
      this.processingMode = processingMode;
      return this;
    }

    public Builder setSmartConversation(SmartConversation smartConversation) {
      this.smartConversation = smartConversation;
      return this;
    }

    public Builder setQueueStats(QueueStats queueStats) {
      this.queueStats = queueStats;
      return this;
    }

    public Builder setPersistMessageStatus(PersistMessageStatus persistMessageStatus) {
      this.persistMessageStatus = persistMessageStatus;
      return this;
    }

    public Builder setMessageSearch(MessageSearch messageSearch) {
      this.messageSearch = messageSearch;
      return this;
    }

    public Builder setCallbackSettings(CallbackSettings callbackSettings) {
      this.callbackSettings = callbackSettings;
      return this;
    }

    public Builder setDeliveryReportBasedFallback(
        DeliveryReportBasedFallback deliveryReportBasedFallback) {
      this.deliveryReportBasedFallback = deliveryReportBasedFallback;
      return this;
    }

    public App build() {
      return new App(
          channelCredentials,
          metadataReportView,
          displayName,
          id,
          rateLimits,
          retentionPolicy,
          dispatchRetentionPolicy,
          processingMode,
          smartConversation,
          queueStats,
          persistMessageStatus,
          messageSearch,
          callbackSettings,
          deliveryReportBasedFallback);
    }
  }
}
