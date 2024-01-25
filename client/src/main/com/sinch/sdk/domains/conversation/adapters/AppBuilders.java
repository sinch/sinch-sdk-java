package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.domains.conversation.adapters.models.CallbackSettingsImpl;
import com.sinch.sdk.domains.conversation.adapters.models.DeliveryReportBasedFallbackImpl;
import com.sinch.sdk.domains.conversation.adapters.models.DispatchRetentionPolicyImpl;
import com.sinch.sdk.domains.conversation.adapters.models.MessageSearchImpl;
import com.sinch.sdk.domains.conversation.adapters.models.PersistMessageStatusImpl;
import com.sinch.sdk.domains.conversation.adapters.models.QueueStatsImpl;
import com.sinch.sdk.domains.conversation.adapters.models.RateLimitsImpl;
import com.sinch.sdk.domains.conversation.adapters.models.RetentionPolicyImpl;
import com.sinch.sdk.domains.conversation.adapters.models.SmartConversationImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.AppRequestParametersImpl;

public class AppBuilders {

  public static RetentionPolicyImpl.Builder RetentionPolicyBuilder() {
    return new RetentionPolicyImpl.Builder();
  }

  public static SmartConversationImpl.Builder SmartConversationBuilder() {
    return new SmartConversationImpl.Builder();
  }

  public static RateLimitsImpl.Builder RateLimitsBuilder() {
    return new RateLimitsImpl.Builder();
  }

  public static QueueStatsImpl.Builder QueueStatsBuilder() {
    return new QueueStatsImpl.Builder();
  }

  public static PersistMessageStatusImpl.Builder PersistMessageStatusBuilder() {
    return new PersistMessageStatusImpl.Builder();
  }

  public static MessageSearchImpl.Builder MessageSearchBuilder() {
    return new MessageSearchImpl.Builder();
  }

  public static DispatchRetentionPolicyImpl.Builder DispatchRetentionPolicyBuilder() {
    return new DispatchRetentionPolicyImpl.Builder();
  }

  public static DeliveryReportBasedFallbackImpl.Builder DeliveryReportBasedFallbackBuilder() {
    return new DeliveryReportBasedFallbackImpl.Builder();
  }

  public static CallbackSettingsImpl.Builder CallbackSettingsBuilder() {
    return CallbackSettingsImpl.builder();
  }

  public static AppRequestParametersImpl.Builder AppRequestParametersBuilder() {
    return AppRequestParametersImpl.builder();
  }
}
