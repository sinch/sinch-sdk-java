package com.sinch.sdk.domains.conversation.models.v1.events.request;

import java.util.Optional;

/**
 * Parameters request to list events
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Events/#tag/Events/operation/Events_ListEvents">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface EventsListRequest {

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
   * Maximum number of events to fetch.
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

  static Builder builder() {
    return new EventsListRequestImpl.Builder();
  }

  static Builder builder(EventsListRequest parameters) {
    return new EventsListRequestImpl.Builder(parameters);
  }

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

    EventsListRequest build();
  }
}
