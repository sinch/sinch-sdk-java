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
import com.sinch.sdk.domains.conversation.models.credentials.Credentials;
import com.sinch.sdk.domains.conversation.models.responses.App;
import java.util.Collection;

/** Object to be used to create or update App */
public interface AppRequestParameters {

  /**
   * App channel credentials
   *
   * @return Channel credential list
   * @since 1.0
   * @see App#getChannelCredentials()
   */
  OptionalValue<Collection<ConversationChannel<? extends Credentials>>> getChannelCredentials();

  /**
   * Report View Type
   *
   * @return Report View Type
   * @since 1.0
   * @see App#getMetadataReportView()
   */
  OptionalValue<ConversationMetadataReportViewType> getMetadataReportView();

  /**
   * Display name
   *
   * @return Display name
   * @since 1.0
   * @see App#getDisplayName()
   */
  OptionalValue<String> getDisplayName();

  /**
   * Retention policy
   *
   * @return retention policy
   * @since 1.0
   * @see App#getRetentionPolicy()
   */
  OptionalValue<? extends RetentionPolicy> getRetentionPolicy();

  /**
   * Dispatch retention policy
   *
   * @return retention policy
   * @since 1.0
   * @see App#getDispatchRetentionPolicy()
   */
  OptionalValue<? extends DispatchRetentionPolicy> getDispatchRetentionPolicy();

  /**
   * Processing mode
   *
   * @return processing mode
   * @since 1.0
   * @see App#getProcessingMode()
   */
  OptionalValue<ProcessingModeType> getProcessingMode();

  /**
   * smart conversation information
   *
   * @return smart conversation information
   * @since 1.0
   * @see App#getSmartConversation()
   */
  OptionalValue<? extends SmartConversation> getSmartConversation();

  /**
   * callback setting
   *
   * @return callback setting
   * @since 1.0
   * @see App#getCallbackSettings()
   */
  OptionalValue<? extends CallbackSettings> getCallbackSettings();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.AppRequestParametersBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder {

    /**
     * see getter
     *
     * @param channelCredentials see getter
     * @return Current builder
     * @see #getChannelCredentials()
     * @since 1.0
     */
    Builder setChannelCredentials(
        Collection<ConversationChannel<? extends Credentials>> channelCredentials);

    /**
     * see getter
     *
     * @param metadataReportView see getter
     * @return Current builder
     * @see #getMetadataReportView()
     * @since 1.0
     */
    Builder setMetadataReportView(ConversationMetadataReportViewType metadataReportView);

    /**
     * see getter
     *
     * @param displayName see getter
     * @return Current builder
     * @see #getDisplayName()
     * @since 1.0
     */
    Builder setDisplayName(String displayName);

    /**
     * see getter
     *
     * @param retentionPolicy see getter
     * @return Current builder
     * @see #getRetentionPolicy()
     * @since 1.0
     */
    Builder setRetentionPolicy(RetentionPolicy retentionPolicy);

    /**
     * see getter
     *
     * @param dispatchRetentionPolicy see getter
     * @return Current builder
     * @see #getDispatchRetentionPolicy()
     * @since 1.0
     */
    Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see #getProcessingMode()
     * @since 1.0
     */
    Builder setProcessingMode(ProcessingModeType processingMode);

    /**
     * see getter
     *
     * @param smartConversation see getter
     * @return Current builder
     * @see #getSmartConversation()
     * @since 1.0
     */
    Builder setSmartConversation(SmartConversation smartConversation);

    /**
     * see getter
     *
     * @param callbackSettings see getter
     * @return Current builder
     * @see #getCallbackSettings()
     * @since 1.0
     */
    Builder setCallbackSettings(CallbackSettings callbackSettings);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    AppRequestParameters build();
  }
}
