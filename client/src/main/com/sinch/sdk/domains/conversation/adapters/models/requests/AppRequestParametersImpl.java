package com.sinch.sdk.domains.conversation.adapters.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.adapters.models.CallbackSettingsImpl;
import com.sinch.sdk.domains.conversation.adapters.models.DispatchRetentionPolicyImpl;
import com.sinch.sdk.domains.conversation.adapters.models.RetentionPolicyImpl;
import com.sinch.sdk.domains.conversation.adapters.models.SmartConversationImpl;
import com.sinch.sdk.domains.conversation.models.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.ConversationMetadataReportViewType;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.ProcessingModeType;
import com.sinch.sdk.domains.conversation.models.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.SmartConversation;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import java.util.Collection;
import java.util.Collections;

public class AppRequestParametersImpl implements AppRequestParameters {

  private final OptionalValue<Collection<ConversationChannel<?>>> channelCredentials;
  private final OptionalValue<ConversationMetadataReportViewType> metadataReportView;
  private final OptionalValue<String> displayName;
  private final OptionalValue<RetentionPolicyImpl> retentionPolicy;
  private final OptionalValue<DispatchRetentionPolicyImpl> dispatchRetentionPolicy;
  private final OptionalValue<ProcessingModeType> processingMode;
  private final OptionalValue<SmartConversationImpl> smartConversation;
  private final OptionalValue<CallbackSettingsImpl> callbackSettings;

  private AppRequestParametersImpl(
      OptionalValue<Collection<ConversationChannel<?>>> channelCredentials,
      OptionalValue<ConversationMetadataReportViewType> metadataReportView,
      OptionalValue<String> displayName,
      OptionalValue<RetentionPolicyImpl> retentionPolicy,
      OptionalValue<DispatchRetentionPolicyImpl> dispatchRetentionPolicy,
      OptionalValue<ProcessingModeType> processingMode,
      OptionalValue<SmartConversationImpl> smartConversation,
      OptionalValue<CallbackSettingsImpl> callbackSettings) {
    this.channelCredentials = channelCredentials;
    this.metadataReportView = metadataReportView;
    this.displayName = displayName;
    this.retentionPolicy = retentionPolicy;
    this.dispatchRetentionPolicy = dispatchRetentionPolicy;
    this.processingMode = processingMode;
    this.smartConversation = smartConversation;
    this.callbackSettings = callbackSettings;
  }

  public OptionalValue<Collection<ConversationChannel<?>>> getChannelCredentials() {
    return channelCredentials;
  }

  public OptionalValue<ConversationMetadataReportViewType> getMetadataReportView() {
    return metadataReportView;
  }

  public OptionalValue<String> getDisplayName() {
    return displayName;
  }

  public OptionalValue<RetentionPolicyImpl> getRetentionPolicy() {
    return retentionPolicy;
  }

  public OptionalValue<DispatchRetentionPolicyImpl> getDispatchRetentionPolicy() {
    return dispatchRetentionPolicy;
  }

  public OptionalValue<ProcessingModeType> getProcessingMode() {
    return processingMode;
  }

  public OptionalValue<SmartConversationImpl> getSmartConversation() {
    return smartConversation;
  }

  public OptionalValue<CallbackSettingsImpl> getCallbackSettings() {
    return callbackSettings;
  }

  @Override
  public String toString() {
    return "AppRequestParameters{"
        + "channelCredentials="
        + channelCredentials
        + ", metadataReportView="
        + metadataReportView
        + ", displayName="
        + displayName
        + ", retentionPolicy="
        + retentionPolicy
        + ", dispatchRetentionPolicy="
        + dispatchRetentionPolicy
        + ", processingMode="
        + processingMode
        + ", smartConversation="
        + smartConversation
        + ", callbackSettings="
        + callbackSettings
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements AppRequestParameters.Builder {

    OptionalValue<Collection<ConversationChannel<?>>> channelCredentials = OptionalValue.empty();
    OptionalValue<ConversationMetadataReportViewType> metadataReportView = OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<RetentionPolicyImpl> retentionPolicy = OptionalValue.empty();
    OptionalValue<DispatchRetentionPolicyImpl> dispatchRetentionPolicy = OptionalValue.empty();
    OptionalValue<ProcessingModeType> processingMode = OptionalValue.empty();
    OptionalValue<SmartConversationImpl> smartConversation = OptionalValue.empty();
    OptionalValue<CallbackSettingsImpl> callbackSettings = OptionalValue.empty();

    public Builder setChannelCredentials(Collection<ConversationChannel<?>> channelCredentials) {
      this.channelCredentials =
          OptionalValue.of(
              null != channelCredentials
                  ? Collections.unmodifiableCollection(channelCredentials)
                  : null);
      return this;
    }

    public Builder setMetadataReportView(ConversationMetadataReportViewType metadataReportView) {
      this.metadataReportView = OptionalValue.of(metadataReportView);
      return this;
    }

    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    public Builder setRetentionPolicy(RetentionPolicy retentionPolicy) {
      this.retentionPolicy = OptionalValue.of((RetentionPolicyImpl) retentionPolicy);
      return this;
    }

    public Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy) {
      this.dispatchRetentionPolicy =
          OptionalValue.of((DispatchRetentionPolicyImpl) dispatchRetentionPolicy);
      return this;
    }

    public Builder setProcessingMode(ProcessingModeType processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public Builder setSmartConversation(SmartConversation smartConversation) {
      this.smartConversation = OptionalValue.of((SmartConversationImpl) smartConversation);
      return this;
    }

    public Builder setCallbackSettings(CallbackSettings callbackSettings) {
      this.callbackSettings = OptionalValue.of((CallbackSettingsImpl) callbackSettings);
      return this;
    }

    public AppRequestParameters build() {
      return new AppRequestParametersImpl(
          channelCredentials,
          metadataReportView,
          displayName,
          retentionPolicy,
          dispatchRetentionPolicy,
          processingMode,
          smartConversation,
          callbackSettings);
    }
  }
}
