package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import com.sinch.sdk.domains.conversation.models.responses.App;
import java.util.function.Supplier;

public class BuildersDelegation {

  private BuildersDelegation() {}

  private static class LazyHolder {

    public static final Supplier<RetentionPolicy.Builder> RETENTION_POLICY_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::RetentionPolicyBuilder;
    public static final Supplier<SmartConversation.Builder> SMART_CONVERSATION_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::SmartConversationBuilder;
    public static final Supplier<RateLimits.Builder> RATE_LIMITS_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::RateLimitsBuilder;
    public static final Supplier<QueueStats.Builder> QUEUE_STATS_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::QueueStatsBuilder;
    public static final Supplier<PersistMessageStatus.Builder> PERSIST_MESSAGE_STATUS_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::PersistMessageStatusBuilder;
    public static final Supplier<MessageSearch.Builder> MESSAGE_SEARCH_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::MessageSearchBuilder;
    public static final Supplier<DispatchRetentionPolicy.Builder>
        DISPATCH_RETENTION_POLICY_BUILDER =
            com.sinch.sdk.domains.conversation.adapters.AppBuilders::DispatchRetentionPolicyBuilder;
    public static final Supplier<DeliveryReportBasedFallback.Builder>
        DELIVERY_REPORT_BASED_FALLBACK_BUILDER =
            com.sinch.sdk.domains.conversation.adapters.AppBuilders
                ::DeliveryReportBasedFallbackBuilder;
    public static final Supplier<CallbackSettings.Builder> CALLBACK_SETTINGS_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::CallbackSettingsBuilder;

    public static final Supplier<AppRequestParameters.Builder> APP_REQUEST_PARAMETERS_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::AppRequestParametersBuilder;
    public static final Supplier<App.Builder> APP_BUILDER =
        com.sinch.sdk.domains.conversation.adapters.AppBuilders::AppBuilder;

  }

  static RetentionPolicy.Builder RetentionPolicyBuilder() {
    return LazyHolder.RETENTION_POLICY_BUILDER.get();
  }

  static SmartConversation.Builder SmartConversationBuilder() {
    return LazyHolder.SMART_CONVERSATION_BUILDER.get();
  }

  static RateLimits.Builder RateLimitsBuilder() {
    return LazyHolder.RATE_LIMITS_BUILDER.get();
  }

  static QueueStats.Builder QueueStatsBuilder() {
    return LazyHolder.QUEUE_STATS_BUILDER.get();
  }

  static PersistMessageStatus.Builder PersistMessageStatusBuilder() {
    return LazyHolder.PERSIST_MESSAGE_STATUS_BUILDER.get();
  }

  static MessageSearch.Builder MessageSearchBuilder() {
    return LazyHolder.MESSAGE_SEARCH_BUILDER.get();
  }

  static DispatchRetentionPolicy.Builder DispatchRetentionPolicyBuilder() {
    return LazyHolder.DISPATCH_RETENTION_POLICY_BUILDER.get();
  }

  static DeliveryReportBasedFallback.Builder DeliveryReportBasedFallbackBuilder() {
    return LazyHolder.DELIVERY_REPORT_BASED_FALLBACK_BUILDER.get();
  }

  static CallbackSettings.Builder CallbackSettingsBuilder() {
    return LazyHolder.CALLBACK_SETTINGS_BUILDER.get();
  }

  public static AppRequestParameters.Builder AppRequestParametersBuilder() {
    return LazyHolder.APP_REQUEST_PARAMETERS_BUILDER.get();
  }

  public static App.Builder AppBuilder() {
    return LazyHolder.APP_BUILDER.get();
  }

  public interface AppBuilders {

    static RetentionPolicy.Builder RetentionPolicyBuilder() {
      return null;
    }

    static SmartConversation.Builder SmartConversationBuilder() {
      return null;
    }

    static RateLimits.Builder RateLimitsBuilder() {
      return null;
    }

    static QueueStats.Builder QueueStatsBuilder() {
      return null;
    }

    static PersistMessageStatus.Builder PersistMessageStatusBuilder() {
      return null;
    }

    static MessageSearch.Builder MessageSearchBuilder() {
      return null;
    }

    static DispatchRetentionPolicy.Builder DispatchRetentionPolicyBuilder() {
      return null;
    }

    static DeliveryReportBasedFallback.Builder DeliveryReportBasedFallbackBuilder() {
      return null;
    }

    static CallbackSettings.Builder CallbackSettingsBuilder() {
      return null;
    }

    static AppRequestParameters.Builder AppRequestParametersBuilder() {
      return null;
    }

    static App.Builder AppBuilder() {
      return null;
    }
  }
}
