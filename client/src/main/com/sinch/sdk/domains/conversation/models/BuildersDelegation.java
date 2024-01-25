package com.sinch.sdk.domains.conversation.models;

class BuildersDelegation {

  static RetentionPolicy.Builder RetentionPolicyBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.RetentionPolicyBuilder();
  }

  static SmartConversation.Builder SmartConversationBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.SmartConversationBuilder();
  }

  static RateLimits.Builder RateLimitsBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.RateLimitsBuilder();
  }

  static QueueStats.Builder QueueStatsBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.QueueStatsBuilder();
  }

  static PersistMessageStatus.Builder PersistMessageStatusBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.PersistMessageStatusBuilder();
  }

  static MessageSearch.Builder MessageSearchBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.MessageSearchBuilder();
  }

  static DispatchRetentionPolicy.Builder DispatchRetentionPolicyBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.DispatchRetentionPolicyBuilder();
  }

  static DeliveryReportBasedFallback.Builder DeliveryReportBasedFallbackBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders
        .DeliveryReportBasedFallbackBuilder();
  }

  static CallbackSettings.Builder CallbackSettingsBuilder() {
    return com.sinch.sdk.domains.conversation.adapters.AppBuilders.CallbackSettingsBuilder();
  }
}
