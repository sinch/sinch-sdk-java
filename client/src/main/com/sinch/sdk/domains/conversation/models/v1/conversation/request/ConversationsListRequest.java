package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Optional;

/**
 * Parameters request to list messages
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Conversation/#tag/Conversation/operation/Conversation_ListConversations">online
 *     documentation</a>
 * @since 1.3
 */
public interface ConversationsListRequest {

  /**
   * Filtering onto <code>active</code> conversations only or not
   *
   * <p>True if only active conversations should be listed.
   *
   * @return Only active filter
   */
  Optional<Boolean> getOnlyActive();

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
   * Maximum number of conversations to fetch.
   *
   * <p>Defaults to 10 and the maximum is 20.
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
   * Only fetch conversations from the active channel
   *
   * @return Channel to filtered on
   */
  Optional<ConversationChannel> getActiveChannel();

  static Builder builder() {
    return new ConversationsListRequestImpl.Builder();
  }

  static Builder builder(ConversationsListRequest parameters) {
    return new ConversationsListRequestImpl.Builder(parameters);
  }

  interface Builder {

    /**
     * see getter
     *
     * @param onlyActive see getter
     * @return Current builder
     * @see #setOnlyActive(Boolean) ()
     */
    Builder setOnlyActive(Boolean onlyActive);

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
     * @param channel see getter
     * @return Current builder
     * @see #getActiveChannel()
     */
    Builder setActiveChannel(ConversationChannel channel);

    ConversationsListRequest build();
  }
}
