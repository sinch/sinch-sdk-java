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

package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** declaration */
@JsonDeserialize(builder = ListMessageListMessageImpl.Builder.class)
public interface ListMessageListMessage {

  /**
   * A title for the message that is displayed near the products or choices.
   *
   * @return title
   */
  String getTitle();

  /**
   * This is an optional field, containing a description for the message.
   *
   * @return description
   */
  String getDescription();

  /**
   * List of ListSection objects containing choices to be presented in the list message.
   *
   * @return sections
   */
  List<ListSection> getSections();

  /**
   * Get messageProperties
   *
   * @return messageProperties
   */
  ListMessageListMessageMessageProperties getMessageProperties();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListMessageListMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param title see getter
     * @return Current builder
     * @see #getTitle
     */
    Builder setTitle(String title);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param sections see getter
     * @return Current builder
     * @see #getSections
     */
    Builder setSections(List<ListSection> sections);

    /**
     * see getter
     *
     * @param messageProperties see getter
     * @return Current builder
     * @see #getMessageProperties
     */
    Builder setMessageProperties(ListMessageListMessageMessageProperties messageProperties);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListMessageListMessage build();
  }
}