package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
import com.sinch.sdk.domains.conversation.models.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.ConversationMetadataReportViewType;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.ProcessingModeType;
import com.sinch.sdk.domains.conversation.models.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.SmartConversation;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannel;
import java.util.Collection;

public interface AppRequestParameters {

  OptionalValue<Collection<ConversationChannel>> getChannelCredentials();

  OptionalValue<ConversationMetadataReportViewType> getMetadataReportView();

  OptionalValue<String> getDisplayName();

  OptionalValue<? extends RetentionPolicy> getRetentionPolicy();

  OptionalValue<? extends DispatchRetentionPolicy> getDispatchRetentionPolicy();

  OptionalValue<ProcessingModeType> getProcessingMode();

  OptionalValue<? extends SmartConversation> getSmartConversation();

  OptionalValue<? extends CallbackSettings> getCallbackSettings();

  static Builder builder() {
    return BuildersDelegation.AppRequestParametersBuilder();
  }

  interface Builder {

    Builder setChannelCredentials(Collection<ConversationChannel> channelCredentials);

    Builder setMetadataReportView(ConversationMetadataReportViewType metadataReportView);

    Builder setDisplayName(String displayName);

    Builder setRetentionPolicy(RetentionPolicy retentionPolicy);

    Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy);

    Builder setProcessingMode(ProcessingModeType processingMode);

    Builder setSmartConversation(SmartConversation smartConversation);

    Builder setCallbackSettings(CallbackSettings callbackSettings);

    AppRequestParameters build();
  }
}
