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

package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessage;
import java.util.List;

/** declaration */
@JsonDeserialize(builder = ListMessagesResponseImpl.Builder.class)
public interface ListMessagesResponse {

  /**
   * List of messages associated to the referenced conversation.
   *
   * @return messages
   */
  List<ConversationMessage> getMessages();

  /**
   * Token that should be included in the next request to fetch the next page.
   *
   * @return nextPageToken
   */
  String getNextPageToken();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListMessagesResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param messages see getter
     * @return Current builder
     * @see #getMessages
     */
    Builder setMessages(List<ConversationMessage> messages);

    /**
     * see getter
     *
     * @param nextPageToken see getter
     * @return Current builder
     * @see #getNextPageToken
     */
    Builder setNextPageToken(String nextPageToken);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListMessagesResponse build();
  }
}
