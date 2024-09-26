package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.domains.conversation.api.v1.MessagesService.MessageSource;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.time.Instant;
import java.util.Optional;

/**
 * Parameters request to list messages
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Messages/#tag/Messages/operation/Messages_ListMessages">online
 *     documentation</a>
 * @since 1.3
 */
public interface MessagesListRequest {

  /**
   * Resource name (ID) of the conversation.
   *
   * @return conversation id
   */
  Optional<String> getConversationId();

  /**
   * Resource name (ID) of the contact.
   *
   * <p>Note that either <code>app_id</code> or <code>contact_id</code> is required in order for the
   * operation to function correctly.
   *
   * @return contact id
   */
  Optional<String> getContactId();

  /**
   * Id of the application.
   *
   * <p>Note that either <code>app_id</code> or <code>contact_id</code> is required in order for the
   * operation to function correctly.
   *
   * @return application id
   */
  Optional<String> getAppId();

  /**
   * Channel identity of the contact.
   *
   * @return Channel identity
   */
  Optional<String> getChannelIdentity();

  /**
   * Filter messages with accept_time after this timestamp.
   *
   * <p>Must be before end_time if that is specified.
   *
   * @return Start time
   */
  Optional<Instant> getStartTime();

  /**
   * Filter messages with accept_time before this timestamp.
   *
   * @return End time
   */
  Optional<Instant> getEndTime();

  /**
   * Maximum number of messages to fetch.
   *
   * <p>Defaults to 10 and the maximum is 1000.
   *
   * @default 10
   * @return Page size
   */
  Optional<Integer> getPageSize();

  /**
   * Next page token previously returned if any.
   *
   * <p>When specifying this token, make sure to use the same values for the other parameters from
   * the request that originated the token, otherwise the paged results may be inconsistent.
   *
   * @return Page token
   */
  Optional<String> getPageToken();

  /**
   * @return view
   */
  Optional<ConversationMessagesView> getView();

  /**
   * Specifies the message source for which the request will be processed. Used for operations on
   * messages in Dispatch Mode. For more information, see <a
   * href="https://developers.sinch.com/docs/conversation/processing-modes">Processing Modes</a>
   *
   * @default <code>CONVERSATION_SOURCE</code>
   * @return Messages sources
   */
  Optional<MessageSource> getMessagesSource();

  /**
   * If true, fetch only recipient originated messages. Available only when <code>messages_source
   * </code> is <code>DISPATCH_SOURCE</code>.
   *
   * @return only recipient originated value
   */
  Optional<Boolean> getOnlyRecipientOriginated();

  /**
   * Only fetch messages from the <code>channel</code>
   *
   * @return Channel to filtered on
   */
  Optional<ConversationChannel> getChannel();

  static Builder builder() {
    return new MessagesListRequestImpl.Builder();
  }

  static Builder builder(MessagesListRequest parameters) {
    return new MessagesListRequestImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param conversationId see getter
     * @return Current builder
     * @see #getConversationId()
     */
    Builder setConversationId(String conversationId);

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see #getContactId()
     */
    Builder setContactId(String contactId);

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId()
     */
    Builder setAppId(String appId);

    /**
     * see getter
     *
     * @param channelIdentity see getter
     * @return Current builder
     * @see #getChannelIdentity()
     */
    Builder setChannelIdentity(String channelIdentity);

    /**
     * see getter
     *
     * @param startTime see getter
     * @return Current builder
     * @see #setStartTime
     */
    Builder setStartTime(Instant startTime);

    /**
     * see getter
     *
     * @param endTime see getter
     * @return Current builder
     * @see #getEndTime()
     */
    Builder setEndTime(Instant endTime);

    /**
     * see getter
     *
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize()
     */
    Builder setPageSize(Integer pageSize);

    /**
     * see getter
     *
     * @param pageToken see getter
     * @return Current builder
     * @see #getPageToken()
     */
    Builder setPageToken(String pageToken);

    /**
     * see getter
     *
     * @param view see getter
     * @return Current builder
     * @see #getView()
     */
    Builder setView(ConversationMessagesView view);

    /**
     * see getter
     *
     * @param source see getter
     * @return Current builder
     * @see #getMessagesSource()
     */
    Builder setMessagesSource(MessageSource source);

    /**
     * see getter
     *
     * @param onlyRecipientOriginated see getter
     * @return Current builder
     * @see #getOnlyRecipientOriginated()
     */
    Builder setOnlyRecipientOriginated(Boolean onlyRecipientOriginated);

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see #getChannel()
     */
    Builder setChannel(ConversationChannel channel);

    MessagesListRequest build();
  }
}
