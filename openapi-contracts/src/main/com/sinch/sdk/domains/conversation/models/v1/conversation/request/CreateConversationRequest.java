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

package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;

/** The conversation to create. */
@JsonDeserialize(builder = CreateConversationRequestImpl.Builder.class)
public interface CreateConversationRequest {

  /**
   * Flag for whether this conversation is active.
   *
   * @return active
   */
  Boolean getActive();

  /**
   * Get activeChannel
   *
   * @return activeChannel
   */
  ConversationChannel getActiveChannel();

  /**
   * The ID of the participating app.
   *
   * @return appId
   */
  String getAppId();

  /**
   * The ID of the participating contact.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * The ID of the conversation.
   *
   * @return id
   */
  String getId();

  /**
   * Arbitrary data set by the Conversation API clients. Up to 1024 characters long.
   *
   * @return metadata
   */
  String getMetadata();

  /**
   * Arbitrary data set by the Conversation API clients and/or provided in the <code>
   * conversation_metadata</code> field of a SendMessageRequest. A valid JSON object.
   *
   * @return metadataJson
   */
  Object getMetadataJson();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CreateConversationRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param active see getter
     * @return Current builder
     * @see #getActive
     */
    Builder setActive(Boolean active);

    /**
     * see getter
     *
     * @param activeChannel see getter
     * @return Current builder
     * @see #getActiveChannel
     */
    Builder setActiveChannel(ConversationChannel activeChannel);

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId
     */
    Builder setAppId(String appId);

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see #getContactId
     */
    Builder setContactId(String contactId);

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
     * @param metadata see getter
     * @return Current builder
     * @see #getMetadata
     */
    Builder setMetadata(String metadata);

    /**
     * see getter
     *
     * @param metadataJson see getter
     * @return Current builder
     * @see #getMetadataJson
     */
    Builder setMetadataJson(Object metadataJson);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CreateConversationRequest build();
  }
}
