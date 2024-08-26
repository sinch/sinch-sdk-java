/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.contact;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.List;

/**
 * A participant in a conversation typically representing a person. It is associated with a
 * collection of channel identities.
 */
@JsonDeserialize(builder = ContactImpl.Builder.class)
public interface Contact {

  /**
   * List of channel identities.
   *
   * @return channelIdentities
   */
  List<ChannelIdentity> getChannelIdentities();

  /**
   * List of channels defining the channel priority.
   *
   * @return channelPriority
   */
  List<ConversationChannel> getChannelPriority();

  /**
   * The display name. A default 'Unknown' will be assigned if left empty.
   *
   * @return displayName
   */
  String getDisplayName();

  /**
   * Email of the contact.
   *
   * @return email
   */
  String getEmail();

  /**
   * Contact identifier in an external system.
   *
   * @return externalId
   */
  String getExternalId();

  /**
   * The ID of the contact.
   *
   * @return id
   */
  String getId();

  /**
   * Get language
   *
   * @return language
   */
  ContactLanguage getLanguage();

  /**
   * Metadata associated with the contact. Up to 1024 characters long.
   *
   * @return metadata
   */
  String getMetadata();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ContactImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param channelIdentities see getter
     * @return Current builder
     * @see #getChannelIdentities
     */
    Builder setChannelIdentities(List<ChannelIdentity> channelIdentities);

    /**
     * see getter
     *
     * @param channelPriority see getter
     * @return Current builder
     * @see #getChannelPriority
     */
    Builder setChannelPriority(List<ConversationChannel> channelPriority);

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
     * @param email see getter
     * @return Current builder
     * @see #getEmail
     */
    Builder setEmail(String email);

    /**
     * see getter
     *
     * @param externalId see getter
     * @return Current builder
     * @see #getExternalId
     */
    Builder setExternalId(String externalId);

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
     * @param language see getter
     * @return Current builder
     * @see #getLanguage
     */
    Builder setLanguage(ContactLanguage language);

    /**
     * see getter
     *
     * @param metadata see getter
     * @return Current builder
     * @see #getMetadata
     */
    Builder setMetadata(String metadata);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Contact build();
  }
}
