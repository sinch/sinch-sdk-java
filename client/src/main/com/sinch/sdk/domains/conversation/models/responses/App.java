package com.sinch.sdk.domains.conversation.models.responses;

import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
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
import com.sinch.sdk.domains.conversation.models.credentials.Credentials;
import java.util.Collection;

/**
 * Apps are created and configured through the <a href
 * ="https://dashboard.sinch.com/convapi/apps">Sinch Dashboard</a>, are tied to the API user and
 * come with a set of <b>channel credentials</b> for each underlying connected channel.
 *
 * <p>The app has a list of <b>conversations</b> between itself and different contacts which share
 * the same <b>project</b>.
 *
 * <p>Webhooks, which the app is attached to, defines the destination for various events coming from
 * the Conversation API. An app has the following configurable properties:
 *
 * @since 1.0
 */
public interface App {

  /**
   * An array of channel credentials.
   *
   * <p>The order of the credentials defines the app channel priority.
   *
   * @return Channel credentials list
   * @since 1.0
   */
  Collection<ConversationChannel<? extends Credentials>> getChannelCredentials();

  /**
   * Specifies the amount of conversation metadata that's returned as part of each callback.
   *
   * @return Type of metadata report
   * @since 1.0
   */
  ConversationMetadataReportViewType getMetadataReportView();

  /**
   * The name visible in the Sinch Dashboard
   *
   * @return Dashboard display name
   * @since 1.0
   */
  String getDisplayName();

  /**
   * The ID of the app.
   *
   * <p>You can find this on the Sinch Dashboard.
   *
   * @return App ID
   * @since 1.0
   */
  String getId();

  /**
   * Defined rate limits
   *
   * @return Rate limit
   * @since 1.0
   */
  RateLimits getRateLimits();

  /**
   * The retention policy specifies how long messages, sent to or from an app, are stored by the
   * Conversation API.
   *
   * @return Retention policy
   * @since 1.0
   */
  RetentionPolicy getRetentionPolicy();

  /**
   * The retention policy configured for messages in {@link ProcessingModeType#DISPATCH Dispatch
   * Mode}.
   *
   * <p>Currently only {@link
   * com.sinch.sdk.domains.conversation.models.RetentionPolicyType#MESSAGE_EXPIRE_POLICY
   * MESSAGE_EXPIRE_POLICY} is available.
   *
   * <p>or more information about retention policies, see <a href
   * ="https://developers.sinch.com/docs/conversation/keyconcepts/#retention-policy">Retention
   * Policy</a>.
   *
   * @return Dispatch retention policy details
   * @since 1.0
   */
  DispatchRetentionPolicy getDispatchRetentionPolicy();

  /**
   * Whether or not Conversation API should store contacts and conversations for the app
   *
   * @return Processing value
   * @since 1.0
   */
  ProcessingModeType getProcessingMode();

  /**
   * This object is required for apps that subscribe to Smart Conversations features
   *
   * @return Smart conversation value
   * @since 1.0
   */
  SmartConversation getSmartConversation();

  /**
   * Queue stats
   *
   * @return Queue stats value
   * @since 1.0
   */
  QueueStats getQueueStats();

  /**
   * TDB
   *
   * @return TBD
   * @since 1.0
   */
  PersistMessageStatus getPersistMessageStatus();

  /**
   * TDB
   *
   * @return TBD
   * @since 1.0
   */
  MessageSearch getMessageSearch();

  /**
   * TDB
   *
   * @return TBD
   * @since 1.0
   */
  CallbackSettings getCallbackSettings();

  /**
   * TDB
   *
   * @return TBD
   * @since 1.0
   */
  DeliveryReportBasedFallback getDeliveryReportBasedFallback();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.AppBuilder();
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
     * @see App#getChannelCredentials()
     * @since 1.0
     */
    Builder setChannelCredentials(
        Collection<ConversationChannel<? extends Credentials>> channelCredentials);

    /**
     * see getter
     *
     * @param metadataReportView see getter
     * @return Current builder
     * @see App#getMetadataReportView()
     * @since 1.0
     */
    Builder setMetadataReportView(ConversationMetadataReportViewType metadataReportView);

    /**
     * see getter
     *
     * @param displayName see getter
     * @return Current builder
     * @see App#getDisplayName()
     * @since 1.0
     */
    Builder setDisplayName(String displayName);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see App#getId()
     * @since 1.0
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param rateLimits see getter
     * @return Current builder
     * @see App#getRateLimits()
     * @since 1.0
     */
    Builder setRateLimits(RateLimits rateLimits);

    /**
     * see getter
     *
     * @param retentionPolicy see getter
     * @return Current builder
     * @see App#getRetentionPolicy()
     * @since 1.0
     */
    Builder setRetentionPolicy(RetentionPolicy retentionPolicy);

    /**
     * see getter
     *
     * @param dispatchRetentionPolicy see getter
     * @return Current builder
     * @see App#getDispatchRetentionPolicy()
     * @since 1.0
     */
    Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see App#getProcessingMode()
     * @since 1.0
     */
    Builder setProcessingMode(ProcessingModeType processingMode);

    /**
     * see getter
     *
     * @param smartConversation see getter
     * @return Current builder
     * @see App#getSmartConversation()
     * @since 1.0
     */
    Builder setSmartConversation(SmartConversation smartConversation);

    /**
     * see getter
     *
     * @param queueStats see getter
     * @return Current builder
     * @see App#getQueueStats()
     * @since 1.0
     */
    Builder setQueueStats(QueueStats queueStats);

    /**
     * see getter
     *
     * @param persistMessageStatus see getter
     * @return Current builder
     * @see App#getPersistMessageStatus()
     * @since 1.0
     */
    Builder setPersistMessageStatus(PersistMessageStatus persistMessageStatus);

    /**
     * see getter
     *
     * @param messageSearch see getter
     * @return Current builder
     * @see App#getMessageSearch()
     * @since 1.0
     */
    Builder setMessageSearch(MessageSearch messageSearch);

    /**
     * see getter
     *
     * @param callbackSettings see getter
     * @return Current builder
     * @see App#getCallbackSettings()
     * @since 1.0
     */
    Builder setCallbackSettings(CallbackSettings callbackSettings);

    /**
     * see getter
     *
     * @param deliveryReportBasedFallback see getter
     * @return Current builder
     * @see App#getDeliveryReportBasedFallback()
     * @since 1.0
     */
    Builder setDeliveryReportBasedFallback(DeliveryReportBasedFallback deliveryReportBasedFallback);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    App build();
  }
}
