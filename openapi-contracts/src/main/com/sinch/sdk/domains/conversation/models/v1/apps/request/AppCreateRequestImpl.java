package com.sinch.sdk.domains.conversation.models.v1.apps.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.apps.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.v1.apps.ConversationMetadataReportView;
import com.sinch.sdk.domains.conversation.models.v1.apps.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.v1.apps.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.apps.MessageRetrySettings;
import com.sinch.sdk.domains.conversation.models.v1.apps.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.apps.SmartConversation;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AppCreateRequestImpl.JSON_PROPERTY_CHANNEL_CREDENTIALS,
  AppCreateRequestImpl.JSON_PROPERTY_CONVERSATION_METADATA_REPORT_VIEW,
  AppCreateRequestImpl.JSON_PROPERTY_DISPLAY_NAME,
  AppCreateRequestImpl.JSON_PROPERTY_RETENTION_POLICY,
  AppCreateRequestImpl.JSON_PROPERTY_DISPATCH_RETENTION_POLICY,
  AppCreateRequestImpl.JSON_PROPERTY_PROCESSING_MODE,
  AppCreateRequestImpl.JSON_PROPERTY_SMART_CONVERSATION,
  AppCreateRequestImpl.JSON_PROPERTY_CALLBACK_SETTINGS,
  AppCreateRequestImpl.JSON_PROPERTY_MESSAGE_RETRY_SETTINGS,
  AppCreateRequestImpl.JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppCreateRequestImpl implements AppCreateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_CREDENTIALS = "channel_credentials";

  private OptionalValue<List<ConversationChannelCredentials>> channelCredentials;

  public static final String JSON_PROPERTY_CONVERSATION_METADATA_REPORT_VIEW =
      "conversation_metadata_report_view";

  private OptionalValue<ConversationMetadataReportView> conversationMetadataReportView;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_RETENTION_POLICY = "retention_policy";

  private OptionalValue<RetentionPolicy> retentionPolicy;

  public static final String JSON_PROPERTY_DISPATCH_RETENTION_POLICY = "dispatch_retention_policy";

  private OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public static final String JSON_PROPERTY_SMART_CONVERSATION = "smart_conversation";

  private OptionalValue<SmartConversation> smartConversation;

  public static final String JSON_PROPERTY_CALLBACK_SETTINGS = "callback_settings";

  private OptionalValue<CallbackSettings> callbackSettings;

  public static final String JSON_PROPERTY_MESSAGE_RETRY_SETTINGS = "message_retry_settings";

  private OptionalValue<MessageRetrySettings> messageRetrySettings;

  public static final String JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK =
      "delivery_report_based_fallback";

  private OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback;

  public AppCreateRequestImpl() {}

  protected AppCreateRequestImpl(
      OptionalValue<List<ConversationChannelCredentials>> channelCredentials,
      OptionalValue<ConversationMetadataReportView> conversationMetadataReportView,
      OptionalValue<String> displayName,
      OptionalValue<RetentionPolicy> retentionPolicy,
      OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy,
      OptionalValue<ProcessingMode> processingMode,
      OptionalValue<SmartConversation> smartConversation,
      OptionalValue<CallbackSettings> callbackSettings,
      OptionalValue<MessageRetrySettings> messageRetrySettings,
      OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback) {
    this.channelCredentials = channelCredentials;
    this.conversationMetadataReportView = conversationMetadataReportView;
    this.displayName = displayName;
    this.retentionPolicy = retentionPolicy;
    this.dispatchRetentionPolicy = dispatchRetentionPolicy;
    this.processingMode = processingMode;
    this.smartConversation = smartConversation;
    this.callbackSettings = callbackSettings;
    this.messageRetrySettings = messageRetrySettings;
    this.deliveryReportBasedFallback = deliveryReportBasedFallback;
  }

  @JsonIgnore
  public List<ConversationChannelCredentials> getChannelCredentials() {
    return channelCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> displayName() {
    return displayName;
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
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
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
  public CallbackSettings getCallbackSettings() {
    return callbackSettings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallbackSettings> callbackSettings() {
    return callbackSettings;
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

  @JsonIgnore
  public DeliveryReportBasedFallback getDeliveryReportBasedFallback() {
    return deliveryReportBasedFallback.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback() {
    return deliveryReportBasedFallback;
  }

  /** Return true if this AppCreateRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppCreateRequestImpl appCreateRequest = (AppCreateRequestImpl) o;
    return Objects.equals(this.channelCredentials, appCreateRequest.channelCredentials)
        && Objects.equals(
            this.conversationMetadataReportView, appCreateRequest.conversationMetadataReportView)
        && Objects.equals(this.displayName, appCreateRequest.displayName)
        && Objects.equals(this.retentionPolicy, appCreateRequest.retentionPolicy)
        && Objects.equals(this.dispatchRetentionPolicy, appCreateRequest.dispatchRetentionPolicy)
        && Objects.equals(this.processingMode, appCreateRequest.processingMode)
        && Objects.equals(this.smartConversation, appCreateRequest.smartConversation)
        && Objects.equals(this.callbackSettings, appCreateRequest.callbackSettings)
        && Objects.equals(this.messageRetrySettings, appCreateRequest.messageRetrySettings)
        && Objects.equals(
            this.deliveryReportBasedFallback, appCreateRequest.deliveryReportBasedFallback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channelCredentials,
        conversationMetadataReportView,
        displayName,
        retentionPolicy,
        dispatchRetentionPolicy,
        processingMode,
        smartConversation,
        callbackSettings,
        messageRetrySettings,
        deliveryReportBasedFallback);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppCreateRequestImpl {\n");
    sb.append("    channelCredentials: ").append(toIndentedString(channelCredentials)).append("\n");
    sb.append("    conversationMetadataReportView: ")
        .append(toIndentedString(conversationMetadataReportView))
        .append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    retentionPolicy: ").append(toIndentedString(retentionPolicy)).append("\n");
    sb.append("    dispatchRetentionPolicy: ")
        .append(toIndentedString(dispatchRetentionPolicy))
        .append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
    sb.append("    smartConversation: ").append(toIndentedString(smartConversation)).append("\n");
    sb.append("    callbackSettings: ").append(toIndentedString(callbackSettings)).append("\n");
    sb.append("    messageRetrySettings: ")
        .append(toIndentedString(messageRetrySettings))
        .append("\n");
    sb.append("    deliveryReportBasedFallback: ")
        .append(toIndentedString(deliveryReportBasedFallback))
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
  static class Builder implements AppCreateRequest.Builder {
    OptionalValue<List<ConversationChannelCredentials>> channelCredentials = OptionalValue.empty();
    OptionalValue<ConversationMetadataReportView> conversationMetadataReportView =
        OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<RetentionPolicy> retentionPolicy = OptionalValue.empty();
    OptionalValue<DispatchRetentionPolicy> dispatchRetentionPolicy = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();
    OptionalValue<SmartConversation> smartConversation = OptionalValue.empty();
    OptionalValue<CallbackSettings> callbackSettings = OptionalValue.empty();
    OptionalValue<MessageRetrySettings> messageRetrySettings = OptionalValue.empty();
    OptionalValue<DeliveryReportBasedFallback> deliveryReportBasedFallback = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CHANNEL_CREDENTIALS, required = true)
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

    @JsonProperty(value = JSON_PROPERTY_DISPLAY_NAME, required = true)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
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
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMART_CONVERSATION)
    public Builder setSmartConversation(SmartConversation smartConversation) {
      this.smartConversation = OptionalValue.of(smartConversation);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_SETTINGS)
    public Builder setCallbackSettings(CallbackSettings callbackSettings) {
      this.callbackSettings = OptionalValue.of(callbackSettings);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_RETRY_SETTINGS)
    public Builder setMessageRetrySettings(MessageRetrySettings messageRetrySettings) {
      this.messageRetrySettings = OptionalValue.of(messageRetrySettings);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DELIVERY_REPORT_BASED_FALLBACK)
    public Builder setDeliveryReportBasedFallback(
        DeliveryReportBasedFallback deliveryReportBasedFallback) {
      this.deliveryReportBasedFallback = OptionalValue.of(deliveryReportBasedFallback);
      return this;
    }

    public AppCreateRequest build() {
      return new AppCreateRequestImpl(
          channelCredentials,
          conversationMetadataReportView,
          displayName,
          retentionPolicy,
          dispatchRetentionPolicy,
          processingMode,
          smartConversation,
          callbackSettings,
          messageRetrySettings,
          deliveryReportBasedFallback);
    }
  }
}
