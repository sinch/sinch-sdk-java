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
import com.sinch.sdk.domains.conversation.adapters.models.responses.AppImpl;
import com.sinch.sdk.domains.conversation.models.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.MessageSearch;
import com.sinch.sdk.domains.conversation.models.PersistMessageStatus;
import com.sinch.sdk.domains.conversation.models.QueueStats;
import com.sinch.sdk.domains.conversation.models.RateLimits;
import com.sinch.sdk.domains.conversation.models.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.SmartConversation;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.App;

public class AppBuilders {

  public static RetentionPolicy.Builder RetentionPolicyBuilder() {
    return new RetentionPolicyImpl.Builder();
  }

  public static SmartConversation.Builder SmartConversationBuilder() {
    return new SmartConversationImpl.Builder();
  }

  public static RateLimits.Builder RateLimitsBuilder() {
    return new RateLimitsImpl.Builder();
  }

  public static QueueStats.Builder QueueStatsBuilder() {
    return new QueueStatsImpl.Builder();
  }

  public static PersistMessageStatus.Builder PersistMessageStatusBuilder() {
    return new PersistMessageStatusImpl.Builder();
  }

  public static MessageSearch.Builder MessageSearchBuilder() {
    return new MessageSearchImpl.Builder();
  }

  public static DispatchRetentionPolicy.Builder DispatchRetentionPolicyBuilder() {
    return new DispatchRetentionPolicyImpl.Builder();
  }

  public static DeliveryReportBasedFallback.Builder DeliveryReportBasedFallbackBuilder() {
    return new DeliveryReportBasedFallbackImpl.Builder();
  }

  public static CallbackSettings.Builder CallbackSettingsBuilder() {
    return CallbackSettingsImpl.builder();
  }

  public static AppRequestParameters.Builder AppRequestParametersBuilder() {
    return AppRequestParametersImpl.builder();
  }

  public static App.Builder AppBuilder() {
    return AppImpl.builder();
  }
}
