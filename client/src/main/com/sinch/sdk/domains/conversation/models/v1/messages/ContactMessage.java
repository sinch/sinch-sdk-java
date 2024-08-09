package com.sinch.sdk.domains.conversation.models.v1.messages;

/**
 * Message originating from a Contact
 *
 * @param <T> Body type for message
 * @since _NEXT_VERSION_
 */
public interface ContactMessage<T extends ContactMessageBody> extends ConversationMessageBody {

  /**
   * Get message body
   *
   * @return Message body
   */
  T getBody();

  /**
   * @see ReplyTo
   * @return reply to
   */
  ReplyTo getReplyTo();

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static <T extends ContactMessageBody> Builder<T> builder() {
    return new ContactMessageImpl.Builder<>();
  }

  /** Dedicated Builder */
  interface Builder<T extends ContactMessageBody> {

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getBody()
     */
    Builder<T> setBody(T message);

    /**
     * see getter
     *
     * @param replyTo see getter
     * @return Current builder
     * @see #getReplyTo()
     */
    Builder<T> setReplyTo(ReplyTo replyTo);

    ContactMessage<T> build();
  }
}
