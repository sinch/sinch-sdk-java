package com.sinch.sdk.domains.conversation.models.v1.app.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.app.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.v1.app.ConversationMetadataReportView;
import com.sinch.sdk.domains.conversation.models.v1.app.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.v1.app.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.app.MessageRetrySettings;
import com.sinch.sdk.domains.conversation.models.v1.app.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.app.SmartConversation;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AppResponseImpl.JSON_PROPERTY_CHANNEL_CREDENTIALS,
  AppResponseImpl.JSON_PROPERTY_CONVERSATION_METADATA_REPORT_VIEW,
  AppResponseImpl.JSON_PROPERTY_DISPLAY_NAME,
  AppResponseImpl.JSON_PROPERTY_ID,
  AppResponseImpl.JSON_PROPERTY_RATE_LIMITS,
  AppResponseImpl.JSON_PROPERTY_RETENTION_POLICY,
  AppResponseImpl.JSON_PROPERTY_DISPATCH_RETENTION_POLICY,
  AppResponseImpl.JSON_PROPERTY_PROCESSING_MODE,
  AppResponseImpl.JSON_PROPERTY_SMART_CONVERSATION,
  AppResponseImpl.JSON_PROPERTY_QUEUE_STATS,
  AppResponseImpl.JSON_PROPERTY_CALLBACK_SETTINGS,
  AppResponseImpl.JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK,
  AppResponseImpl.JSON_PROPERTY_MESSAGE_RETRY_SETTINGS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppResponseImpl implements AppResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_CREDENTIALS = "channel_credentials";

  private OptionalValue<List<ConversationChannelCredentials>> channelCredentials;

  public static final String JSON_PROPERTY_CONVERSATION_METADATA_REPORT_VIEW =
      "conversation_metadata_report_view";

  private OptionalValue<ConversationMetadataReportView> conversationMetadataReportView;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_RATE_LIMITS = "rate_limits";

  private OptionalValue<RateLimits> rateLimits;

  public static final String JSON_PROPERTY_RETENTION_POLICY = "retention_policy";

  private OptionalValue<RetentionPolicy> retentionPolicy;

  public static final String JSON_PROPERTY_DISPATCH_RETENTION_POLICY = "dispatch_retention_policy";

  private OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<String> processingMode;

  public static final String JSON_PROPERTY_SMART_CONVERSATION = "smart_conversation";

  private OptionalValue<SmartConversation> smartConversation;

  public static final String JSON_PROPERTY_QUEUE_STATS = "queue_stats";

  private OptionalValue<QueueStats> queueStats;

  public static final String JSON_PROPERTY_CALLBACK_SETTINGS = "callback_settings";

  private OptionalValue<CallbackSettings> callbackSettings;

  public static final String JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK =
      "delivery_report_based_fallback";

  private OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback;

  public static final String JSON_PROPERTY_MESSAGE_RETRY_SETTINGS = "message_retry_settings";

  private OptionalValue<MessageRetrySettings> messageRetrySettings;

  public AppResponseImpl() {}

  protected AppResponseImpl(
      OptionalValue<List<ConversationChannelCredentials>> channelCredentials,
      OptionalValue<ConversationMetadataReportView> conversationMetadataReportView,
      OptionalValue<String> displayName,
      OptionalValue<String> id,
      OptionalValue<RateLimits> rateLimits,
      OptionalValue<RetentionPolicy> retentionPolicy,
      OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy,
      OptionalValue<String> processingMode,
      OptionalValue<SmartConversation> smartConversation,
      OptionalValue<QueueStats> queueStats,
      OptionalValue<CallbackSettings> callbackSettings,
      OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback,
      OptionalValue<MessageRetrySettings> messageRetrySettings) {
    this.channelCredentials = channelCredentials;
    this.conversationMetadataReportView = conversationMetadataReportView;
    this.displayName = displayName;
    this.id = id;
    this.rateLimits = rateLimits;
    this.retentionPolicy = retentionPolicy;
    this.dispatchRetentionPolicy = dispatchRetentionPolicy;
    this.processingMode = processingMode;
    this.smartConversation = smartConversation;
    this.queueStats = queueStats;
    this.callbackSettings = callbackSettings;
    this.deliveryReportBasedFallback = deliveryReportBasedFallback;
    this.messageRetrySettings = messageRetrySettings;
  }

  @JsonIgnore
  public List<ConversationChannelCredentials> getChannelCredentials() {
    return channelCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationChannelCredentials>> channelCredentials() {
    return channelCredentials;
  }

  @JsonIgnore
  public ConversationMetadataReportView getConversationMetadataReportView() {
    return conversationMetadataReportView.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_METADATA_REPORT_VIEW)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationMetadataReportView> conversationMetadataReportView() {
    return conversationMetadataReportView;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public RateLimits getRateLimits() {
    return rateLimits.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RATE_LIMITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RateLimits> rateLimits() {
    return rateLimits;
  }

  @JsonIgnore
  public RetentionPolicy getRetentionPolicy() {
    return retentionPolicy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RETENTION_POLICY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RetentionPolicy> retentionPolicy() {
    return retentionPolicy;
  }

  @JsonIgnore
  public DispatchRetentionPolicy getDispatchRetentionPolicy() {
    return dispatchRetentionPolicy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPATCH_RETENTION_POLICY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy() {
    return dispatchRetentionPolicy;
  }

  @JsonIgnore
  public String getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> processingMode() {
    return processingMode;
  }

  @JsonIgnore
  public SmartConversation getSmartConversation() {
    return smartConversation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMART_CONVERSATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SmartConversation> smartConversation() {
    return smartConversation;
  }

  @JsonIgnore
  public QueueStats getQueueStats() {
    return queueStats.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUEUE_STATS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<QueueStats> queueStats() {
    return queueStats;
  }

  @JsonIgnore
  public CallbackSettings getCallbackSettings() {
    return callbackSettings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallbackSettings> callbackSettings() {
    return callbackSettings;
  }

  @JsonIgnore
  public DeliveryReportBasedFallback getDeliveryReportBasedFallback() {
    return deliveryReportBasedFallback.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback() {
    return deliveryReportBasedFallback;
  }

  @JsonIgnore
  public MessageRetrySettings getMessageRetrySettings() {
    return messageRetrySettings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_RETRY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageRetrySettings> messageRetrySettings() {
    return messageRetrySettings;
  }

  /** Return true if this AppResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppResponseImpl appResponse = (AppResponseImpl) o;
    return Objects.equals(this.channelCredentials, appResponse.channelCredentials)
        && Objects.equals(
            this.conversationMetadataReportView, appResponse.conversationMetadataReportView)
        && Objects.equals(this.displayName, appResponse.displayName)
        && Objects.equals(this.id, appResponse.id)
        && Objects.equals(this.rateLimits, appResponse.rateLimits)
        && Objects.equals(this.retentionPolicy, appResponse.retentionPolicy)
        && Objects.equals(this.dispatchRetentionPolicy, appResponse.dispatchRetentionPolicy)
        && Objects.equals(this.processingMode, appResponse.processingMode)
        && Objects.equals(this.smartConversation, appResponse.smartConversation)
        && Objects.equals(this.queueStats, appResponse.queueStats)
        && Objects.equals(this.callbackSettings, appResponse.callbackSettings)
        && Objects.equals(this.deliveryReportBasedFallback, appResponse.deliveryReportBasedFallback)
        && Objects.equals(this.messageRetrySettings, appResponse.messageRetrySettings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channelCredentials,
        conversationMetadataReportView,
        displayName,
        id,
        rateLimits,
        retentionPolicy,
        dispatchRetentionPolicy,
        processingMode,
        smartConversation,
        queueStats,
        callbackSettings,
        deliveryReportBasedFallback,
        messageRetrySettings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppResponseImpl {\n");
    sb.append("    channelCredentials: ").append(toIndentedString(channelCredentials)).append("\n");
    sb.append("    conversationMetadataReportView: ")
        .append(toIndentedString(conversationMetadataReportView))
        .append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rateLimits: ").append(toIndentedString(rateLimits)).append("\n");
    sb.append("    retentionPolicy: ").append(toIndentedString(retentionPolicy)).append("\n");
    sb.append("    dispatchRetentionPolicy: ")
        .append(toIndentedString(dispatchRetentionPolicy))
        .append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
    sb.append("    smartConversation: ").append(toIndentedString(smartConversation)).append("\n");
    sb.append("    queueStats: ").append(toIndentedString(queueStats)).append("\n");
    sb.append("    callbackSettings: ").append(toIndentedString(callbackSettings)).append("\n");
    sb.append("    deliveryReportBasedFallback: ")
        .append(toIndentedString(deliveryReportBasedFallback))
        .append("\n");
    sb.append("    messageRetrySettings: ")
        .append(toIndentedString(messageRetrySettings))
        .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements AppResponse.Builder {
    OptionalValue<List<ConversationChannelCredentials>> channelCredentials = OptionalValue.empty();
    OptionalValue<ConversationMetadataReportView> conversationMetadataReportView =
        OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<RateLimits> rateLimits = OptionalValue.empty();
    OptionalValue<RetentionPolicy> retentionPolicy = OptionalValue.empty();
    OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy = OptionalValue.empty();
    OptionalValue<String> processingMode = OptionalValue.empty();
    OptionalValue<SmartConversation> smartConversation = OptionalValue.empty();
    OptionalValue<QueueStats> queueStats = OptionalValue.empty();
    OptionalValue<CallbackSettings> callbackSettings = OptionalValue.empty();
    OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback = OptionalValue.empty();
    OptionalValue<MessageRetrySettings> messageRetrySettings = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_CREDENTIALS)
    public Builder setChannelCredentials(List<ConversationChannelCredentials> channelCredentials) {
      this.channelCredentials = OptionalValue.of(channelCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_METADATA_REPORT_VIEW)
    public Builder setConversationMetadataReportView(
        ConversationMetadataReportView conversationMetadataReportView) {
      this.conversationMetadataReportView = OptionalValue.of(conversationMetadataReportView);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RATE_LIMITS)
    public Builder setRateLimits(RateLimits rateLimits) {
      this.rateLimits = OptionalValue.of(rateLimits);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RETENTION_POLICY)
    public Builder setRetentionPolicy(RetentionPolicy retentionPolicy) {
      this.retentionPolicy = OptionalValue.of(retentionPolicy);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISPATCH_RETENTION_POLICY)
    public Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy) {
      this.dispatchRetentionPolicy = OptionalValue.of(dispatchRetentionPolicy);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(String processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMART_CONVERSATION)
    public Builder setSmartConversation(SmartConversation smartConversation) {
      this.smartConversation = OptionalValue.of(smartConversation);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_QUEUE_STATS)
    public Builder setQueueStats(QueueStats queueStats) {
      this.queueStats = OptionalValue.of(queueStats);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_SETTINGS)
    public Builder setCallbackSettings(CallbackSettings callbackSettings) {
      this.callbackSettings = OptionalValue.of(callbackSettings);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK)
    public Builder setDeliveryReportBasedFallback(
        DeliveryReportBasedFallback deliveryReportBasedFallback) {
      this.deliveryReportBasedFallback = OptionalValue.of(deliveryReportBasedFallback);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_RETRY_SETTINGS)
    public Builder setMessageRetrySettings(MessageRetrySettings messageRetrySettings) {
      this.messageRetrySettings = OptionalValue.of(messageRetrySettings);
      return this;
    }

    public AppResponse build() {
      return new AppResponseImpl(
          channelCredentials,
          conversationMetadataReportView,
          displayName,
          id,
          rateLimits,
          retentionPolicy,
          dispatchRetentionPolicy,
          processingMode,
          smartConversation,
          queueStats,
          callbackSettings,
          deliveryReportBasedFallback,
          messageRetrySettings);
    }
  }
}
