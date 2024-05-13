/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.app.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.app.CallbackSettings;
import com.sinch.sdk.domains.conversation.models.v1.app.ConversationMetadataReportView;
import com.sinch.sdk.domains.conversation.models.v1.app.DeliveryReportBasedFallback;
import com.sinch.sdk.domains.conversation.models.v1.app.DispatchRetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.app.MessageRetrySettings;
import com.sinch.sdk.domains.conversation.models.v1.app.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.v1.app.SmartConversation;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import java.util.List;

/** The response showing information about the app. */
@JsonDeserialize(builder = AppResponseImpl.Builder.class)
public interface AppResponse {

  /**
   * Get channelCredentials
   *
   * @return channelCredentials
   */
  List<ConversationChannelCredentials> getChannelCredentials();

  /**
   * Get conversationMetadataReportView
   *
   * @return conversationMetadataReportView
   */
  ConversationMetadataReportView getConversationMetadataReportView();

  /**
   * The display name for the app.
   *
   * @return displayName
   */
  String getDisplayName();

  /**
   * The ID of the app. You can find this on the [Sinch
   * Dashboard](https://dashboard.sinch.com/convapi/apps).
   *
   * @return id
   */
  String getId();

  /**
   * Get rateLimits
   *
   * @return rateLimits
   */
  RateLimits getRateLimits();

  /**
   * Get retentionPolicy
   *
   * @return retentionPolicy
   */
  RetentionPolicy getRetentionPolicy();

  /**
   * Get dispatchRetentionPolicy
   *
   * @return dispatchRetentionPolicy
   */
  DispatchRetentionPolicy getDispatchRetentionPolicy();

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  ProcessingMode getProcessingMode();

  /**
   * Get smartConversation
   *
   * @return smartConversation
   */
  SmartConversation getSmartConversation();

  /**
   * Get queueStats
   *
   * @return queueStats
   */
  QueueStats getQueueStats();

  /**
   * Get callbackSettings
   *
   * @return callbackSettings
   */
  CallbackSettings getCallbackSettings();

  /**
   * Get deliveryReportBasedFallback
   *
   * @return deliveryReportBasedFallback
   */
  DeliveryReportBasedFallback getDeliveryReportBasedFallback();

  /**
   * Get messageRetrySettings
   *
   * @return messageRetrySettings
   */
  MessageRetrySettings getMessageRetrySettings();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AppResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param channelCredentials see getter
     * @return Current builder
     * @see #getChannelCredentials
     */
    Builder setChannelCredentials(List<ConversationChannelCredentials> channelCredentials);

    /**
     * see getter
     *
     * @param conversationMetadataReportView see getter
     * @return Current builder
     * @see #getConversationMetadataReportView
     */
    Builder setConversationMetadataReportView(
        ConversationMetadataReportView conversationMetadataReportView);

    /**
     * see getter
     *
     * @param displayName see getter
     * @return Current builder
     * @see #getDisplayName
     */
    Builder setDisplayName(String displayName);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param rateLimits see getter
     * @return Current builder
     * @see #getRateLimits
     */
    Builder setRateLimits(RateLimits rateLimits);

    /**
     * see getter
     *
     * @param retentionPolicy see getter
     * @return Current builder
     * @see #getRetentionPolicy
     */
    Builder setRetentionPolicy(RetentionPolicy retentionPolicy);

    /**
     * see getter
     *
     * @param dispatchRetentionPolicy see getter
     * @return Current builder
     * @see #getDispatchRetentionPolicy
     */
    Builder setDispatchRetentionPolicy(DispatchRetentionPolicy dispatchRetentionPolicy);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see #getProcessingMode
     */
    Builder setProcessingMode(ProcessingMode processingMode);

    /**
     * see getter
     *
     * @param smartConversation see getter
     * @return Current builder
     * @see #getSmartConversation
     */
    Builder setSmartConversation(SmartConversation smartConversation);

    /**
     * see getter
     *
     * @param queueStats see getter
     * @return Current builder
     * @see #getQueueStats
     */
    Builder setQueueStats(QueueStats queueStats);

    /**
     * see getter
     *
     * @param callbackSettings see getter
     * @return Current builder
     * @see #getCallbackSettings
     */
    Builder setCallbackSettings(CallbackSettings callbackSettings);

    /**
     * see getter
     *
     * @param deliveryReportBasedFallback see getter
     * @return Current builder
     * @see #getDeliveryReportBasedFallback
     */
    Builder setDeliveryReportBasedFallback(DeliveryReportBasedFallback deliveryReportBasedFallback);

    /**
     * see getter
     *
     * @param messageRetrySettings see getter
     * @return Current builder
     * @see #getMessageRetrySettings
     */
    Builder setMessageRetrySettings(MessageRetrySettings messageRetrySettings);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AppResponse build();
  }
}