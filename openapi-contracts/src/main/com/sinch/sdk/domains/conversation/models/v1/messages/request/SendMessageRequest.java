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

package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageMessage;
import com.sinch.sdk.domains.conversation.models.v1.request.MessageQueue;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.List;
import java.util.Map;

/**
 * This is the request body for sending a message. &#x60;app_id&#x60;, &#x60;recipient&#x60;, and
 * &#x60;message&#x60; are all required fields.
 */
@JsonDeserialize(builder = SendMessageRequestImpl.Builder.class)
public interface SendMessageRequest<T extends AppMessageMessage> {

  /**
   * The ID of the app sending the message.
   *
   * @return appId
   */
  String getAppId();

  /**
   * Overwrites the default callback url for delivery receipts for this message The REST URL should
   * be of the form: &#x60;http://host[:port]/path&#x60;
   *
   * @return callbackUrl
   */
  String getCallbackUrl();

  /**
   * Explicitly define the channels and order in which they are tried when sending the message. All
   * channels provided in this field must be configured in the corresponding Conversation API app,
   * or the request will be rejected. Which channels the API will try and their priority is defined
   * by: 1. &#x60;channel_priority_order&#x60; if available. 2.
   * &#x60;recipient.identified_by.channel_identities&#x60; if available. 3. When recipient is a
   * &#x60;contact_id&#x60;: - if a conversation with the contact exists: the active channel of the
   * conversation is tried first. - the existing channels for the contact are ordered by contact
   * channel preferences if given. - lastly the existing channels for the contact are ordered by the
   * app priority.
   *
   * @return channelPriorityOrder
   */
  List<ConversationChannel> getChannelPriorityOrder();

  /**
   * Channel-specific properties. The key in the map must point to a valid channel property key as
   * defined by the enum ChannelPropertyKeys. The maximum allowed property value length is 1024
   * characters.
   *
   * @return channelProperties
   */
  Map<String, String> getChannelProperties();

  /**
   * Get message
   *
   * @return message
   */
  AppMessage<T> getMessage();

  /**
   * Metadata that should be associated with the message. Returned in the &#x60;metadata&#x60; field
   * of a [Message Delivery
   * Receipt](https://developers.sinch.com/docs/conversation/callbacks/#message-delivery-receipt).
   * Up to 1024 characters long.
   *
   * @return messageMetadata
   */
  String getMessageMetadata();

  /**
   * Metadata that should be associated with the conversation. This metadata will be propagated on
   * MO callbacks associated with this conversation. Up to 1024 characters long. Note that the MO
   * callback will always use the last metadata available in the conversation. Important notes: - If
   * you send a message with the &#x60;conversation_metadata&#x60; field populated, and then send
   * another message without populating the &#x60;conversation_metadata&#x60; field, the original
   * metadata will continue be propagated on the related MO callbacks. - If you send a message with
   * the &#x60;conversation_metadata&#x60; field populated, and then send another message with a
   * different value for &#x60;conversation_metadata&#x60; in the same conversation, the latest
   * metadata value overwrites the existing one. So, future MO callbacks will include the new
   * metadata. - The &#x60;conversation_metadata&#x60; only accepts json objects. Currently only
   * returned in the &#x60;message_metadata&#x60; field of an [Inbound
   * Message](/docs/conversation/callbacks/#inbound-message) callback.
   *
   * @return conversationMetadata
   */
  Object getConversationMetadata();

  /**
   * Get queue
   *
   * @return queue
   */
  MessageQueue getQueue();

  /**
   * Get recipient
   *
   * @return recipient
   */
  Recipient getRecipient();

  /**
   * The timeout allotted for sending the message, expressed in seconds. Passed to channels which
   * support it and emulated by the Conversation API for channels without ttl support but with
   * message retract/unsend functionality. Channel failover will not be performed for messages with
   * an expired TTL. The format is an integer with the suffix &#x60;s&#x60; (for seconds). Valid
   * integer range is 3 to 315,576,000,000 (inclusive). Example values include &#x60;10s&#x60; (10
   * seconds) and &#x60;86400s&#x60; (24 hours).
   *
   * @return ttl
   */
  Integer getTtl();

  /**
   * Get processingStrategy
   *
   * @return processingStrategy
   */
  ProcessingStrategy getProcessingStrategy();

  /**
   * An arbitrary identifier that will be propagated to callbacks related to this message, including
   * MO replies. Only applicable to messages sent with the &#x60;CONVERSATION&#x60; processing mode.
   * Up to 128 characters long.
   *
   * @return correlationId
   */
  String getCorrelationId();

  /**
   * Get conversationMetadataUpdateStrategy
   *
   * @return conversationMetadataUpdateStrategy
   */
  MetadataUpdateStrategy getConversationMetadataUpdateStrategy();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static <T extends AppMessageMessage> Builder<T> builder() {
    return new SendMessageRequestImpl.Builder<>();
  }

  /** Dedicated Builder */
  interface Builder<T extends AppMessageMessage> {

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId
     */
    Builder<T> setAppId(String appId);

    /**
     * see getter
     *
     * @param callbackUrl see getter
     * @return Current builder
     * @see #getCallbackUrl
     */
    Builder<T> setCallbackUrl(String callbackUrl);

    /**
     * see getter
     *
     * @param channelPriorityOrder see getter
     * @return Current builder
     * @see #getChannelPriorityOrder
     */
    Builder<T> setChannelPriorityOrder(List<ConversationChannel> channelPriorityOrder);

    /**
     * see getter
     *
     * @param channelProperties see getter
     * @return Current builder
     * @see #getChannelProperties
     */
    Builder<T> setChannelProperties(Map<String, String> channelProperties);

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder<T> setMessage(AppMessage<T> message);

    /**
     * see getter
     *
     * @param messageMetadata see getter
     * @return Current builder
     * @see #getMessageMetadata
     */
    Builder<T> setMessageMetadata(String messageMetadata);

    /**
     * see getter
     *
     * @param conversationMetadata see getter
     * @return Current builder
     * @see #getConversationMetadata
     */
    Builder<T> setConversationMetadata(Object conversationMetadata);

    /**
     * see getter
     *
     * @param queue see getter
     * @return Current builder
     * @see #getQueue
     */
    Builder<T> setQueue(MessageQueue queue);

    /**
     * see getter
     *
     * @param recipient see getter
     * @return Current builder
     * @see #getRecipient
     */
    Builder<T> setRecipient(Recipient recipient);

    /**
     * see getter
     *
     * @param ttl see getter
     * @return Current builder
     * @see #getTtl
     */
    Builder<T> setTtl(Integer ttl);

    /**
     * see getter
     *
     * @param processingStrategy see getter
     * @return Current builder
     * @see #getProcessingStrategy
     */
    Builder<T> setProcessingStrategy(ProcessingStrategy processingStrategy);

    /**
     * see getter
     *
     * @param correlationId see getter
     * @return Current builder
     * @see #getCorrelationId
     */
    Builder<T> setCorrelationId(String correlationId);

    /**
     * see getter
     *
     * @param conversationMetadataUpdateStrategy see getter
     * @return Current builder
     * @see #getConversationMetadataUpdateStrategy
     */
    Builder<T> setConversationMetadataUpdateStrategy(
        MetadataUpdateStrategy conversationMetadataUpdateStrategy);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SendMessageRequest<T> build();
  }
}
